package com.annaru.upms.service;

import com.annaru.upms.entity.vo.EntityPurchseMainVoZ;
import com.annaru.upms.entity.vo.UserBasicVo;
import com.annaru.upms.entity.vo.UserEntityMappingVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserEntityMapping;
import java.util.List;
import java.util.Map;

/**
 * @author xck
 * @date 2019-06-03 12:21:40
 */
public interface IUserEntityMappingService extends IService<UserEntityMapping> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 选择预约人时查询企业用户及亲属列表
     * @param userId
     * @return
     */
    List<UserBasicVo> selectUserAndRelativeInfoByUserId(String userId);

    /**
     * @description 企业健康管理首次登陆
     * @author zk
     * @date 2019-07-02
     * @param userId
     * @return
     */
    EntityPurchseMainVoZ getEntityPurchseMainVoZ(String userId);

}

