package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.config.redis.IRedisService;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.sdk.MessageUtils;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.entity.vo.UserExamMainDetail;
import com.annaru.upms.service.*;
import com.annaru.upms.shiro.aouth2.TokenGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jodd.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * APP端用户登录
 *
 * @author zk
 * @date 2019-05-10 11:19
 */
@Api(tags = {"APP端用户登录"}, description = "APP端用户登录")
@RestController
@RequestMapping("upms/UserLogin")
public class UserLoginController extends BaseController {

    @Autowired
    private IRedisService redisService;
    @Reference
    private IUserBasicService iUserBasicService; //用户
    @Reference
    private ISysUserTokenService userTokenService;
    @Reference
    private ISysConfigService iSysConfigService; //系统配置表

    private int OUT_SECONDS = 24*60*60*1000; //24小时  15*60*1000:15分钟
    private int kaptchaSeconds = 600; //10分钟

    @ApiOperation(value = "手机发送验证码")
    @PostMapping("/getKaptcha")
    public ResultMap getKaptcha(@ApiParam(value="手机号")@RequestParam String cellphoneNo) {

        if (StringUtil.isBlank(cellphoneNo)) {
            return ResultMap.error("手机号不能为空！");
        }
        if (!isTrue(cellphoneNo)){
            return ResultMap.error("请填入正确的手机号");
        }

//        String kaptcha = kaptcha();
//        Map<String ,Object> isOk = MessageUtils.sendTemplateSMS(cellphoneNo, MessageUtils.loginId, kaptcha,"1");
//        if (isOk != null && StringUtil.isNotBlank((String)isOk.get("statusCode"))){ // isOk != null && StringUtil.isNotBlank((String)isOk.get("statusCode"))
//            if ("000000".equals((String)isOk.get("statusCode"))){ // "000000".equals((String)isOk.get("statusCode"))
//                //验证码发送成功
//                redisService.set(cellphoneNo, kaptcha);
//                redisService.set(cellphoneNo, kaptcha, kaptchaSeconds);
//                return ResultMap.ok("短信发送成功！");
//            }else {
//                return ResultMap.error("短信发送频繁！");
//            }
//        }
//        return ResultMap.error("短信发送失败！");
        String kaptcha = "123";
        redisService.set(cellphoneNo, kaptcha, kaptchaSeconds);
        return ResultMap.ok("短信发送成功！");

    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/loginInfo")
    @RequiresPermissions("upms/userLogin/loginInfo")
    public ResultMap loginInfo(String cellphoneNo, String password, String type, String loginType, String kaptcha, String openid, String isHr){
        if (StringUtil.isNotBlank(loginType) && ("1".equals(loginType) || "2".equals(loginType))){
            // 先直接短信判断为123
            redisService.set(cellphoneNo, "123");
        }
        UserBasic userBasic = null;
        String token = null;
        Map<String, Object> map = null;

        // HR登录
        if (StringUtil.isNotBlank(isHr) && "y".equals(isHr)){
            if (StringUtil.isBlank(cellphoneNo)){
                return ResultMap.error(10,"账号不能为空！");
            }
            if (!isTrue(cellphoneNo)){
                return ResultMap.error(11,"请填入正确的手机号");
            }
            if (StringUtil.isBlank(password)){
                return ResultMap.error(12,"密码不能为空！");
            }
            Map<String, Object> mapHr = new HashMap <>();
            mapHr.put("cellphoneNo", cellphoneNo);
            mapHr.put("isHr", 1);
            userBasic = iUserBasicService.selectByData(mapHr);
            if (userBasic == null){
                return ResultMap.error(13,"用户不存在！");
            }
            if (StringUtil.isBlank(userBasic.getPassword())){
                return ResultMap.error(14,"账号或者密码输入错误，请检查！");
            }
            if (!password.equals(userBasic.getPassword())){
                return ResultMap.error(14,"账号或者密码输入错误，请检查！");
            }
            if (userBasic.getIsactive() == 0){
                return ResultMap.error(15,"HR未激活！");
            }
        }else {
            // loginType为1：验证码登录  loginType为2：账号密码登录  loginType为3：微信登录
            if (StringUtil.isBlank(loginType) || (!"1".equals(loginType) && !"2".equals(loginType) && !"3".equals(loginType))){
                return ResultMap.error(16,"请使用验证码或者账号密码登录或微信登录！");
            }
            if (!("1").equals(type) && !"2".equals(type)){
                return ResultMap.error(17,"端不存在！");
            }
            if ("1".equals(loginType) || "2".equals(loginType)){
                if (StringUtil.isBlank(cellphoneNo)){
                    return ResultMap.error(10,"账号不能为空！");
                }
                if (!isTrue(cellphoneNo)){
                    return ResultMap.error(11,"请填入正确的手机号");
                }
            }
            if ("1".equals(loginType)){
                if (StringUtil.isBlank(kaptcha)){
                    return ResultMap.error(18,"验证码不能为空！");
                }
                if (!kaptcha.equals((String)redisService.get(cellphoneNo))){
                    return ResultMap.error(19,"验证码无效！");
                }
            }
            if ("2".equals(loginType)){
                if (StringUtil.isBlank(password)){
                    return ResultMap.error(12,"密码不能为空！");
                }
            }
            if ("3".equals(loginType)){
                if (StringUtil.isBlank(openid)){
                    return ResultMap.error(20,"openid不能为空！");
                }
            }

            if (!"3".equals(loginType)){
                map = new HashMap <>();
                map.put("cellphoneNo", cellphoneNo);
                userBasic = iUserBasicService.selectByData(map);
            }
            if ("3".equals(loginType)){
                map = new HashMap <>();
                map.put("openid", openid);
                userBasic = iUserBasicService.selectByData(map);
            }

            if ("2".equals(loginType)){
                //账号密码登录
                if (userBasic == null){
                    return ResultMap.error(13,"用户不存在！");
                }
                if (StringUtil.isBlank(userBasic.getPassword())){
                    return ResultMap.error(14,"账号或者密码输入错误，请检查！");
                }
                if (!password.equals(userBasic.getPassword())){
                    return ResultMap.error(14,"账号或者密码输入错误，请检查！");
                }
            }

            if ("1".equals(loginType) || "3".equals(loginType)){
                int pd = 0;
                // 1.短信登录  3.微信登录
                if (userBasic == null){
                    // 如果微信第一次绑定手机号，则通过短信验证，判断验证码
                    if ("3".equals(loginType)){
                        if (StringUtil.isBlank(cellphoneNo)){
                            return ResultMap.error(21,"该微信号没有手机号绑定，请输入手机号！");
                        }
                        if (StringUtil.isBlank(kaptcha)){
                            return ResultMap.error(18,"验证码不能为空！");
                        }
                        if (!kaptcha.equals((String)redisService.get(cellphoneNo))){
                            return ResultMap.error(19,"验证码无效！");
                        }
                        Map<String, Object> map1 = new HashMap <>();
                        map1.put("cellphoneNo", cellphoneNo);

                        if (iUserBasicService.selectByData(map1) != null){
//                           return ResultMap.error("此手机号已被绑定！");

                            //改为 如果如果没有这个openId的用户  若果有这个手机号的用户  则修改这个手机号的openId 2019-7-9
                            Map<String ,Object> map2 = new HashMap<>();
                            map2.put("sysId", iUserBasicService.selectByData(map1).getSysId());
                            map2.put("openid", openid);
                            if (iUserBasicService.updateBySysId(map2)){
                                pd = 1;
                                map = new HashMap <>();
                                map.put("openid", openid);
                                userBasic = iUserBasicService.selectByData(map);
                            }
                        }
                    }
                    if (pd != 1){
                        // 这个人第一次登录 则注册 保存相应用户信息
                        SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService , SysConfigUtil.USERNO);
                        UserBasic userBasic1 = new UserBasic();
                        if ("3".equals(loginType)){
                            // 如果是微信直接登录，则需要添加openid，添加最后一次登陆时间
                            userBasic1.setOpenid(openid);
                        }
                        userBasic1.setCellphoneNo(cellphoneNo); //手机号码
                        userBasic1.setUserId(SysConfigUtil.getNoBySysConfig()); //户用编号
                        userBasic1.setRegistrationTime(new Date());
                        userBasic1.setIsVerified(0); //是否有认证 1:认证/0:未认证
                        userBasic1.setCreationTime(new Date());
                        userBasic1.setLastLogintime(new Date());
                        boolean isSave = iUserBasicService.save(userBasic1);
                        if (isSave){ // 此处保存成功 添加到融云
                            // 修改系统配置的用户编号
                            if (SysConfigUtil.saveRefNo(sysConfig.getRefNo())){
                                map = new HashMap <>();
                                map.put("cellphoneNo", cellphoneNo);
                                userBasic = iUserBasicService.selectByData(map);
                                // 如果是微信登录，则设置token，直接登录
                                token = createToken(userBasic.getUserId()).get("token").toString();
                                if (StringUtil.isNotBlank(token)){
                                    redisService.set(cellphoneNo, token, OUT_SECONDS);
                                }
                                userBasic.setToken(token);
                                userBasic.setFirstLogin(true);
                                //查询是否拥有企业服务
                                userBasic.setEntityHealthy(iUserBasicService.selectEntityHealthy(userBasic.getUserId()));
                                return ResultMap.ok().put("data", userBasic);
                            }
                        }
                    }
                }
            }
        }

        if (userBasic.getIsactive() == 0){
            return ResultMap.error(22,"用户未激活！");
        }
        //判断是否是首次登陆
        Boolean firstLogin = false;
        if (userBasic.getLastLogintime() == null){
            firstLogin = true;
        }
        //判断token
        token = createToken(userBasic.getUserId()).get("token").toString();
        if (StringUtil.isNotBlank(token)){
            redisService.set(userBasic.getCellphoneNo(), token, OUT_SECONDS);
        }
        //更新最后的登陆时间
        userBasic.setLastLogintime(new Date());
        iUserBasicService.updateLastTimeBySysId(userBasic);

        userBasic.setToken(token);
        userBasic.setFirstLogin(firstLogin);
        //查询是否拥有企业服务
        userBasic.setEntityHealthy(iUserBasicService.selectEntityHealthy(userBasic.getUserId()));
        //用户
        if (("1").equals(type)){
            // 如果是企业用户，则返回 企业用户的购买的服务的 产品编号 描述 开始时间 结束时间
            if (userBasic.isEntityHealthy()){
                Map<String, Object> params9 = new HashMap<>();
                params9.put("userId", userBasic.getUserId());
                List<UserExamMainDetail> userExamMainDetailList = iUserBasicService.getUserExamMainDetail(params9);
                if (userExamMainDetailList != null && userExamMainDetailList.size() > 0){
                    userBasic.setUserExamMainDetailList(userExamMainDetailList);
                }
            }
            return ResultMap.ok().put("data", userBasic);
        }
        boolean getDoctorNurse = true;
        UserBasic userBasic1 = userBasic;
        //医生
        if ("2".equals(type)){
            userBasic = iUserBasicService.selectDoctorByData(map);
            if (userBasic != null && userBasic.getSysDoctor().getDoctorNo() != null){
                if (userBasic.getIsactive() == 0){
                    return ResultMap.error(23,"医生未激活！");
                }
                userBasic.setToken(token);
                userBasic.setFirstLogin(firstLogin);
                userBasic.setDoctorOrNurse(1);
                getDoctorNurse = false;
                return ResultMap.ok().put("data", userBasic);
            }
        }
        //护士
        if ("2".equals(type)){
            userBasic = iUserBasicService.selectNurseByData(map);
            if (userBasic != null && userBasic.getSysNurse().getNurseNo() != null){
                if (userBasic.getIsactive() == 0){
                    return ResultMap.error(24,"护士未激活！");
                }
                userBasic.setToken(token);
                userBasic.setFirstLogin(firstLogin);
                userBasic.setDoctorOrNurse(2);
                getDoctorNurse = false;
                return ResultMap.ok().put("data", userBasic);
            }
        }
        // 医生或护士不存在 ，则返回用户信息
        if (getDoctorNurse){
            return ResultMap.ok().put("data", userBasic1);
        }
        return ResultMap.error("异常错误，请联系管理员");

    }

