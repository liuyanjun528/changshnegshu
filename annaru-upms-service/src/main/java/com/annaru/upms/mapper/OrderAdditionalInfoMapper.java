package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderAdditionalInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import java.util.Map;

/**
 * 预约其他信息
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public interface OrderAdditionalInfoMapper extends BaseMapper<OrderAdditionalInfo> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderAdditionalInfo> selectDataPage(Page page, @Param("params") Map<String, Object> params);


    /**
     * 添加绿通行
     * @param option_1 门诊类型
     * @param option_2 陪诊
     * @param situations 病情
     * @return
     */
    int insertAdditional_info(@Param("params") Map<String, Object> params);



}
