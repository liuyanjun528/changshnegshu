package com.annaru.upms.handle.netty;

import com.alibaba.fastjson.JSON;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.LcdShow;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.Date;


@ChannelHandler.Sharable
public class NettyChannelHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");

        System.out.println("连接以后我就出现=============");

        String remoteAddr = Tool.subRemoteAddr(ctx.channel().remoteAddress().toString());
        ChannelMsgModel cmm = new ChannelMsgModel();
        cmm.setChannel(ctx.channel());
        cmm.setLastChange(new Date());
        NettyChannelMap.add(remoteAddr,cmm);

        try {
            // TODO  待定
            LcdShow lcd = new LcdShow();
            lcd.setBrxm("你吃饭了吗");
            ResultMap resultMap = ResultMap.ok("我是msg").put("lcd", lcd);
            String patientPdStr = JSON.toJSONString(resultMap);
            patientPdStr+="\n";
            byte[] bytes = patientPdStr.getBytes("UTF-8");
            ByteBuf resp = Unpooled.copiedBuffer(bytes);
            NettyChannelMap.get(remoteAddr).getChannel().writeAndFlush(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
