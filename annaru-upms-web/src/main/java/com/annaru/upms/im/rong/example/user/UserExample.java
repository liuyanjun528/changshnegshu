package com.annaru.upms.im.rong.example.user;

import com.annaru.upms.im.rong.RongYunKeyEnum;
import com.annaru.upms.im.rong.RongCloud;
import com.annaru.upms.im.rong.methods.message.history.History;
import com.annaru.upms.im.rong.methods.user.User;
import com.annaru.upms.im.rong.models.response.*;
import com.annaru.upms.im.rong.models.user.UserModel;
import com.annaru.upms.im.rong.util.JsonUtil;

/**
 * Demo class
 *
 * @author RongCloud
 *
 */
public class UserExample {
    /**
     * 自定义api地址
     * */
    private static final String api = "http://api.cn.ronghub.com";
    
    /**
     * 获取用户登录的TOKEN
     * @param id
     * @param name
     * @param appKey
     * @param appSecret
     * @return
     * @throws Exception
     */
    public static String returnToken(String id,String name,
    		String appKey,String appSecret)throws Exception{
    	RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
        
        //自定义 api 地址方式
        // RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret,api);
        User User = rongCloud.user;

        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
         *
         * 注册用户，生成用户在融云的唯一身份标识 Token
         */ 
        UserModel userModel = new UserModel()
                .setId(id)
                .setName(name)
                .setPortrait("http://www.rongcloud.cn/images/logo.png");
        TokenResult result = User.register(userModel);
        return result.getToken();
    }
    
    /**
     * 获取历史消息
     * @param dateNowTine 当前时间 格式：2018091911  11(10-11小时之间的消息)
     * @param appKey
     * @param appSecret
     * @return
     * @throws Exception
     */
    public static String historyMsg(String dateNowTine,String appKey,String appSecret)throws Exception{
    	RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
    	History history = rongCloud.message.history;
    	HistoryMessageResult historyMessageResult = history.get(dateNowTine);
    	return historyMessageResult.getUrl();
    }

    public static void main(String[] args) throws Exception{
    	RongCloud rongCloud = RongCloud.getInstance(RongYunKeyEnum.APPKEY.getValue(), RongYunKeyEnum.APPSECRET.getValue());
    	History history = rongCloud.message.history;
    	HistoryMessageResult historyMessageResult = history.get("2018091915");
    	historyMessageResult.getUrl();
        System.out.println("get history  message:  " + historyMessageResult.toString());
       
    }
}