package com.annaru.upms.handle.job.task;

import com.alibaba.fastjson.JSON;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.DoctorInfo;
import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.handle.netty.model.ChannelMsgModel;
import com.annaru.upms.handle.netty.model.SmallNettyChannelMap;
import com.annaru.upms.service.IDoctorInfoService;
import com.annaru.upms.service.ILcdBigConfigService;
import com.annaru.upms.service.ILcdShowService;
import com.annaru.upms.service.IScheduleJobLogService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author TuMinglong
 * @description 异步任务测试
 * @Date 2018/5/31 19:18
 */
@Component
public class AsyncTask {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static Random random = new Random();

    @Autowired
    private ILcdBigConfigService lcdBigConfigService;

    @Autowired
    private ILcdShowService lcdShowService;

    @Autowired
    private IDoctorInfoService doctorInfoService;

    @Autowired
    private IScheduleJobLogService scheduleJobLogService;

    @Async
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }


    /**
     * 推消息到小屏
     */
    @Async
    public Future<String> sendSmallScreen() {
        try {
            System.out.println("开始做任务三");
            long start = System.currentTimeMillis();
            //获取所有通道
            Map<String, ChannelMsgModel> allChannelMap = SmallNettyChannelMap.getAll();
            //循环通道
            for (String remoteAddress : allChannelMap.keySet()) {
                //查询ip地址对应的叫号数据
                List<LcdShow> lcdShows = lcdShowService.getLcdShowListByMysql();
                int i = 0;
                while(i++ < 1000){
                    for (LcdShow lcdShow : lcdShows) {

                        if (lcdShow == null || StringUtils.isBlank(lcdShow.getXpdz())) {
                            lcdShow = new LcdShow(remoteAddress, 1);
                        } else if (lcdShow.getUpdateTime() == null || DateUtil.getMinuteBetween(lcdShow.getUpdateTime(), new Date()) >= 30) {
                            lcdShow.setStatus(1);
                        }
                        DoctorInfo doctorInfo = doctorInfoService.getDoctorInfoByName(lcdShow.getYsxm());
                        lcdShow.setYszc(StringUtils.isNotBlank(doctorInfo.getJobTitle())?doctorInfo.getJobTitle():" ");
                        lcdShow.setYstx(StringUtils.isNotBlank(doctorInfo.getPicture())?doctorInfo.getPicture():" ");
                        lcdShow.setYsjj(StringUtils.isNotBlank(doctorInfo.getIntro())?doctorInfo.getIntro():" ");

                        ResultMap resultMap = ResultMap.ok();
                        resultMap.put("data", lcdShow);
                        String patientPdStr = JSON.toJSONString(resultMap);
                        patientPdStr += "\n";
                        byte[] bytes = patientPdStr.getBytes("UTF-8");
                        ByteBuf resp = Unpooled.copiedBuffer(bytes);
                        Channel channel = allChannelMap.get(remoteAddress).getChannel();
                        channel.writeAndFlush(resp);
                        logger.info("成功向小屏(" + remoteAddress + ")推送叫号信息:" + patientPdStr);
                    }
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("推消息到小屏完成");
    }

}
