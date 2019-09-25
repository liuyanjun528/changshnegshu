package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户地址
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface IUserAddressService extends IService<UserAddress> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


    /**
     * @Description:通过Uid修改个人地址
     * @Author: wh
     * @Date: 2019/6/6 16:13
     */
    int updateAddress(UserAddress userAddress);

    /**
     * @Description:通过Uid  地址ID删除个人地址
     * @Author: wh
     * @Date: 2019/6/11 17:46
     */
    int DeleteAddress(String userId,String sysId);

    /**
     * @Description 通过用户编号或sysId修改用户默认地址
     * @Author zk
     * @Date 2019/9/16
     */
    boolean updateDefaultByUserId(Integer isDefault, String userId, Integer sysId);

    /**
     * @Description 通过用户编号得到这个地址
     * @Author zk
     * @Date 2019/9/16
     */
    List<UserAddress> getUserAddress(String userId);

}

