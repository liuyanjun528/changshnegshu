package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderReceiptInfo;
import com.annaru.upms.entity.vo.OrderReceiptInfoExtends;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 开票记录
 * 
 * @author zk
 * @date 2019-10-11 13:42:07
 */
public interface OrderReceiptInfoMapper extends BaseMapper<OrderReceiptInfo> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderReceiptInfo> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 开票中/已开票订单（列表）
     * @author zk
     * @date 2019/10/11
     */
    IPage<OrderReceiptInfoExtends> receiptOfStatusList(Page page, @Param("params") Map<String, Object> params);

    /**
     * 发票详情
     * @author zk
     * @date 2019/10/12
     */
    OrderReceiptInfoExtends receiptDetail(@Param("receiptNo") String receiptNo);

}
