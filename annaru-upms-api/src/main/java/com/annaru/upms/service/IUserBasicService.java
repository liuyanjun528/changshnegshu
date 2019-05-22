package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserBasic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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
     * 根据条件查询某个用户
     * @param params
     * @return
     */
    UserBasic selectByData(Map<String, Object> params);

    /**
     * 根据条件查询某个用户信息与医生信息
     * @param params
     * @return
     */
    UserBasic selectDoctorByData(Map<String, Object> params);

    /**
     * 根据条件查询某个用户信息与护士信息
     * @param params
     * @return
     */
    UserBasic selectNurseByData(Map<String, Object> params);
    /**
     * 修改旧密码
     * @param password
     * @param userId
     * @return
     */
    int updateOldPwd(@Param("password") String password, @Param("userId") String userId);
    UserBasic selectByUid(@Param("userId") String userId);


}

