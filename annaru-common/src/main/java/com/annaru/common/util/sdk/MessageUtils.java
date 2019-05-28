package com.annaru.common.util.sdk;

//import com.gexin.common.AppGlobal;
//import com.gexin.common.cache.CacheUtils;
//import com.gexin.common.cache.RedisKeyConst;
//import com.gexin.common.model.ApiResponse;
//import com.gexin.model.message.MessageLog;
//import com.gexin.model.message.MessageModel;
//import com.gexin.model.msgtodo.MsgTodo;
//import com.jfinal.log.Log;

import java.util.HashMap;


/**
 * 发送短信接口工具类
 * @author Administrator
 *
 */
public class MessageUtils {
	//===================================================
	private final static  String accountSid = "8a216da859aa5a950159ab24c75400bd";// 主账户Id
	private final static  String authToken ="996a3eb4f7f349609a4efb2cabbde51b" ;// 主账户授权令牌
	private final static  String appId = "8a216da85b8e6bb1015b9df674670321" ;// 应用Id
	//=========================
	public static String loginId="170141";//登录的ID
	public static String addJtysId="170770";//家庭医生创建成功
	public static String jtysMatchId="170788";//家庭医生匹配成功
	public static String appointJtysId="170789";//用户预约家庭医生
	public static String agreeAppointId="189731";//家庭医生同意预约
	public static String formalUserId="170799";//问卷调查提醒
	public static String jtysWjdcId="170817";//家庭医生问卷调查提醒
	public static String addPrimaryId="170820";//新增基础检查项目
	public static String primaryMatchId="170827";//检查报告已匹配（基础）
	public static String addSuifangId="170831";//新增随访计划
	public static String addAdvancedId="170833";//新增专项检查
	public static String advancedMatchId="170834";//检查报告已匹配（专项）
	public static String addZhuanzhenId="170835";//转诊提醒
	public static String zhuanzhenConfirmId="170837";//专家转诊确认提醒
	public static String zhuanzhenAgreeId="170838";//用户转诊通过提醒
	public static String userCheckId="170840";//用户就诊提醒
	public static String zjCheckId="170841";//专家看诊提醒
	public static String tumorExclusionId="170843";//肿瘤排除提醒
	
	public static String outHospitalId="171448";//用户出院提醒
	public static String newUserCreateId="173793";//新用户账户通知
	public static String questionFinishId="173908";//家庭医生确认问卷
	public static String orderStateErrorId="174283";//订单状态异常提醒
	public static String jtysAddUserId="176844";//家庭医生新增用户提醒
	public static String remindAdminId="179598";//保单生效，提醒运营人员
	
    public static void main(String[] args) {
		//PropKit.use("a_little_config.txt");
		//System.err.println(StringUtil.getBundelPath ("config","app_id"));
		//System.err.println(MessageUtils.sendTemplateSMS("18606160344", MessageUtils.loginId, new String[]{"599688","12341255"}));
		System.err.println(MessageUtils.sendTemplateSMS("17621699311", MessageUtils.loginId,"8888","1"));
	}
    
    /**
     * 监测验证码是否正确
     * @param phone    手机号码
     * @param code   验证码
     * @param moid  模板的编号
     * @return
     */
//    public static boolean  CheckCode(String phone,String code,String moid){
//    	String perincode = CacheUtils.get(RedisKeyConst.Message_Code+moid+phone);
//    	if(perincode!=null && code.equals(perincode)){
//    		return true;
//    	}else{
//    		return false;
//    	}
//    }
    
//    public static void  delCode(String phone,String moid){
//    	CacheUtils.del(RedisKeyConst.Message_Code+moid+phone);
//    }
    
    /**
     * 发送短信验证码
     * @param phone  手机号码
     * @param code  发送的验证码  如果传空的 默认产生四位随机数
     * @param moid   模板的ID
     * @param session  httpsession
     * @return  
     */
//    public static ApiResponse SendCode(String phone,String code , String moid){
//    	String key = RedisKeyConst.Message_Send+phone;
//    	ApiResponse cmd =null;
//		if(CacheUtils.exists(key)==true){
//			cmd = new ApiResponse(false, "发送时间太短了！");
//			return cmd ;
//		}
//		if(StringUtil.isEmpty(phone)==false){
//			CacheUtils.set(key, phone, RedisKeyConst.Message_Send_time);
//			if (AppGlobal.dev_Mode) {
//				code = "0000";
//			}
//			if(sendTemplateSMS(phone, moid, code,"1")==true){
//				//把验证码存到redis 里面去
//				CacheUtils.set(RedisKeyConst.Message_Code+moid+phone, code, RedisKeyConst.Message_Code_time);
//				log.info("发送验证码为："+phone+":"+code);
//				cmd = new ApiResponse(true, "发送成功！");
//			}else{
//				cmd = new ApiResponse(true, "发送失败请稍后再试！");
//			}
//			//MessageUtils.
//		}else{
//			cmd =(new ApiResponse(false, "参数错误！"));
//		}
//
//		return cmd ;
//    }
	
