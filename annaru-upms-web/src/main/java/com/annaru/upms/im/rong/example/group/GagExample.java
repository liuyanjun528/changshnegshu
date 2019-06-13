package com.annaru.upms.im.rong.example.group;

import com.annaru.upms.im.rong.RongCloud;
import com.annaru.upms.im.rong.methods.group.gag.Gag;
import com.annaru.upms.im.rong.models.Result;
import com.annaru.upms.im.rong.models.group.GroupMember;
import com.annaru.upms.im.rong.models.group.GroupModel;
import com.annaru.upms.im.rong.models.response.ListGagGroupUserResult;
/**
 *
 * 群组禁言例子
 * @author RongCloud
 *
 * @version 3.0.0
 */
public class GagExample {
    /**
     * 此处替换成您的appKey
     * */
    private static final String appKey = "appKey";
    /**
     * 此处替换成您的appSecret
     * */
    private static final String appSecret = "appSercet";
    /**
     * 自定义api地址
     * */
    private static final String api = "http://api.cn.ronghub.com";

    /**
     * 本地调用测试
     *
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
        //自定义 api 地址方式
        // RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret,api);

        Gag Gag = rongCloud.group.gag;
        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/gag.html#add
         * 添加禁言群成员方法
         */

        GroupMember[] members = {new GroupMember().setId("ghJiu7H1"),new GroupMember().setId("ghJiu7H2")};

        GroupModel group = new GroupModel()
                .setId("12")
                .setMembers(members)
                .setMinute(5);
        Result result = Gag.add(group);
        System.out.println("group.gag.add:  " + result.toString());

        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/gag.html#getList
         * 查询被禁言群成员
         */
        ListGagGroupUserResult groupLisGagUserResult = Gag.getList("12");
        System.out.println("group.gag.getList:  " + groupLisGagUserResult.toString());

        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/group/gag.html#remove
         * 移除禁言群成员
         */
        group = new GroupModel()
                .setId("IXQhMs3ny")
                .setMembers(members);

        //Result groupRollBackGagUserResult = Gag.remove(group);
        //System.out.println("group.gag.remove:  " + groupRollBackGagUserResult.toString());

    }
}
