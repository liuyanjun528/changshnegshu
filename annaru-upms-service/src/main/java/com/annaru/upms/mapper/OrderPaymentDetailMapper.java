package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderPaymentDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 分期还款表
 * 
 * @author xck
 * @date 2019-06-13 11:27:39
 */
public interface OrderPaymentDetailMapper extends BaseMapper<OrderPaymentDetail> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderPaymentDetail> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
