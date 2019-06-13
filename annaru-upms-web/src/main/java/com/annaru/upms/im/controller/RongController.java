package com.annaru.upms.im.controller;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.im.rong.RongCloud;
import com.annaru.upms.im.rong.RongYunKeyEnum;
import com.annaru.upms.im.rong.models.Result;
import com.annaru.upms.im.rong.models.response.TokenResult;
import com.annaru.upms.im.rong.models.user.UserModel;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "融云IM接口管理")
@RestController
@RequestMapping("/im")
public class RongController extends BaseController {

    private static final RongCloud rongCloud = RongCloud.getInstance(RongYunKeyEnum.APPKEY.getValue(), RongYunKeyEnum.APPSECRET.getValue());
    /**
     * 注册融云用户获取token
     */
    @ApiOperation(value = "注册融云用户获取token", notes = "注册融云用户获取token")
    @PostMapping("/register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户Id",dataType = "spring",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "用户名称",dataType = "spring",paramType = "query"),
            @ApiImplicitParam(name = "portrait",value = "用户头像URI",dataType = "spring",paramType = "query")
    })
    public ResultMap register(String id,String name,String portrait,HttpServletRequest request) {
        try {
            //自定义 api 地址方式
            // RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret,api);
            /**
             * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
             *
             * 注册用户，生成用户在融云的唯一身份标识 Token
             */
            UserModel userModel = new UserModel()
                    .setId(id)
                    .setName(name)
                    .setPortrait(portrait);
            TokenResult userGetTokenResult = rongCloud.user.register(userModel);
            if(userGetTokenResult.getCode()==200){
                return ResultMap.ok().put("result", userGetTokenResult);
            }else{
                logger.error("融云信息错误获取Token："+userGetTokenResult.getMsg());
            return ResultMap.error("融云信息错误获取Token："+userGetTokenResult.getMsg());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 刷新用户信息
     */
    @ApiOperation(value = "刷新用户信息", notes = "刷新用户信息")
    @PostMapping("/refresh")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户Id",dataType = "spring",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "用户名称",dataType = "spring",paramType = "query"),
            @ApiImplicitParam(name = "portrait",value = "用户头像URI",dataType = "spring",paramType = "query")
    })
    public ResultMap refresh(String id,String name,String portrait,HttpServletRequest request) {
        try {
            UserModel userModel = new UserModel()
                    .setId(id)
                    .setName(name)
                    .setPortrait(portrait);
            Result update = rongCloud.user.update(userModel);
            if(update.getCode()==200){
                return ResultMap.ok().put("result", update);
            }else{
                logger.error("融云信息错误获取Token："+update.getMsg());
                return ResultMap.error("融云信息错误获取Token："+update.getMsg());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }




}
