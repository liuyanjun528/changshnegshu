package com.annaru.upms.handle.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.TimeUnit;


public final class TcpServer {
    private ChannelHandlerAdapter channelHandlerAdapter;

    private volatile EventLoopGroup bossGroup;

    private volatile EventLoopGroup workerGroup;

    private volatile ServerBootstrap bootstrap;

    private volatile boolean closed = false;

    private int localPort;

    public TcpServer(int localPort, ChannelHandlerAdapter channelHandlerAdapter) {
        this.localPort = localPort;
        this.channelHandlerAdapter = channelHandlerAdapter;
    }

    public void close() {
        closed = true;

        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();

        System.out.println("Stopped Tcp Server: " + localPort);
    }

    public void init(IAddNettyChannelMap iAddNettyChannelMap) {
        closed = false;
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup);
        
        bootstrap.channel(NioServerSocketChannel.class);

        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                iAddNettyChannelMap.execute(ch);
                ch.pipeline().addLast(channelHandlerAdapter);
            }
        });

        doBind();
    }

    protected void doBind() {
        if (closed) {
            return;
        }

        ChannelFuture f= bootstrap.bind(localPort).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture f) throws Exception {
                if (f.isSuccess()) {
                    System.out.println("Started Tcp Server: " + localPort);
                } else {
                    System.out.println("Started Tcp Server Failed: " + localPort);

                    f.channel().eventLoop().schedule(() -> doBind(), 1, TimeUnit.SECONDS);
                }
            }
        });

        try {
            f.sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
