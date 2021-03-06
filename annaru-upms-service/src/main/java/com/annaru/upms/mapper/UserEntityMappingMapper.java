package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserEntityMapping;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.entity.vo.EntityPurchseMainVoZ;
import com.annaru.upms.entity.vo.UserBasicVo;
import com.annaru.upms.entity.vo.UserEntityMappingVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author xck
 * @date 2019-06-03 12:21:40
 */
public interface UserEntityMappingMapper extends BaseMapper<UserEntityMapping> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserEntityMapping> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 选择预约人时查询企业用户及亲属列表
     * @param userId
     * @return
     */
    List<UserBasicVo> selectUserAndRelativeInfoByUserId(@Param("userId") String userId);

    /**
     * @description 企业健康管理首次登陆
     * @author zk
     * @date 2019-07-02
     * @param userId
     * @return
     */
    EntityPurchseMainVoZ getEntityPurchseMainVoZ(@Param("userId") String userId);

}
