package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.config.redis.IRedisService;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.Constant;
import com.annaru.common.util.sdk.MessageUtils;
import com.annaru.upms.entity.SysDoctor;
import com.annaru.upms.entity.SysNurse;
import com.annaru.upms.entity.SysUserToken;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.service.ISysDoctorService;
import com.annaru.upms.service.ISysNurseService;
import com.annaru.upms.service.ISysUserTokenService;
import com.annaru.upms.service.IUserBasicService;
import com.annaru.upms.shiro.aouth2.TokenGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jodd.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    //24小时过期
    private int OUT_SECONDS = 86400;

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/loginInfo")
    public ResultMap loginInfo(String cellphoneNo, String password, String type){

        if (StringUtil.isBlank(cellphoneNo) || StringUtil.isBlank(password)){
            return ResultMap.error("账号或密码不能为空！");
        }
        if (!("1").equals(type) && !"2".equals(type) && !"3".equals(type)){
            return ResultMap.error("端不存在!");
        }

        Map<String, Object> map = new HashMap <>();
        map.put("cellphoneNo", cellphoneNo);
        UserBasic userBasic = iUserBasicService.selectByData(map);

        if (userBasic == null){
            return ResultMap.error("用户不存在！");
        }
        if (StringUtil.isBlank(userBasic.getPassword())){
            if (!password.equals(userBasic.getPassword())){
                return ResultMap.error("账号或者密码输入错误，请检查！");
            }
        }
        if (userBasic.getIsactive().equals("0")){
            return ResultMap.error("用户未激活！");
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

        //用户
        if (("1").equals(type)){
            return ResultMap.ok().put("data", userBasic).put("first_login", firstLogin).put("token", token);
        }
        //医生
        if ("2".equals(type)){
//            return ResultMap.ok().put("user_basic", iUserBasicService.selectDoctorByData(map)).put("first_login", firstLogin).put("token", token);
            return ResultMap.ok().put("data", iUserBasicService.selectDoctorByData(map)).put("first_long", firstLogin).put("token", token);
        }
        //护士
        if ("3".equals(type)){
            return ResultMap.ok().put("data", iUserBasicService.selectNurseByData(map)).put("first_login", firstLogin).put("token", token);
        }

        return ResultMap.error("异常错误，请联系管理员");

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

}
