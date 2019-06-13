package com.annaru.upms.im.rong.example.message;

import com.annaru.upms.im.rong.RongCloud;
import com.annaru.upms.im.rong.messages.TxtMessage;
import com.annaru.upms.im.rong.messages.VoiceMessage;
import com.annaru.upms.im.rong.methods.message._private.Private;
import com.annaru.upms.im.rong.models.message.*;
import com.annaru.upms.im.rong.models.response.ResponseResult;

/**
 * 消息发送示例
 *
 * @author RongCloud
 * @version 3.0.0
 */
public class MessageExample {
	
    private static final String JSONFILE = MessageExample.class.getClassLoader().getResource("jsonsource").getPath()+"/";
    
    /**
     * 此处替换成您的appKey
     * */
    private static final String appKey = "ik1qhw09iputp";
    /**
     * 此处替换成您的appSecret
     * */
    private static final String appSecret = "t6rtLUBqPHlC";

    //文字聊天
    private static final TxtMessage txtMessage = new TxtMessage("hello", "helloExtra");
    //语言聊天
    private static final VoiceMessage voiceMessage = new VoiceMessage("hello", "helloExtra", 20L);
    
    /**
     * 自定义api地址
     * */
    private static final String api = "http://api.cn.ronghub.com";

    public static void main(String[] args) throws Exception {

        RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
        //自定义 api 地址方式
        //RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret,api);

        Private Private = rongCloud.message.msgPrivate;

        String[] s = new String[]{"asdfas","666"};
        
        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/message/private.html#send
         *
         * 发送单聊消息
         * */
        PrivateMessage privateMessage = new PrivateMessage()
                .setSenderId("666")//发送人ID
                .setTargetId(s)//接收人ID
                .setObjectName(voiceMessage.getType())
                .setContent(txtMessage)
                .setPushContent("")
                .setPushData("{\"pushData\":\"hello\"}")
                .setCount("4")
                .setVerifyBlacklist(0)
                .setIsPersisted(1)
                .setIsCounted(1)
                .setIsIncludeSender(1);
        ResponseResult privateResult = Private.send(privateMessage);
        System.out.println("send private message:  " + privateResult.toString());
    }
}
