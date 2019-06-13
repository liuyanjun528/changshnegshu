package com.annaru.upms.im.rong;

public enum RongYunKeyEnum {

    APPKEY("APPKEY","pwe86ga5p4a56"),
    APPSECRET("APPSECRET","AsfSo3E2qftzNE");

    private String key;
    private String value;

    private RongYunKeyEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
