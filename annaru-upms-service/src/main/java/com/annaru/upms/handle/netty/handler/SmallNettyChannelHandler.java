package com.annaru.upms.handle.netty.handler;

import com.alibaba.fastjson.JSON;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.handle.netty.Tool;
import com.annaru.upms.handle.netty.model.ChannelMsgModel;
import com.annaru.upms.handle.netty.model.SmallNettyChannelMap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


@ChannelHandler.Sharable
public class SmallNettyChannelHandler extends SimpleChannelInboundHandler<Object> {
    private final static Logger logger = LoggerFactory.getLogger(SmallNettyChannelHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"UTF-8");

        String remoteAddr = Tool.subRemoteAddr(ctx.channel().remoteAddress().toString());
        ChannelMsgModel cmm = new ChannelMsgModel();
        cmm.setChannel(ctx.channel());
        cmm.setMsg(body);
        cmm.setLastChange(new Date());
        SmallNettyChannelMap.add(remoteAddr,cmm);

        try {

            ResultMap resultMap = ResultMap.ok();
            String patientPdStr = JSON.toJSONString(resultMap);

            patientPdStr+="\n";
            byte[] bytes = patientPdStr.getBytes("UTF-8");
            ByteBuf resp = Unpooled.copiedBuffer(bytes);
            SmallNettyChannelMap.get(remoteAddr).getChannel().writeAndFlush(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("成功连接一个叫号小屏：" + remoteAddr);
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
