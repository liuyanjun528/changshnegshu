package com.annaru.upms.controller;//package com.annaru.upms.controller;
//
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.annaru.common.config.redis.IRedisService;
//import com.hdw.common.base.BaseController;
//import com.hdw.common.config.redis.IRedisService;
//import com.hdw.common.result.ResultMap;
//import com.hdw.common.util.Constant;
//import com.hdw.common.util.IPUtil;
//import com.hdw.upms.entity.repairs.RepairsLog;
//import com.hdw.upms.entity.repairs.RepairsUser;
//import com.hdw.upms.entity.repairs.RepairsUserToken;
//import com.hdw.upms.service.repairs.IRepairsLogService;
//import com.hdw.upms.service.repairs.IRepairsUserService;
//import com.hdw.upms.service.repairs.IRepairsUserTokenService;
//import com.hdw.upms.shiro.ShiroKit;
//import com.hdw.upms.shiro.ShiroUser;
//import com.hdw.upms.shiro.aouth2.TokenGenerator;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//
///**
// * @Description 登录退出Controller
// * @Author TuMinglong
// * @Date 2018/6/11 17:07
// */
//@Api(tags = "A登录、注册、退出")
//@RequestMapping("/repairs")
//@RestController
//public class RepairsLoginController extends BaseController {
//
//    @Reference
//    private IRepairsUserService repairsUserService;
//
//    @Reference
//    private IRepairsUserTokenService repairsUserTokenService;
//
//    @Reference
//    private IRepairsLogService repairsLogService;
//
//    @Autowired
//    private IRedisService redisService;
//
//    //365天过期
//    @Value("${token.expire}")
//    private long EXPIRE;
//
//    @Value("${file-upload.headimgurl}")
//    private String headimgurl;
//
//
//    @ApiOperation(value = "用户app登录")
//    @PostMapping("/login")
//    public ResultMap login(@ApiParam(value="手机号")@RequestParam String phone,
//                           @ApiParam(value="短信验证码")@RequestParam String captcha,
//                           @ApiParam(value="微信openID(公众号登录)")@RequestParam(required = false) String openid) {
//
//
//        if (StringUtils.isBlank(phone)) {
//            return ResultMap.error("手机号不能为空");
//        }
//        if (StringUtils.isBlank(captcha)) {
//            return ResultMap.error("验证码不能为空");
//        }
//        String validateCode = (String) redisService.get(phone);
//        logger.info("用户【" + phone + "】请求登录，短信验证码【"+ captcha +"】，session中的短信验证码【" + validateCode + "】");
//
//        if (StringUtils.isBlank(captcha) || StringUtils.isBlank(validateCode) || !captcha.equalsIgnoreCase(validateCode)) {
//            // return ResultMap.error("验证码错误");
//        }
//
//        RepairsUser user = repairsUserService.getByPhone(phone);
//        if (user == null) {
//            if (StringUtils.isNotBlank(openid)) {
//                user = repairsUserService.getByOpenid(openid);
//                if(user != null){
//                    user.setPhone(phone);
//                }
//            }
//        } else {
//            if(StringUtils.isNotBlank(openid)){
//                RepairsUser userByOpenid = repairsUserService.getByOpenid(openid);
//                if(userByOpenid != null){
//                    if(!user.getPhone().equals(userByOpenid.getPhone())){
//                        userByOpenid.setOpenid("");
//                        repairsUserService.updateById(userByOpenid);
//                    }
//                }
//                user.setOpenid(openid);
//            }
//        }
//        if (null == user) {
//            user = new RepairsUser();
//            user.setPhone(phone);
//            user.setName("用户_" + phone);
//            user.setHeadimg(headimgurl);
//            user.setLastLoginTime(new Date());
//            user.setCreateTime(new Date());
//            user.setUpdateTime(new Date());
//            user.setStatus(Constant.StatusType.LOGIC_NOT_DELETE.getValue());
//            repairsUserService.save(user);
//        }else{
//            //更新登录时间
//            user.setLastLoginTime(new Date());
//            repairsUserService.updateById(user);
//        }
//        // 清除验证码
//        redisService.del(phone);
//
//        //保存登录日志
//        RepairsLog log = new RepairsLog(phone, Constant.LogType.INFO.getValue(), String.format("手机用户:%s登录app", phone), IPUtil.getIpAddr(getRequest()));
//        repairsLogService.save(log);
//
//        //生成token，并保存到数据库
//        return createToken(user.getId());
//    }
//
//
//    @ApiOperation(value = "用户app退出")
//    @PostMapping("/logout")
//    public ResultMap logout() {
//        //生成一个token + 系统标识字符
//        String token = TokenGenerator.generateValue() + Constant.ClientType.APP_REPAIRS.getValue();
//        //修改token
//        RepairsUserToken tokenEntity = new RepairsUserToken();
//        ShiroUser currentUser = ShiroKit.getUser();
//        if(currentUser != null){
//            tokenEntity.setUserId(currentUser.getId());
//            tokenEntity.setToken(token);
//            repairsUserTokenService.updateById(tokenEntity);
//            RepairsLog log = new RepairsLog(currentUser.getLoginName(), Constant.LogType.INFO.getValue(), String.format("手机用户:%s登录退出了", ShiroKit.getUser().getLoginName()), IPUtil.getIpAddr(getRequest()));
//            repairsLogService.save(log);
//        }
//        return ResultMap.ok();
//    }
//
//    public ResultMap createToken(String userId) {
//        //生成一个token + 系统标识字符
//        String token = TokenGenerator.generateValue() + Constant.ClientType.APP_REPAIRS.getValue();
//        //当前时间
//        Date now = new Date();
//        //过期时间
//        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
//        //判断是否生成过token
//        RepairsUserToken tokenEntity = repairsUserTokenService.getById(userId);
//        if (tokenEntity == null) {
//            tokenEntity = new RepairsUserToken();
//            tokenEntity.setUserId(userId);
//            tokenEntity.setToken(token);
//            tokenEntity.setUpdateTime(now);
//            tokenEntity.setExpireTime(expireTime);
//            //保存token
//            repairsUserTokenService.save(tokenEntity);
//        } else {
//            tokenEntity.setToken(token);
//            tokenEntity.setUpdateTime(now);
//            tokenEntity.setExpireTime(expireTime);
//            //更新token
//            repairsUserTokenService.updateById(tokenEntity);
//        }
//        return ResultMap.ok().put("token", token).put("expire", EXPIRE);
//    }
//
//}
