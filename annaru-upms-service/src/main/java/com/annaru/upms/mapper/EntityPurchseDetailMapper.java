package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityPurchseDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 企业健康服务客户购买详细记录
 * 
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public interface EntityPurchseDetailMapper extends BaseMapper<EntityPurchseDetail> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<EntityPurchseDetail> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