	/**
	 * 发送的模板的消息
	 * @param to  要发送的手机号码
	 * @param templateId  模板的ID
	 * @param datas  发送的数据
	 * @param type  短信发送类型 1 系统自动发送 2 后台手动发送
	 * @return
	 */
	public static Boolean sendTemplateSMS(String to,String templateId, String[] datas, String type){
		//如果是开发者模式  直接返回
//		if(AppGlobal.dev_Mode){
//			System.err.println("测试环境发送短信:"+to);
//			return true;
//		}
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		restAPI.init("app.cloopen.com", "8883");
		restAPI.setAccount(accountSid, authToken);
		restAPI.setAppId(appId);
		HashMap<String, Object> result = null;
		result = restAPI.sendTemplateSMS(to,templateId,datas);
//		//保存短信发送记录
//		MessageModel message = MessageModel.dao.findById(templateId);
//		String content = "";
//		if (message!=null) {//模版不存在时
//			content = message.getContent();
//			if (datas!=null) {
//				for (int i = 0; i < datas.length; i++) {
//					content = content.replace("{"+(i+1)+"}", datas[i]);
//				}
//			}
//		}else {
//			log.info("短信模版不存在："+templateId);
//		}
//		MessageLog msg = new MessageLog();
//		msg.setId(IdGenerateUtils.getId());
//		msg.setSendPhone(to);
//		msg.setTemplateId(templateId);
//		msg.setContent(content);
//		msg.setType(type==null?"1":type);
//		if("000000".equals(result.get("statusCode"))){
//		 /*//正常返回输出data包体信息（map）
//			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
//			Set<String> keySet = data.keySet();
//			for(String key:keySet){
//				Object object = data.get(key);
//				System.out.println(key +" = "+object);
//			}*/
//			msg.save();
//			return true;
//		}else{
//			//异常返回输出错误码和错误信息
//			msg.setState("0");
//			msg.setRemark(result.get("statusMsg").toString());
//			msg.save();
//			log.info("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
//			return false;
//
//		}
		return true;
	
	}
	
	
	/**
	 * 发送的模板的消息
	 * @param to  要发送的手机号码
	 * @param templateId  模板的ID
	 * @param datas  发送的数据
	 * @param type  短信发送类型 1 系统自动发送 2 后台手动发送
	 * @return
	 */
	public static HashMap<String, Object> sendTemplateSMS(String to,String templateId, String datas, String type){
		//如果是开发者模式  直接返回
//		if(AppGlobal.dev_Mode){
//			System.err.println("测试环境发送短信:"+to);
//			return true;
//		}
	   //测试关闭发短信的接口
	   CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		restAPI.init("app.cloopen.com", "8883");
		restAPI.setAccount(accountSid, authToken);
		restAPI.setAppId(appId);
		HashMap<String, Object> result = null;
		result = restAPI.sendTemplateSMS(to,templateId,new String[]{datas});
		//保存短信发送记录
//		MessageModel message = MessageModel.dao.findById(templateId);
//		String content = "";
//		if (message!=null) {//模版不存在时
//			content = message.getContent().replace("{1}", datas==null?"":datas);
//		}else {
//			log.info("短信模版不存在："+templateId);
//		}
//		MessageLog msg = new MessageLog();
//		msg.setId(IdGenerateUtils.getId());
//		msg.setSendPhone(to);
//		msg.setTemplateId(templateId);
//		msg.setContent(content);
//		msg.setType(type==null?"1":type);
//		if("000000".equals(result.get("statusCode"))){
//			msg.save();
//			return true;
//		}else{
//			//异常返回输出错误码和错误信息
//			msg.setState("0");
//			msg.setRemark(result.get("statusMsg").toString());
//			msg.save();
//			log.error("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
//			return false;
//		}
		return result;
	}
	/**
	 * 保单生效时短信提醒相关运营人员
	 * @return
	 */
	public static void remainManager(String name ,String phone , String address ,String client_id){
		//朱伟杰
		MessageUtils.sendTemplateSMS("15221306987", MessageUtils.remindAdminId, new String[]{name,phone,address},"1");
//		//李茜
//		MessageUtils.sendTemplateSMS("18602180311", MessageUtils.remindAdminId, new String[]{name,phone,address},"1");
		//郭纪新
		MessageUtils.sendTemplateSMS("18121271239", MessageUtils.remindAdminId, new String[]{name,phone,address},"1");
		//纪雯君
		//MessageUtils.sendTemplateSMS("13818579809", MessageUtils.remindAdminId, new String[]{name,phone,address},"1");
		//杨凤民
		MessageUtils.sendTemplateSMS("13601870698", MessageUtils.remindAdminId, new String[]{name,phone,address},"1");
		
		//给运营员添加待办事项，匹配家庭医生
//		MsgTodo.addAdminMsgTodo( "匹配家庭医生", "新用户:"+name+"购买了保险,请尽快为其匹配合适的家庭医生", "/system/gznr/usermanage/detail/"+client_id, client_id);
	}
	
}
