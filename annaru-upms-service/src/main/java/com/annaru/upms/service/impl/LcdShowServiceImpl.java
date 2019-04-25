package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.handle.netty.model.BigNettyChannelMap;
import com.annaru.upms.handle.netty.model.ChannelMsgModel;
import com.annaru.upms.handle.netty.model.SmallNettyChannelMap;
import com.annaru.upms.mapper.LcdShowMapper;
import com.annaru.upms.service.ILcdShowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wh
 * @date 2019-03-29 11:33:31
 */
@Service
public class LcdShowServiceImpl extends ServiceImpl<LcdShowMapper, LcdShow> implements ILcdShowService {

    @Override
    public List<LcdShow> getLcdShowListByMysql() {
        return this.baseMapper.selectLcdShowByMysql();
    }

    @Override
    public List<LcdShow> getLcdShowListBySqlServer() {
        return this.baseMapper.selectLcdShowBySqlServer();
    }

    @Override
    public void updateByXpdz(LcdShow lcdShow) {
        if(StringUtils.isBlank(lcdShow.getXpdz())){
            return;
        }
        this.baseMapper.updateByXpdz(lcdShow);
    }

    @Override
    public LcdShow getByXpdz(String xpdz) {
        if (StringUtils.isBlank(xpdz)) {
            return null;
        }
        return this.baseMapper.selectByXpdz(xpdz);
    }

    @Override
    public void clearEmpty() {
        this.baseMapper.delete(null);
    }

    @Override
    public List<Map<String, String>> getLcdSmallList() {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, ChannelMsgModel> msgModelMap = SmallNettyChannelMap.getAll();
        Map<String, String> map;
        for (String clientId : msgModelMap.keySet()) {
            ChannelMsgModel channelMsgModel = msgModelMap.get(clientId);
            map = new HashMap<>();
            map.put("connectionIp", clientId);
            map.put("connectionMsg", channelMsgModel.getMsg());
            map.put("connectionTime", DateUtil.format(channelMsgModel.getLastChange(), DateUtil.DATE_PATTERN.YYYY_MM_DD_HH_MM_SS));
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public List<Map<String, String>> getLcdBigList() {List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, ChannelMsgModel> msgModelMap = BigNettyChannelMap.getAll();
        Map<String, String> map;
        for (String clientId : msgModelMap.keySet()) {
            ChannelMsgModel channelMsgModel = msgModelMap.get(clientId);
            map = new HashMap<>();
            map.put("connectionIp", clientId);
            map.put("connectionMsg", channelMsgModel.getMsg());
            map.put("connectionTime", DateUtil.format(channelMsgModel.getLastChange(), DateUtil.DATE_PATTERN.YYYY_MM_DD_HH_MM_SS));
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public void deleteBigByIds(String[] ids) {
        for (String id : ids) {
            SmallNettyChannelMap.remove(id);
        }
    }

    @Override
    public void deleteSmallByIds(String[] ids) {
        for (String id : ids) {
            BigNettyChannelMap.remove(id);
        }
    }
}
