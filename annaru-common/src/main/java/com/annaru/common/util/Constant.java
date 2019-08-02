package com.annaru.common.util;

/**
 * @author TuMinglong
 * @version 1.0.0
 * @description 常量
 * @date 2018年4月19日 下午3:57:46
 */
public class Constant {
	/** 超级管理员ID */
	public final static String SUPER_ADMIN = "1";

    // 控制线程数，最优选择是处理器线程数*3，本机处理器是4线程
    public final static int THREAD_COUNT = 12;

    /**
     * @Description: 体检报告解读状态
     * @Author: XCK
     * @Date: 2019/7/26
     */
    public enum ReportReviewStatus{
        //未推送
        NOT_REVIEW(0),

        //已推送
        REVIEW(1);

        private Integer value;
        ReportReviewStatus(Integer value){
            this.value=value;
        }
        public Integer getValue(){
            return value;
        }
    }

    /**
     * @Description: 体检报告分类是否推送
     * @Author: XCK
     * @Date: 2019/7/26
     */
    public enum ClassifyPosted{
        //未推送
        NOT_POSTED(0),

        //已推送
        POSTED(1);

        private Integer value;
        ClassifyPosted(Integer value){
            this.value=value;
        }
        public Integer getValue(){
            return value;
        }
    }

    /**
     * 支付状态
     */
    public enum PaymentState {
        // 支付状态（1：待支付、5：已付款、10：已退款、15：交易关闭）
        /**
         * 待支付
         */
        UNPAID(1),
        /**
         * 已付款
         */
        PAID(5),
        /**
         * 已退款
         */
        REFUND(10),
        /**
         * 交易关闭
         */
        CLOSE(15);

        private int value;

        PaymentState(int value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * 订单支付状态
     */
    public enum OrderMainStatus {
        // 支付状态(0:未支付/1:进行中/2:已完成/3:退款中)
        /**
         * 未支付
         */
        UNPAID(0),
        /**
         * 进行中
         */
        UNDERWAY(1),
        /**
         * 已完成
         */
        COMPLETED(2),
        /**
         * 交易关闭
         */
        REFUND(3);

        private int value;

        OrderMainStatus(int value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * 支付渠道
     */
    public enum PaymentChannel {
        // 支付方式(1:支付宝/2:微信/3:银行卡)
        /**
         * 支付宝
         */
        ALIPAY("1"),
        /**
         * 微信
         */
        WECHAT("2"),
        /**
         * 银行卡
         */
        BANK_CARD("3");

        private String value;

        PaymentChannel(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * 认证状态
     */
    public enum AuthenticationState {
        // 审核(0:未审核/1:已审核)
        /**
         * 未认证
         */
        NOT_AUTHENTICATION(0),

        /**
         * 已认证
         */
        AUTHENTICATION(1);

        private Integer value;

        AuthenticationState(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }


    /**
     * 数据状态类型
     */
    public enum StatusType {

        /**
         * 逻辑删除 1
         */
        LOGIC_DELETE(1),
        /**
         * 逻辑未删除 0
         */
        LOGIC_NOT_DELETE(0);

        private int value;

        StatusType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

	/**
	 * 菜单类型
	 *
	 */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 日志类型
     *
     */
    public enum LogType {
        /**
         * 目录
         */
        info(0),
        /**
         * 菜单
         */
        error(1);

        private int value;

        LogType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
    	NORMAL(0),
        /**
         * 暂停
         */
    	PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }

    /**
     * 文件存储
     */
    public enum CloudService {
        /**
         * 本地
         */
        LOCAL(0),
        /**
         * fastdfs
         */
        FASTDFS(1),
        /**
         * 七牛云
         */
        QINIU(2),
        /**
         * 阿里云
         */
        ALIYUN(3),
        /**
         * 腾讯云
         */
        QCLOUD(4);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
