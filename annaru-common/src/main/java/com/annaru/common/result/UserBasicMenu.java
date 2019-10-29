package com.annaru.common.result;

public enum UserBasicMenu {
    CODE(601,"code"),
    MSG(602,"msg"),
    USER_IS_NULL(10, "用户不存在"),
    USER_ID_NOT_NULL(20, "用户id不能为空"),
    PAYMENT_PINNO_NOT_NULL(30, "支付密码不能为空"),
    WEI_SHE_ZHI_ZHI_FU_MI_MA(0, "未设置支付密码"),
    YI_SHE_ZHI_ZHI_FU_MI_MA(1, "已设置支付密码"),
    ZHI_FU_MA_MA_YAN_ZHEN_OK(3, "支付密码验证成功"),
    ZHI_FU_MA_MA_YAN_ZHEN_ERROR(4, "支付密码验证错误"),
    SHE_ZHI_ZHI_FU_MI_MA_OK(50, "设置支付密码成功"),
    SHE_ZHI_ZHI_FU_MI_MA_ERROR(60, "设置支付密码错误"),
    YON_HU_PHONENO_VALIDATED_OK(70, "用户手机验证ok"),
    YON_HU_PHONENO_VALIDATED_ERROR(80, "用户手机验证错误"),
    MESSAGE_SENT_SUCCESS(90, "短信发送成功"),
    MESSAGE_SENT_ERROR(100, "短信发送失败"),
    PHONENO_ERROR(110, "手机号格式错误"),
    VERIFICATION_CODE_EXPIRED(700, "验证码无效");

    int code;
    String message;

    UserBasicMenu(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
