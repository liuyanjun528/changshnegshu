package com.annaru.upms.handle.job.task;

import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.service.ILcdShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("callTask")
public class CallTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ILcdShowService callService;

    /**
     * 检查主从数据库 进行比较
     * 1、从创业数据库 查询当天所有叫号数据
     * 2、获取本地数据库 当天所有叫号数据
     * 3、两个数据库当天叫号数据对比 保存到本地数据库
     */
    public void checkUpdateDb() {
        //获取本地数据库
        List<LcdShow> localList = callService.getLcdShowListByMysql();
        //获取创业数据库
        List<LcdShow> cyList = callService.getLcdShowListBySqlServer();
        //循环对比
        for (LcdShow cyCall : cyList) {
            if (localList.contains(cyCall)){
                // 相同跳过 不同则继续往下对比
                continue;
            }
            //对比到不同 插入本地数据库
            cyCall.insert();
        }

    }

    /**
     * 推消息到客户端
     *
     */
    public void sendMsg(){
        //获取所有通道
//        Map<String, ChannelMsgModel> allChannel = NettyChannelMap.getAll();
//        //循环通道
//        for (String str : allChannel.keySet()) {
//            //查询更新过的数据库通过Ip
//            List<Call> upList = callService.getCallListByOracle();
//            allChannel.put("upList")
//        }

    }


}
