package com.annaru.common.constants;

/**
 * 充值卡枚举
 *
 * @author jyehui
 * @date 2019-10-11 11:10:08
 */
public class TopupCardEnum {

    /**
     * 卡、卡规则（通用）使用状态
     */
    public enum CardIsActive {
        /**
         * 失效
         */
        NOT_ACTIVE(0),
        /**
         * 有效
         */
        ACTIVE(1);

        private int value;

        CardIsActive(int value){
            this.value = value;
        }

        public Integer getValue(){
            return this.value;
        }
    }

    /**
     * 卡规则类型
     */
    public enum CardFormularCates {
        /**
         * 充值卡使用规则
         */
        TOPUP_CARD(1),
        /**
         * 赠送规则
         */
        GIVE_AWAY(2);

        private int value;

        CardFormularCates(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
