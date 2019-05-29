package com.annaru.upms.service;

import com.annaru.upms.entity.UserBasic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.EntityHealthyAppointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 企业服务预约记录
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public interface IEntityHealthyAppointmentService extends IService<EntityHealthyAppointment> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


    /**
     * 通过用户查询亲属
     * @param userId
     * @return
     */
    List<UserBasic> selectUserAndRelative(@Param("userId") String userId);

}
