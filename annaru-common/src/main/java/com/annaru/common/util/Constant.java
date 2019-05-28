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
