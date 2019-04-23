package com.annaru.upms.handle.netty.model;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SmallNettyChannelMap {

    private static Map<String, ChannelMsgModel> map = new ConcurrentHashMap<String, ChannelMsgModel>();

    public static void add(String clientId, ChannelMsgModel channelMsgModel) {
        map.put(clientId, channelMsgModel);
    }

    public static ChannelMsgModel get(String clientId) {
        return map.get(clientId);
    }

    public static Map<String, ChannelMsgModel> getAll() {
        return map;
    }

    public static void remove(Channel socketChannel) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == socketChannel) {
                map.remove(entry.getKey());
            }
        }
    }

    public static void clear(){
        map.clear();
    }
}
