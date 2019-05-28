package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.config.redis.IRedisService;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.Constant;
import com.annaru.common.util.DateUtil;
import com.annaru.common.util.sdk.MessageUtils;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.service.*;
import com.annaru.upms.shiro.aouth2.TokenGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jodd.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

        String kaptcha = kaptcha();
        Map<String ,Object> isOk = MessageUtils.sendTemplateSMS(cellphoneNo, MessageUtils.loginId, kaptcha,"1");
        if (isOk != null && StringUtil.isNotBlank((String)isOk.get("statusCode"))){ // isOk != null && StringUtil.isNotBlank((String)isOk.get("statusCode"))
            if ("000000".equals((String)isOk.get("statusCode"))){ // "000000".equals((String)isOk.get("statusCode"))
                //验证码发送成功
                redisService.set(cellphoneNo, kaptcha);
                redisService.set(cellphoneNo, kaptcha, kaptchaSeconds);
                return ResultMap.ok("短信发送成功！");
            }else {
                return ResultMap.error("短信发送频繁！");
            }

        }
        return ResultMap.error("短信发送失败！");

    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/loginInfo")
    @RequiresPermissions("upms/userLogin/loginInfo")
    public ResultMap loginInfo(String cellphoneNo, String password, String type, String loginType, String kaptcha){

        // loginType为1：验证码登录  loginType为2：账号密码登录
        if (StringUtil.isBlank(loginType) || (!"1".equals(loginType) && !"2".equals(loginType))){
            return ResultMap.error("请使用验证码或者账号密码登录！");
        }
        if (!("1").equals(type) && !"2".equals(type)){
            return ResultMap.error("端不存在！");
        }
        if (StringUtil.isBlank(cellphoneNo)){
            return ResultMap.error("账号不能为空！");
        }
        if ("1".equals(loginType)){
            if (StringUtil.isBlank(kaptcha)){
                return ResultMap.error("验证码不能为空！");
            }
            if (!kaptcha.equals((String)redisService.get(cellphoneNo))){
                return ResultMap.error("验证码无效！");
            }
        }
        if ("2".equals(loginType)){
            if (StringUtil.isBlank(password)){
                return ResultMap.error("密码不能为空！");
            }
        }

        Map<String, Object> map = new HashMap <>();
        map.put("cellphoneNo", cellphoneNo);
        UserBasic userBasic = iUserBasicService.selectByData(map);

        if ("2".equals(loginType)){
            //账号密码登录
            if (userBasic == null){
                return ResultMap.error("用户不存在！");
            }
            if (StringUtil.isNotBlank(userBasic.getPassword())){
                if (!password.equals(userBasic.getPassword())){
                    return ResultMap.error("账号或者密码输入错误，请检查！");
                }
            }
            if (userBasic.getIsactive().equals("0")){
                return ResultMap.error("用户未激活！");
            }
        }

        if ("1".equals(type)){ // 用户端短信注册并跳转设置密码页面
            if ("1".equals(loginType)){
                // 短信登录
                if (userBasic == null){
                    // 这个人第一次登录 则注册 保存相应用户信息
                    SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService , SysConfigUtil.USERNO);
                    UserBasic userBasic1 = new UserBasic();
                    userBasic1.setCellphoneNo(cellphoneNo); //手机号码
                    userBasic1.setUserId(SysConfigUtil.getNoBySysConfig()); //户用编号
                    userBasic1.setRegistrationTime(new Date());
                    userBasic1.setIsVerified(0); //是否有认证 1:认证/0:未认证
                    userBasic1.setCreationTime(new Date());
                    boolean isSave = iUserBasicService.save(userBasic1);
                    if (isSave){
                        // 修改系统配置的用户编号
                        SysConfigUtil.saveRefNo(sysConfig.getRefNo());
                    }
                    return ResultMap.ok("跳转设置密码页面！");
                }else {
                    if (StringUtil.isBlank(userBasic.getPassword())){
                        return ResultMap.ok("跳转设置密码页面！");
                    }
                }
            }
        }else if ("2".equals(type)){ // 医护端短因后台已经注册

        }


        //判断是否是首次登陆
        Boolean firstLogin = false;
        if (userBasic.getLastLogintime() == null){
            firstLogin = true;
        }
        //判断token
        String token = createToken(userBasic.getUserId()).get("token").toString();
        if (StringUtil.isNotBlank(token)){
            redisService.set("token", token, OUT_SECONDS);
        }
        //更新最后的登陆时间
        userBasic.setLastLogintime(new Date());
        iUserBasicService.updateById(userBasic);

        userBasic.setToken(token);
        userBasic.setFirstLogin(firstLogin);

        //用户
        if (("1").equals(type)){
            return ResultMap.ok().put("data", userBasic);
        }
        //医生
        if ("2".equals(type)){
            userBasic = iUserBasicService.selectDoctorByData(map);
            if (userBasic != null){
                userBasic.setToken(token);
                userBasic.setFirstLogin(firstLogin);
                userBasic.setDoctorOrNurse(1);
                return ResultMap.ok().put("data", userBasic);
            }
        }
        //护士
        if ("2".equals(type)){
            userBasic = iUserBasicService.selectNurseByData(map);
            if (userBasic != null){
                userBasic.setToken(token);
                userBasic.setFirstLogin(firstLogin);
                userBasic.setDoctorOrNurse(2);
                return ResultMap.ok().put("data", userBasic);
            }
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


}
