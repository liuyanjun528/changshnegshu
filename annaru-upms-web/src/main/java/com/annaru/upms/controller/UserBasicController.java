package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.config.redis.IRedisService;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.common.result.UserBasicMenu;
import com.annaru.common.util.sdk.MessageUtils;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.service.IUserBasicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jodd.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.annaru.common.util.PinyinUtil.getPinYin;


/**
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Validated
@Api(tags = {"用户基础信息管理"}, description = "用户基础信息管理")
@RestController
@RequestMapping("upms/userBasic")
public class UserBasicController extends BaseController {
    @Reference
    private IUserBasicService userBasicService;

    @Reference
    private IUserBasicService iUserBasicService; //用户

    @Autowired
    private IRedisService redisService;

    public boolean isTrue(String cellphoneNo) {
        String regex = "^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";// 验证手机号
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(cellphoneNo);
        if (m.matches()) {
            return true;
        }
        return false;
    }

    @ApiOperation(value = "手机发送验证码更换手机号")
    @PostMapping("/getKaptchaUpdate")
    public ResultMap getKaptchaUpdate(@ApiParam(value = "手机号") @RequestParam String cellphoneNo) {

        if (!isTrue(cellphoneNo)) {
            return ResultMap.error("请填入正确的手机号");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("cellphoneNo", cellphoneNo);
        if (iUserBasicService.selectByData(params) != null) {
            return ResultMap.error("该手机号已被绑定！");
        }
        boolean b = sendTemplateSMS(cellphoneNo);
        if (b) {
            return ResultMap.ok("短信发送成功！");
        } else {
            return ResultMap.error("短信发送失败！");
        }
    }

    @ApiOperation(value = "修改手机号")
    @PostMapping("/updateCellphoneNoByUserId")
    public ResultMap updateCellphoneNoByUserId(Integer sysId, String cellphoneNo, String kaptcha) {

        try {
            if (sysId == null || StringUtil.isBlank(cellphoneNo)) {
                return ResultMap.error("系统编号或者手机号不能为空！");
            }
            if (StringUtil.isBlank(kaptcha)) {
                return ResultMap.error("验证码不能为空！");
            }
            if (!kaptcha.equals((String) redisService.get(cellphoneNo))) {
                return ResultMap.error("验证码无效！");
            }
            UserBasic userBasic = iUserBasicService.getById(sysId);
            if (userBasic != null) {
                if (cellphoneNo.equals(userBasic.getCellphoneNo())) {
                    return ResultMap.error("请输入要绑定的新手机号！");
                } else {
                    Map<String, Object> params = new HashMap<>();
                    params.put("cellphoneNo", cellphoneNo);
                    if (iUserBasicService.selectByData(params) != null) {
                        return ResultMap.error("该手机号已被绑定！");
                    } else {
                        userBasic.setCellphoneNo(cellphoneNo);
                        if (iUserBasicService.updateById(userBasic)) {
                            return ResultMap.ok("手机号修改成功！");
                        }
                    }
                }
            } else {
                return ResultMap.error("该用户不存在！");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
        return ResultMap.error("运行异常，请联系管理员");
    }


    /**
     * 生成6位验证码
     */
    public String kaptcha() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        return result;
    }

    private int kaptchaSeconds = 600; //10分钟

    @ApiOperation(value = "手机发送验证码")
    @PostMapping("/getKaptcha")
    public ResultMap getKaptcha(@ApiParam(value = "手机号") @RequestParam String cellphoneNo) {
        if (!isTrue(cellphoneNo)) {
            return ResultMap.error("请填入正确的手机号");
        }
        boolean b = sendTemplateSMS(cellphoneNo);
        if (b) {
            return ResultMap.ok("短信发送成功！");
        } else {
            return ResultMap.error("短信发送失败！");
        }
    }


    /**
     * 验证码 匹配、手机验证码修改旧密码
     */
    @ApiOperation(value = "手机验证码设置密码")
    @PostMapping("/setPassword")
    public ResultMap setPassword(String password, String kaptcha, String cellphoneNo) {
        if (StringUtil.isBlank(kaptcha)) {
            return ResultMap.error("验证码不能为空！");
        } else if (!kaptcha.equals((String) redisService.get(cellphoneNo))) {
            return ResultMap.error("验证码无效！");
        } else if (StringUtil.isBlank(password)) {
            return ResultMap.error("密码不能为空！");
        }
        int i = userBasicService.setPwd(password, cellphoneNo);
        if (i > 0) {
            return ResultMap.ok("密码更改成功！");
        }
        return ResultMap.error("密码更改失败！");

    }


    /**
     * 修改旧密码
     */
    @ApiOperation(value = "修改旧密码")
    @PostMapping("/updatePassword")
    //@RequiresPermissions("upms/userBasic/updatePassword")
    public ResultMap updatePassword(String password, String userId, String OldPwd) {

        UserBasic userBasic = userBasicService.selectByUid(userId);
        //如果输入的旧密码与旧密码相同 进行下一步
        if (OldPwd.equals(userBasic.getPassword())) {
            //如果输入的新密码与旧密码不同 进行下一步
            if (!password.equals(userBasic.getPassword())) {
                //修改密码
                userBasicService.updateOldPwd(password, userId);
                return ResultMap.ok("更新成功");
            }
            return ResultMap.error("新密码与老密码相同,请换一个新密码");
        } else {
            return ResultMap.error("输入的旧密码与旧密码不匹配,请想好再填");
        }

    }

    /**
     * @Description 根据userId或doctorNo得到医生详情
     * @Author zk
     * @Date: 2019-07-04
     */
    @ApiOperation(value = "根据userId或doctorNo得到医生详情", notes = "根据userId或doctorNo得到医生详情")
    @GetMapping("/getDoctorByUdD0")
    @RequiresPermissions("upms/sysDoctor/getDoctorByUdD0")
    public ResultMap getDoctorByUdD0(String doctorNo, String userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("doctorNo", doctorNo);
        params.put("userId", userId);
        UserBasic userBasic = userBasicService.selectDoctorByData(params);
        return ResultMap.ok().put("data", userBasic);
    }