    @ApiOperation(value = "设置密码")
    @PostMapping("/setPassword")
    public ResultMap setPassword(@ApiParam(value="手机号")@RequestParam String cellphoneNo, @ApiParam(value="密码")@RequestParam String password) {

        if (StringUtil.isBlank(cellphoneNo)) {
            return ResultMap.error("手机号不能为空！");
        }
        if (StringUtil.isBlank(password)) {
            return ResultMap.error("密码不能为空！");
        }
        Map<String, Object> map = new HashMap <>();
        map.put("cellphoneNo", cellphoneNo);
        UserBasic userBasic = iUserBasicService.selectByData(map);
        if (userBasic == null){
            return ResultMap.error("请重新注册！");
        }
        userBasic.setPassword(password);
        boolean isUpdate = iUserBasicService.updateById(userBasic);
        if (isUpdate){
            return ResultMap.ok("设置密码成功！");
        }
        return ResultMap.error("设置密码失败！");

    }

    public ResultMap createToken(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + OUT_SECONDS);
        //判断是否生成过token
        SysUserToken tokenEntity = userTokenService.getById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //保存token
            userTokenService.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //更新token
            userTokenService.updateById(tokenEntity);
        }
        ResultMap r = ResultMap.ok().put("token", token).put("expire", OUT_SECONDS);
        return r;
    }

    /**
     * 生成6位验证码
     */
    public String kaptcha(){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        return result;
    }

    public boolean isTrue(String cellphoneNo){
        String regex="^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";// 验证手机号
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(cellphoneNo);
        if (m.matches()){
            return true;
        }
        return false;
    }

}
