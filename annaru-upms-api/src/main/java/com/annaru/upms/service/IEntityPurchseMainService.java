package com.annaru.upms.service;

import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.entity.vo.EntityPurchseMainVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityPurchseMain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 企业健康服务客户购买记录主表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
public interface IEntityPurchseMainService extends IService<EntityPurchseMain> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 通过订单号查询企业健康服务客户购买记录信息
     * @param orderNo
     * @return
     */
    EntityPurchseMainVo getEntityPurchseMainByOrderNo(String orderNo);

    /**
     * 查询购买企业套餐的用户及其亲属列表
     * @param userId
     * @return
     */
    List<EntityPurchseMainVo> selectEntityPurchseMainListByUserId(String userId);

    /**
     * 根据用户编号和开始时间查询这条记录
     * @author zk
     * @date 2019-06-21
     */
    EntityPurchseMain getTimeByUserIdZ(String userId, String startDate);

}

