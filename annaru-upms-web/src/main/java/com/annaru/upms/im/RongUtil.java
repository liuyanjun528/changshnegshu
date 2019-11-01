package com.annaru.upms.im;

import com.annaru.upms.im.rong.RongCloud;
import com.annaru.upms.im.rong.RongYunKeyEnum;
import com.annaru.upms.im.rong.models.Result;
import com.annaru.upms.im.rong.models.response.TokenResult;
import com.annaru.upms.im.rong.models.user.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RongUtil {

    private static final Logger logger = LoggerFactory.getLogger(RongUtil.class);

    private static RongCloud rongCloud = RongCloud.getInstance(RongYunKeyEnum.APPKEY.getValue(), RongYunKeyEnum.APPSECRET.getValue());

    /**
     * 注册用户，生成用户在融云的唯一身份标识 Token
     * @param id 用户id （必传）
     * @param name 用户名称 （必传）
     * @param portrait 用户头像地址 （必传）
     * @return
     */
    public static String register(String id,String name,String portrait) {
        try {
            /**
             * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
             *
             * 注册用户，生成用户在融云的唯一身份标识 Token
             */
            if (StringUtils.isBlank(portrait)) {// 默认头像
                portrait = "http://www.rongcloud.cn/images/logo.png";
            }
            UserModel userModel = new UserModel()
                    .setId(id)
                    .setName(name)
                    .setPortrait(portrait);
            TokenResult userGetTokenResult = rongCloud.user.register(userModel);
            if(userGetTokenResult.getCode()==200){
                return userGetTokenResult.getToken();
            }else{
                logger.error("融云信息错误获取Token："+userGetTokenResult.getMsg());
                return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * 刷新用户信息
     * @param id 用户id （必传）
     * @param name 用户名称 （必传）
     * @param portrait 用户头像地址 （必传）
     * @return
     */
    public static Integer refresh(String id,String name,String portrait) {
        try {
            UserModel userModel = new UserModel()
                    .setId(id)
                    .setName(name)
                    .setPortrait(portrait);
            Result update = rongCloud.user.update(userModel);
            if(update.getCode()==200){
                return update.getCode();
            }else{
                logger.error("融云信息错误获取Token："+update.getMsg());
                return 0;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        String getToken = register("123", "123", "");
        System.out.println("Token:"+getToken);

        Integer refresh = refresh("123", "123", "http://www.rongcloud.cn/images/logo.png");
        System.out.println("code:"+refresh);


    }
}
