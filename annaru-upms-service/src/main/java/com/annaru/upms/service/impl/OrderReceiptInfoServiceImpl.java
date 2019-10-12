package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.OrderReceiptOrderMapping;
import com.annaru.upms.entity.vo.OrderReceiptInfoExtends;
import com.annaru.upms.entity.vo.OrderReceiptInfoSave;
import com.annaru.upms.service.IOrderReceiptOrderMappingService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.OrderReceiptInfoMapper;
import com.annaru.upms.entity.OrderReceiptInfo;
import com.annaru.upms.service.IOrderReceiptInfoService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 开票记录
 *
 * @author zk
 * @date 2019-10-11 13:42:07
 */
@Service
public class OrderReceiptInfoServiceImpl extends ServiceImpl<OrderReceiptInfoMapper, OrderReceiptInfo> implements IOrderReceiptInfoService {

    @Resource
    private IOrderReceiptInfoService orderReceiptInfoService;
    @Resource
    private IOrderReceiptOrderMappingService orderReceiptOrderMappingService;

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderReceiptInfo> page = new PageUtils<OrderReceiptInfo>(params).getPage();
        IPage<OrderReceiptInfo> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderReceiptInfo>(iPage);
    }

    @Override
    public PageUtils receiptOfStatusList(Map<String, Object> params){
        Page<OrderReceiptInfoExtends> page = new PageUtils<OrderReceiptInfoExtends>(params).getPage();
        IPage<OrderReceiptInfoExtends> iPage = this.baseMapper.receiptOfStatusList(page, params);
        return new PageUtils<OrderReceiptInfoExtends>(iPage);
    }

    @Override
    @Transactional
    public boolean receiptSave(OrderReceiptInfo oro, OrderReceiptInfoSave ors) {
        if (orderReceiptInfoService.save(oro)){
            OrderReceiptOrderMapping orom = null;
            List<OrderReceiptOrderMapping> oromList = new ArrayList<>();
            if (ors.getStrList() != null && ors.getStrList().size() > 0){
                for (int i = 0 ; i < ors.getStrList().size() ; i++){
                    orom = new OrderReceiptOrderMapping();
                    orom.setReceiptNo(oro.getReceiptNo());
                    orom.setOrderNo(ors.getStrList().get(i));
                    orom.setCreationTime(new Date());
                    oromList.add(orom);
                }
                if (orderReceiptOrderMappingService.saveBatch(oromList)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public OrderReceiptInfoExtends receiptDetail(String receiptNo) {
        return this.baseMapper.receiptDetail(receiptNo);
    }

}