//    /**
//     * @Description 根据userId或doctorNo得到护士详情
//     * @Author zk
//     * @Date: 2019-07-04
//     */
//    @ApiOperation(value = "根据userId或doctorNo得到护士详情", notes = "根据userId或doctorNo得到护士详情")
//    @GetMapping("/getNurseByUdD0")
//    @RequiresPermissions("upms/sysDoctor/getNurseByUdD0")
//    public ResultMap getNurseByUdD0(String doctorNo,String userId){
//        Map<String, Object> params = new HashMap<>();
//        params.put("doctorNo", doctorNo);
//        params.put("userId", userId);
//        UserBasic userBasic = userBasicService.selectNurseByData(params);
//        return ResultMap.ok().put("data",userBasic);
//    }


    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/userBasic/list")
    public ResultMap list(@ApiParam(value = "当前页") @RequestParam(defaultValue = "1") int page,
                          @ApiParam(value = "每页数量") @RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字") @RequestParam(required = false) String key) {

        Map<String, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = userBasicService.getDataPage(params);
        return ResultMap.ok().put("page", pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{userId}")
    @RequiresPermissions("upms/userBasic/info")
    public ResultMap info(@PathVariable("userId") String userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        UserBasic userBasic = userBasicService.selectByData(params);
        if (userBasic == null) {
            return ResultMap.error("该用户不存在！");
        }
        if (userBasic.getIsactive() == 0) {
            return ResultMap.error("该用户未激活！");
        }
        //查询是否拥有企业服务
        userBasic.setEntityHealthy(iUserBasicService.selectEntityHealthy(userBasic.getUserId()));
        return ResultMap.ok().put("data", userBasic);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/userBasic/save")
    public ResultMap save(@Valid @RequestBody UserBasic userBasic) {
        try {
            userBasic.setChineseSpell(getPinYin(userBasic.getFullName()));
            userBasicService.save(userBasic);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("upms/userBasic/update")
    public ResultMap update(@Valid @RequestBody UserBasic userBasic) {
        try {
            userBasicService.updateById(userBasic);
            return ResultMap.ok("修改成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


    /**
     * 上传授权图片的url
     *
     * @uthor zk
     * @date 2019-08-16
     */
    @ApiOperation(value = "上传授权图片的url")
    @PostMapping("/uploadAuthorizationUrl")
    public ResultMap uploadAuthorizationUrl(@RequestParam String userId, @RequestParam String authorizationUrl) {
        try {
            UserBasic userBasic = userBasicService.selectByUid(userId);
            if (userBasic == null) {
                return ResultMap.error("该用户不存在");
            }
            if (userBasicService.uploadAuthorizationUrl(userBasic.getSysId(), authorizationUrl)) {
                return ResultMap.ok("修改成功");
            }
            return ResultMap.ok("修改失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    @RequiresPermissions("upms/userBasic/delete")
    public ResultMap delete(@RequestBody Integer[] sysIds) {
        try {
            userBasicService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 查询支付密码是否设置
     */
    @ApiOperation(value = "查询支付密码是否设置")
    @PostMapping("/payment/pinnoStatus")
    public ResultMap paymentPinnoStatus(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return ResultMap.error(UserBasicMenu.USER_ID_NOT_NULL.getMessage());
        }
        return userBasicService.paymentPinnoStatus(userId);
    }

    /**
     * 设置支付密码
     */
    @ApiOperation(value = "设置支付密码")
    @PostMapping("/init/paymentPinno")
    public ResultMap initPaymentPinno(String userId, String paymentPinno) {
        if (StringUtils.isEmpty(userId)) {
            return ResultMap.error(UserBasicMenu.USER_ID_NOT_NULL.getMessage());
        }
        if (StringUtils.isEmpty(paymentPinno)) {
            return ResultMap.error(UserBasicMenu.PAYMENT_PINNO_NOT_NULL.getMessage());
        }
        return userBasicService.initPaymentPinno(userId, paymentPinno);
    }

    /**
     * 验证支付密码
     */
    @ApiOperation(value = "验证支付密码")
    @PostMapping("/verification/paymentPinno")
    public ResultMap verificationPaymentPinno(String userId, String paymentPinno) {
        if (StringUtils.isEmpty(userId)) {
            return ResultMap.error(UserBasicMenu.USER_ID_NOT_NULL.getMessage());
        }
        if (StringUtils.isEmpty(paymentPinno)) {
            return ResultMap.error(UserBasicMenu.PAYMENT_PINNO_NOT_NULL.getMessage());
        }
        return userBasicService.verificationPaymentPinno(userId, paymentPinno);
    }

    /**
     * 修改支付密码
     */
    @ApiOperation(value = "修改支付密码")
    @PostMapping("/update/paymentPinno")
    public ResultMap updatePaymentPinno(String userId, String paymentPinno) {
        if (StringUtils.isEmpty(userId)) {
            return ResultMap.error(UserBasicMenu.USER_ID_NOT_NULL.getMessage());
        }
        if (StringUtils.isEmpty(paymentPinno)) {
            return ResultMap.error(UserBasicMenu.PAYMENT_PINNO_NOT_NULL.getMessage());
        }
        return userBasicService.initPaymentPinno(userId, paymentPinno);
    }

    /**
     * 发送短信验证码
     *
     * @param cellphoneNo
     * @return
     */
    public boolean sendTemplateSMS(String cellphoneNo) {
        String kaptcha = kaptcha();
        Map<String, Object> isOk = MessageUtils.sendTemplateSMS(cellphoneNo, MessageUtils.loginId, kaptcha, "1");
        if (isOk != null && StringUtil.isNotBlank((String) isOk.get("statusCode"))) {
            if ("000000".equals((String) isOk.get("statusCode"))) {
                //验证码发送成功
                redisService.set(cellphoneNo, kaptcha, kaptchaSeconds);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 忘记支付密码发送手机验证码
     *
     * @param cellphoneNo
     * @param userId
     * @return
     */
    @ApiOperation(value = "忘记支付密码发送手机验证码")
    @PostMapping("/sendingSMS")
    public ResultMap sendingSMS(@ApiParam(value = "手机号") @RequestParam("cellphoneNo") String cellphoneNo,
                                @ApiParam(value = "userId") @RequestParam("userId") String userId
    ) {
        if (!isTrue(cellphoneNo)) {
            return ResultMap.error(UserBasicMenu.PHONENO_ERROR.getMessage());
        }
        //验证当前用户的手机号是否存在
        ResultMap resultMap = userBasicService.validated(userId, cellphoneNo);
        if (resultMap.get(UserBasicMenu.CODE.getMessage()).equals(UserBasicMenu.YON_HU_PHONENO_VALIDATED_OK.getCode())) {
            boolean b = sendTemplateSMS(cellphoneNo);
            if (b) {
                return ResultMap.ok(UserBasicMenu.MESSAGE_SENT_SUCCESS.getMessage());
            } else {
                return ResultMap.error(UserBasicMenu.MESSAGE_SENT_ERROR.getMessage());
            }
        } else {
            return resultMap;
        }
    }

    /**
     * @param userId
     * @param verificationCode
     * @return
     */
    @ApiOperation(value = "验证码修改支付密码")
    @PostMapping("/verificationCode/Update/paymentPinno")
    public ResultMap updateCellphoneNoByUserId(
            @ApiParam(value = "userId") @RequestParam("userId") String userId,
            @ApiParam(value = "手机号") @RequestParam("cellphoneNo") String cellphoneNo,
            @ApiParam(value = "验证码") @RequestParam("kaptcha") String verificationCode,
            @ApiParam(value = "新支付密码") @RequestParam("paymentPinno") String paymentPinno) {
        if (!isTrue(cellphoneNo)) {
            return ResultMap.error(UserBasicMenu.PHONENO_ERROR.getMessage());
        }
        if (!verificationCode.equals((String) redisService.get(cellphoneNo))) {
            return ResultMap.error(UserBasicMenu.VERIFICATION_CODE_EXPIRED.getMessage());
        } else {
            return userBasicService.initPaymentPinno(userId, paymentPinno);
        }
    }

}
