package com.annaru.upms.handle.netty;

import com.annaru.upms.handle.netty.handler.BigNettyChannelHandler;
import com.annaru.upms.handle.netty.handler.SmallNettyChannelHandler;
import com.annaru.upms.handle.netty.model.BigNettyChannelMap;
import com.annaru.upms.handle.netty.model.ChannelMsgModel;
import com.annaru.upms.handle.netty.model.SmallNettyChannelMap;
import io.netty.channel.socket.SocketChannel;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@Component
@ConfigurationProperties(prefix = "netty")
public class  NettyServer {
    // 控制线程数，最优选择是处理器线程数*3，本机处理器是4线程
    private final static int THREAD_COUNT = 12;

    /**
     * 小屏端口
     */
    private int smallScreenPort;
    /**
     * 大屏端口
     */
    private int bigScreenPort;

    public void start(){
        // 小屏
        new Thread(new Runnable() {
            @Override
            public void run() {
                new TcpServer(smallScreenPort, new SmallNettyChannelHandler()).init(new IAddNettyChannelMap() {
                    @Override
                    public void execute(SocketChannel channel) {
                        SmallNettyChannelMap.add(Tool.subRemoteAddr(channel.remoteAddress().toString()),
                                new ChannelMsgModel().setChannel(channel).setLastChange(new Date()));
                    }
                });
            }
        }).start();

        // 大屏
        new Thread(new Runnable() {
            @Override
            public void run() {
                new TcpServer(bigScreenPort, new BigNettyChannelHandler()).init(new IAddNettyChannelMap() {
                    @Override
                    public void execute(SocketChannel channel) {
                        BigNettyChannelMap.add(Tool.subRemoteAddr(channel.remoteAddress().toString()),
                                new ChannelMsgModel().setChannel(channel).setLastChange(new Date()));
                    }
                });
            }
        }).start();

    }
}