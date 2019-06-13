package com.annaru.upms.im.rong.common;

import com.annaru.upms.im.rong.RongCloud;
import com.annaru.upms.im.rong.methods.user.User;
import com.annaru.upms.im.rong.models.response.TokenResult;
import com.annaru.upms.im.rong.models.user.UserModel;

/**
 * 创建融云工具类 针对用户注册是创建融云唯一token 需要appservice连接融云service
 * 
 * @author boss 3
 *
 */
public class CommonUtil {

	/**
	 * 此处替换成您的appKey
	 */
	private static final String appKey = "ik1qhw09iputp";
	/**
	 * 此处替换成您的appSecret
	 */
	private static final String appSecret = "t6rtLUBqPHlC";

	/**
	 * 融云用户注册返回token
	 * @param users_id
	 * @param users_name
	 * @param users_logo
	 * @return
	 * @throws Exception
	 */
	public static String insertRongUser(String users_id,
			String users_name,String users_logo)throws Exception{
		RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
		User User = rongCloud.user;
		
		/**
		 * API 文档:
		 * http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
		 * 注册用户，生成用户在融云的唯一身份标识 Token
		 */
		UserModel user = new UserModel().setId(users_id).setName(users_name).setPortrait(users_logo);
		TokenResult result = User.register(user);
		return result.getToken();
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(insertRongUser("666", "111", "ssss"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}