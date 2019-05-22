package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderAdditionalInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 预约其他信息
 * 
 * @author xck
 * @date 2019-05-20 16:18:39
 */
public interface OrderAdditionalInfoMapper extends BaseMapper<OrderAdditionalInfo> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderAdditionalInfo> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
