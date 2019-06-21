package com.annaru.upms.controllerutil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 网站常量存放的地方
 * 
 * @author 肖得明
 * 
 */
public class AppConst {

	// 定义一个测试的map 对象
	public static final Map<Object, Object> testmap = gettestmap();
	//public static final List<RetValue> testlist = StringUtils.maptolist(testmap);

	// 给他初始化的指
	private static Map<Object, Object> gettestmap() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("1", "测试标题1");
		temp.put("2", "测试标题2");
		temp.put("3", "测试标题3");
		temp.put("4", "测试标题32");
		return temp;
	}

	// 定义一个测试的map 对象
	public static final Map<Object, String> ApiErrorMessage = getApiErrorMessage();

	// 给他初始化的指
	private static Map<Object, String> getApiErrorMessage() {
		Map<Object, String> temp = new LinkedHashMap<Object, String>();
		temp.put(0, "正常");
		temp.put(500, "服务器内部错误！");
		temp.put(101, "Token,或Userid参数不能为空!");
		temp.put(102, "你的账号已经在其他手机上登陆，请重新登陆!");
		return temp;
	}

	public static final Map<Object, Object> LogLevel = getLogLevel();

	private static Map<Object, Object> getLogLevel() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("info", "一般");
		temp.put("wanring", "警告");
		temp.put("error", "错误");
		return temp;
	}

	public static final Map<Object, Object> Discount_Code_State = getDiscount_Code_State();

	private static Map<Object, Object> getDiscount_Code_State() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("0", "未使用");
		temp.put("1", "已使用");
		return temp;
	}

	public static final Map<Object, Object> Wl_Check_State = getWl_Check_State();

	private static Map<Object, Object> getWl_Check_State() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("检验合格", "检验合格");
		temp.put("等待检验", "等待检验");
		return temp;
	}

	public static final Map<Object, Object> sexmap = getsexmap();

	private static Map<Object, Object> getsexmap() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("0", "未知");
		temp.put("1", "男");
		temp.put("2", "女");
		return temp;
	}

	public static final Map<Object, Object> user_role = geuser_role();

	private static Map<Object, Object> geuser_role() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("2", "管理员");
		temp.put("1", "普通用户 ");
		return temp;
	}

	// 常用的禁用 ?/启用
	public static final Map<Object, Object> state = getbstate();

	private static Map<Object, Object> getbstate() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put(0, "启用");
		temp.put(1, "禁用");
		return temp;
	}

	// 专家科室
	/**
	 * 心血管内科 消化内科 肾内科 心胸外科 脑外科 肝胆外科 泌尿外科 肛肠外科 器官移植 乳腺外科 手外科 胃肠外科 血管外科 肿瘤科
	 */
	public static final Map<Object, Object> zjks = getzjks();

	private static Map<Object, Object> getzjks() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("普外科", "普外科");
		temp.put("胸外科", "胸外科");
		temp.put("呼吸科", "呼吸科");
		temp.put("消化科", "消化科");
		temp.put("妇科", "妇科");
		temp.put("泌尿外科", "泌尿外科");
		temp.put("乳腺外科", "乳腺外科");
		return temp;
	}

	/**
	 * 资讯端口类别 client:用户端 jtys:家庭医生端
	 */
	public static final Map<Object, Object> zxType = getZxType();

	public static Map<Object, Object> getZxType() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("client", "用户端");
		temp.put("jtys", "家庭医生端");
		return temp;
	}

	/**
	 * 订单列表的支付状态
	 */
	public static final Map<Object, Object> zfState = getzfState();

	public static Map<Object, Object> getzfState() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("1", "等待支付");
		temp.put("2", "支付成功");
		temp.put("3", "已经确认");
		temp.put("4", "已经关闭");
		return temp;
	}

	/**
	 * 问卷调查状态
	 */
	public static final Map<Object, Object> wjdcState = wjdcState();

	public static Map<Object, Object> wjdcState() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("wait", "等待确认");
		temp.put("ok", "完成");
		return temp;
	}

	/**
	 * 转诊状态
	 */
	public static final Map<Object, Object> zhuanzhenState = zhuanzhenState();

	public static Map<Object, Object> zhuanzhenState() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("1", "等待审核");
		temp.put("2", "已经推送");
		temp.put("3", "已完成预约");
		return temp;
	}
	
	/**
	 * 癌种
	 */
	public static final Map<Object, Object> aizhong = aizhong();

	public static Map<Object, Object> aizhong() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("1", "宫颈癌");
		temp.put("2", "乳腺癌");
		temp.put("3", "卵巢癌");
		temp.put("4", "食管癌");
		temp.put("5", "肺癌");
		temp.put("6", "胃癌");
		temp.put("7", "结直肠癌");
		temp.put("8", "前列腺癌");
		temp.put("9", "肝癌");
		temp.put("10", "膀胱癌");
		return temp;
	}
	/**
	 * 保单状态
	 */
	public static final Map<Object, Object> bdState = bdState();

	public static Map<Object, Object> bdState() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put(1, "尚未购买");
		temp.put(2, "服务中");
		temp.put(3, "已经过期");
		return temp;
	}
	
	/**
	 * 保单状态
	 */
	public static final Map<Object, Object> zhuanzhenResult = zhuanzhenResult();

	public static Map<Object, Object> zhuanzhenResult() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("wait", "等待确认");
		temp.put("diagnosis", "已经确认");
		temp.put("doubt", "怀疑");
		temp.put("exclude", "排除");
		return temp;
	}
	
	/**
	 * 保单状态
	 */
	public static final Map<Object, Object> qzLevel = qzLevel();

	public static Map<Object, Object> qzLevel() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("1", "早期");
		temp.put("2", "中期");
		temp.put("3", "晚期");
		return temp;
	}

	/**
	 * 用户类型
	 */
	
	public static final Map<Object, Object> uset_type = uset_type();

	public static Map<Object, Object> uset_type() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("1", "专家");
		temp.put("2", "家庭医生");
		return temp;
	}
	
	/**
	 * 账户状态
	 */
	
	public static final Map<Object, Object> account_state = account_state();

	public static Map<Object, Object> account_state() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("1", "正常");
		temp.put("2", "禁用");
		return temp;
	}
	
	/**
	 * 提现状态
	 */
	
	public static final Map<Object, Object> tx_state = tx_state();

	public static Map<Object, Object> tx_state() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("1", "等待运营审核");
		temp.put("2", "等待财务审核");
		temp.put("3", "等待经理审核");
		temp.put("4", "审核通过");
		temp.put("5", "打款成功");
		temp.put("6", "拒绝");
		return temp;
	}
	
	/**
	 * 流水日志收支状态
	 */
	
	public static final Map<Object, Object> operation_type = operation_type();

	public static Map<Object, Object> operation_type() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("1", "支出");
		temp.put("2", "收入");
		return temp;
	}
	
	
	/**
	 * 银行代码
	 */
	public static final Map<Object, Object> bank_code_type = bank_code_type();

	public static Map<Object, Object> bank_code_type() {
		Map<Object, Object> temp = new LinkedHashMap<Object, Object>();
		temp.put("01", "中国工商银行");
		temp.put("02", "中国银行");
		temp.put("03", "中国建设银行");
		temp.put("04", "中国农业银行");
		temp.put("05", "城市商业银行");
		temp.put("06", "招商银行");
		temp.put("07", "中国民生银行");
		temp.put("08", "华夏银行");
		temp.put("09", "上海浦发银行");
		temp.put("10", "交通银行");
		temp.put("11", "光大银行");
		temp.put("13", "兴业银行");
		temp.put("14", "广东发展银行 ");
		temp.put("15", "中信银行 ");
		temp.put("16", "邮政储蓄");
		temp.put("21", "上海银行");
		temp.put("22", "杭州银行");
		temp.put("38", "北京银行");
		temp.put("39", "南京银行");
		temp.put("41", "江苏银行");
		temp.put("44", "浙江泰隆商业银行");
		temp.put("52", "平安银行");
		temp.put("A3", "宁波银行");
		temp.put("B9", "浦发银行");
		
		return temp;
	}
	
	/**
	 * 用药频次代码
	 */
	
	public static final Map<String, String> sypc_dm = sypc_dm();

	public static Map<String, String> sypc_dm() {
		Map<String, String> temp = new LinkedHashMap<String, String>();
		temp.put("qd", "每天一次");
		temp.put("bid", "每天两次");
		temp.put("tid", "每天三次");
		temp.put("qid", "每天四次");
		temp.put("q30d", "每30天一次");
		temp.put("qw", "一周一次");
		temp.put("q2w", "二周一次");
		temp.put("biw", "一周二次");
		temp.put("tiw", "每周三次(w1/w3/w5)");
		temp.put("q30w", "每三十分钟一次");
		temp.put("q1h", "一小时一次");
		temp.put("q2h", "二小时一次");
		temp.put("q3h", "三小时一次");
		temp.put("q4h", "四小时一次");
		temp.put("q5h", "五小时一次");
		temp.put("q6h", "六小时一次");
		temp.put("q8h", "八小时一次");
		temp.put("q12h", "12小时一次");
		temp.put("q72h", "72小时一次");
		temp.put("qm", "每天中午一次");
		temp.put("qn", "每晚一次");
		temp.put("q0n", "每2晚一次");
		temp.put("st", "立即");
		temp.put("q0d", "隔天一次");
		temp.put("q5d", "五天一次");
		temp.put("q10d", "十天一次");
		temp.put("c12h", "12小时维持");
		temp.put("c24h", "24小时维持");
		temp.put("prn", "必要时使用");
		temp.put("ac", "明晨急化验");
		temp.put("am", "明晨化验");
		return temp;
	}
	/**
	 * 用药途径代码
	 */
	
	public static final Map<String, String> yf_dm = yf_dm();

	public static Map<String, String> yf_dm() {
		Map<String, String> temp = new LinkedHashMap<String, String>();
		temp.put("1", "口服");
		temp.put("2", "直肠给药");
		temp.put("3", "舌下给药");
		temp.put("4", "注射给药");
		temp.put("401", "皮下注射");
		temp.put("402", "皮内注射");
		temp.put("403", "肌肉注射");
		temp.put("404", "静脉注射或静脉滴注");
		temp.put("5", "吸入给药");
		temp.put("6", "局部用药");
		temp.put("601", "椎管内给药");
		temp.put("602", "关节腔内给药");
		temp.put("603", "胸膜腔给药");
		temp.put("604", "腹腔给药");
		temp.put("605", "阴道用药");
		temp.put("606", "滴眼");
		temp.put("607", "滴鼻");
		temp.put("608", "滴喉");
		temp.put("609", "含化");
		temp.put("610", "敷伤口");
		temp.put("611", "擦皮肤");
		temp.put("6xx", "局部用药扩充内容");
		temp.put("699", "其他局部给药途径");
		temp.put("9", "其他给药途径");
		return temp;
	}
	/**
	 *  检查项目类型标签
	 */
	
	public static final Map<String, String> item_tag = item_tag();

	public static Map<String, String> item_tag() {
		Map<String, String> temp = new LinkedHashMap<String, String>();
		temp.put("1", "血液类");
		temp.put("2", "尿液类");
		temp.put("3", "粪便类");
		temp.put("4", "体液与分泌物类");
		temp.put("5", "影像类");
		temp.put("6", "内镜类");
		temp.put("7", "心电类");
		temp.put("8", "病理类");
		temp.put("9", "呼气试验");
		return temp;
	}
}
