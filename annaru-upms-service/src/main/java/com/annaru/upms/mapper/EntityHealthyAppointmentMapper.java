package com.annaru.upms.mapper;

import com.annaru.upms.entity.EntityHealthyAppointment;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 企业服务预约记录
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public interface EntityHealthyAppointmentMapper extends BaseMapper<EntityHealthyAppointment> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<EntityHealthyAppointment> selectDataPage(Page page, @Param("params") Map<String, Object> params);

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
