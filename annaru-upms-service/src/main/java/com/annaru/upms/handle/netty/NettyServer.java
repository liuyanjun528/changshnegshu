package com.annaru.upms.handle.netty;

import io.netty.channel.socket.SocketChannel;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@Component
@ConfigurationProperties(prefix = "netty")
public class  NettyServer {
    protected static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    private int port;

    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                new TcpServer(port,new NettyChannelHandler()).init(new IAddNettyChannelMap() {
                    @Override
                    public void execute(SocketChannel ch) {
                        NettyChannelMap.add(Tool.subRemoteAddr(ch.remoteAddress().toString()),
                                new ChannelMsgModel().setChannel(ch)
                                        .setLastChange(new Date()));
                    }
                });
            }
        }).start();
    }
}