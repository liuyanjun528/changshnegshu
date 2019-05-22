package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserBasic;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface IUserBasicService extends IService<UserBasic> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 修改旧密码
     * @param password
     * @param userId
     * @return
     */
    int updateOldPwd(@Param("password") String password, @Param("userId") String userId);
    UserBasic selectByUid(@Param("userId") String userId);

}

