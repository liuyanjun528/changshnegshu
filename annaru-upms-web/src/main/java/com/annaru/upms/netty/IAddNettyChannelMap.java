package com.annaru.upms.netty;

import io.netty.channel.socket.SocketChannel;

public interface IAddNettyChannelMap {

    void execute(SocketChannel ch);

}
