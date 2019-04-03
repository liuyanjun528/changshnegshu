package com.annaru.upms.handle.netty.model;

import io.netty.channel.Channel;

import java.util.Date;

public class ChannelMsgModel {

    private Channel channel;
    private String msg;
    private Date lastChange;

    public Channel getChannel() {
        return channel;
    }

    public ChannelMsgModel setChannel(Channel channel) {
        this.channel = channel;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Date getLastChange() {
        return lastChange;
    }

    public ChannelMsgModel setLastChange(Date lastChange) {
        this.lastChange = lastChange;
        return this;
    }

}
