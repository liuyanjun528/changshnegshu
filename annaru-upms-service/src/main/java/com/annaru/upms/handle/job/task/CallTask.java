package com.annaru.upms.handle.job.task;

import com.alibaba.fastjson.JSON;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.handle.netty.ChannelMsgModel;
import com.annaru.upms.handle.netty.NettyChannelMap;
import com.annaru.upms.handle.netty.Tool;
import com.annaru.upms.service.ILcdShowService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


@Component("callTask")
public class CallTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ILcdShowService lcdShowService;

    /**
     * 检查主从数据库 进行比较
     * 1、从创业数据库 查询当天所有叫号数据
     * 2、获取本地数据库 当天所有叫号数据
     * 3、两个数据库当天叫号数据对比 保存到本地数据库
     */
    public void checkUpdateDb() {
        //获取本地数据库
        List<LcdShow> localList = lcdShowService.getLcdShowListByMysql();
        //获取创业数据库
        List<LcdShow> cyList = lcdShowService.getLcdShowListBySqlServer();
        //循环对比
        for (LcdShow cyCall : cyList) {
            if (localList.contains(cyCall)) {
                continue;
            }
            if (StringUtils.isBlank(cyCall.getXpdz())) {
                continue;
            }
            //获取小屏 判断数据库是或否存在，存在则更新，否则插入
            LcdShow lcdShow = lcdShowService.getByXpdz(cyCall.getXpdz());
            if (lcdShow != null) {
                lcdShowService.updateByXpdz(cyCall);
            } else {
                lcdShowService.save(cyCall);
            }
        }
        System.err.println("检查主从数据库 进行比较~~~~~~");
    }


    /**
     * 推消息到客户端
     */
    public void sendMsg() throws UnsupportedEncodingException {
        //获取所有通道
        Map<String, ChannelMsgModel> allChannelMap = NettyChannelMap.getAll();
        //循环通道
        for (String remoteAddress : allChannelMap.keySet()) {
            //查询更新过的数据库通过 时间 --里面保存的是要推送的信息
            LcdShow lcdShow = lcdShowService.getByXpdz(remoteAddress);
            lcdShow.setYszc("主任医生");
            if(StringUtils.isBlank(lcdShow.getBrxm())
                    || "停诊".equals(lcdShow.getBrxm().trim())){
                lcdShow.setYszt("停诊");
            }else{
                lcdShow.setYszt("就诊");
            }
            ResultMap resultMap = ResultMap.ok().put("data", lcdShow);
            //获取通道IP
            Channel channel = allChannelMap.get(remoteAddress).getChannel();
            String remoteAddr = Tool.subRemoteAddr(channel.remoteAddress().toString());
            String patientPdStr = JSON.toJSONString(resultMap);
            patientPdStr+="\n";
            byte[] bytes = patientPdStr.getBytes("UTF-8");
            ByteBuf resp = Unpooled.copiedBuffer(bytes);
            NettyChannelMap.get(remoteAddr).getChannel().writeAndFlush(resp);
        }
        System.err.println("推消息到客户端---------");
    }

}
