package com.annaru.upms.service;

import com.annaru.upms.entity.vo.OrderReceiptInfoExtends;
import com.annaru.upms.entity.vo.OrderReceiptInfoSave;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderReceiptInfo;
import java.util.List;
import java.util.Map;

/**
 * 开票记录
 *
 * @author zk
 * @date 2019-10-11 13:42:07
 */
public interface IOrderReceiptInfoService extends IService<OrderReceiptInfo> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 开票中/已开票订单（列表）
     * @author zk
     * @date 2019/10/11
     */
    PageUtils receiptOfStatusList(Map<String, Object> params);

    /**
     * 开具发票保存
     * @param oro
     * @param ors
     * @return
     * @author zk
     * @date 2019/10/11
     */
    boolean receiptSave(OrderReceiptInfo oro, OrderReceiptInfoSave ors);

    /**
     * 发票详情
     * @author zk
     * @date 2019/10/12
     */
    OrderReceiptInfoExtends receiptDetail(String receiptNo);

}

