package com.annaru.upms.service;

import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
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
     * 通过用户查询亲属列表
     * @param userId
     * @return
     */
    List<EntityHealthyAppointmentVo> selectUserAndRelative(@Param("userId") String userId);

    /**
     * 查询用户或亲属信息详情
     * @param userId
     * @return
     */
    EntityHealthyAppointmentVo selectUserOrRelativeInfo(@Param("userId") String userId, @Param("userCate") Integer userCate);

}

