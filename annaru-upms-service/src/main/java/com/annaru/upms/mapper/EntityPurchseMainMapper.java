package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityPurchseMain;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.entity.vo.EntityPurchseMainVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 企业健康服务客户购买记录主表
 * 
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public interface EntityPurchseMainMapper extends BaseMapper<EntityPurchseMain> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<EntityPurchseMain> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 通过订单号查询企业健康服务客户购买记录信息
     * @param orderNo
     * @return
     */
    EntityPurchseMainVo getEntityPurchseMainByOrderNo(@Param("orderNo") String orderNo);

    /**
     * 查询购买企业套餐的用户及其亲属列表
     * @param userId
     * @return
     */
    List<EntityPurchseMainVo> selectEntityPurchseMainListByUserId(@Param("userId") String userId);

}
