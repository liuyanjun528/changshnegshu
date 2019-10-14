package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderReceiptOrderMapping;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 发票订单关联
 * 
 * @author zk
 * @date 2019-10-11 13:42:07
 */
public interface OrderReceiptOrderMappingMapper extends BaseMapper<OrderReceiptOrderMapping> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderReceiptOrderMapping> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
