package com.annaru.upms.handle.job.task;

import com.alibaba.fastjson.JSON;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.DoctorPhoto;
import com.annaru.upms.entity.LcdBigConfig;
import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.handle.netty.model.BigNettyChannelMap;
import com.annaru.upms.handle.netty.model.ChannelMsgModel;
import com.annaru.upms.handle.netty.model.SmallNettyChannelMap;
import com.annaru.upms.service.IDoctorPhotoService;
import com.annaru.upms.service.ILcdBigConfigService;
import com.annaru.upms.service.ILcdShowService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
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

    @Autowired
    private ILcdBigConfigService lcdBigConfigService;

    @Autowired
    private IDoctorPhotoService doctorPhotoService;

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
        for (LcdShow cyCall : cyList) {
            if (localList.contains(cyCall)) {
                continue;
            }
            if (StringUtils.isBlank(cyCall.getXpdz())) {
                continue;
            }
            //判断数据库是否已存在对应ip的叫号信息，若存在则更新数据
            LcdShow lcdShow = lcdShowService.getByXpdz(cyCall.getXpdz());
            if (lcdShow != null) {
                lcdShowService.updateByXpdz(cyCall);
            } else {
                lcdShowService.save(cyCall);
            }
        }
        logger.info("定时任务：成功从创业数据库更新叫号数据");
    }


    /**
     * 推消息到小屏
     */
    public void sendSmallScreen() {
        try {
            //获取所有通道
            Map<String, ChannelMsgModel> allChannelMap = SmallNettyChannelMap.getAll();
            //循环通道
            for (String remoteAddress : allChannelMap.keySet()) {
                //查询ip地址对应的叫号数据
                LcdShow lcdShow = lcdShowService.getByXpdz(remoteAddress);
                if (lcdShow == null) {
                    lcdShow = new LcdShow(remoteAddress, "xxx", "0000", "诊室", "格言", "0000", "停诊");
                }
                DoctorPhoto doctorPhoto = doctorPhotoService.getByDoctorName(lcdShow.getYsxm());
                lcdShow.setYszc("主任医生");
                lcdShow.setYstx(doctorPhoto.getDoctorImg());
                if (StringUtils.isBlank(lcdShow.getBrxm()) || "停诊".equals(lcdShow.getBrxm().trim())) {
                    lcdShow.setYszt("停诊");
                } else {
                    lcdShow.setYszt("就诊");
                }
                ResultMap resultMap = ResultMap.ok();
                resultMap.put("data", lcdShow);
                String patientPdStr = JSON.toJSONString(resultMap);
                patientPdStr += "\n";
                byte[] bytes = patientPdStr.getBytes("UTF-8");
                ByteBuf resp = Unpooled.copiedBuffer(bytes);
                Channel channel = allChannelMap.get(remoteAddress).getChannel();
                channel.writeAndFlush(resp);
                logger.info("成功向小屏(" + remoteAddress + ")推送叫号信息");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 推消息到大屏
     */
    public void sendBigScreen() {
        try {
            //获取所有通道
            Map<String, ChannelMsgModel> allChannelMap = BigNettyChannelMap.getAll();
            //循环通道
            for (String remoteAddress : allChannelMap.keySet()) {
                // 获取数据库大屏配置信息
                LcdBigConfig lcdBigConfig = lcdBigConfigService.getByParentIp(remoteAddress);
                if (lcdBigConfig == null || StringUtils.isBlank(lcdBigConfig.getChildrenIp())){
                    continue;
                }
                // 解析大屏配置对应的所有小屏ip，并查询ip对应的叫号数据推送至大屏
                String[] ips = lcdBigConfig.getChildrenIp().split(",");
                for (String ip : ips) {
                    LcdShow lcdShow = lcdShowService.getByXpdz(ip);
                    if (lcdShow == null) {
                        continue;
                    }
                    ResultMap resultMap = ResultMap.ok().put("data", lcdShow);
                    String patientPdStr = JSON.toJSONString(resultMap);
                    patientPdStr += "\n";
                    byte[] bytes = patientPdStr.getBytes("UTF-8");
                    ByteBuf resp = Unpooled.copiedBuffer(bytes);
                    Channel channel = allChannelMap.get(remoteAddress).getChannel();
                    channel.writeAndFlush(resp);
                    logger.info("成功向大屏(" + remoteAddress + ")推送叫号信息");
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 清除数据库当天数据
     * @param
     * @Author: XCK
     * @Date: 2019/4/2
     * @return
     */
    public void clearEmpty() {
        lcdShowService.clearEmpty();
        logger.info("定时任务：清空本地数据库当天所有叫号数据");
    }

}
