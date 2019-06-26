package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityHealthyPackageDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 企业健康服务详细表
 * 
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public interface EntityHealthyPackageDetailMapper extends BaseMapper<EntityHealthyPackageDetail> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<EntityHealthyPackageDetail> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 根据userId得到这个企业健康服务详细
     * @author zk
     * @param userId
     * @return
     */
    List<EntityHealthyPackageDetail> getEyHyPeDlByUserId(@Param("userId") String userId);

}
