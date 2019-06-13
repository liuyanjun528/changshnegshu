package com.annaru.upms.im.rong.example.chatroom.whitelist;

import com.annaru.upms.im.rong.RongCloud;
import com.annaru.upms.im.rong.methods.chatroom.whitelist.Whitelist;
import com.annaru.upms.im.rong.models.response.ChatroomWhitelistMsgResult;
import com.annaru.upms.im.rong.models.response.ResponseResult;

/**
 * @author RongCloud
 */
public class MessageExample {
    /**
     * 此处替换成您的appKey
     * */
    private static final String appKey = "appKey";
    /**
     * 此处替换成您的appSecret
     * */
    private static final String appSecret = "appSecret";
    /**
     * 自定义api地址
     * */
    private static final String api = "http://api.cn.ronghub.com";

    public static void main(String[] args) throws Exception {
        RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
        //自定义 api地址方式
        //RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret,api);

        Whitelist whitelist = rongCloud.chatroom.whiteList;
        String[] messageType = {"RC:VcMsg", "RC:ImgTextMsg", "RC:ImgMsg"};

        /**
         * API: 文档http://www.rongcloud.cn/docs/server_sdk_api/chatroom/whitelist/message.html#add
         * 添加聊天室全局禁言
         * */

        ResponseResult addResult = whitelist.message.add(messageType);
        System.out.println("add whitelist:  " + addResult.toString());
        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/chatroom/whitelist/message.html#getList
         * 添加聊天室全局禁言
         * */

        ChatroomWhitelistMsgResult getResult = whitelist.message.getList();
        System.out.println("get whitelist:  " + getResult.toString());

        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/chatroom/whitelist/message.html#remove
         * 添加聊天室全局禁言
         * */

        ResponseResult removeResult = whitelist.message.remove(messageType);
        System.out.println("remove whitelist:  " + addResult.toString());

       }
}
