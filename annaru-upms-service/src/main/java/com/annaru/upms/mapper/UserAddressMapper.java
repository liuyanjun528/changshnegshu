package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 用户地址
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface UserAddressMapper extends BaseMapper<UserAddress> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserAddress> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
      * @Description:通过Uid 地址ID修改个人地址
      * @Author: wh
      * @Date: 2019/6/6 16:13
      */
    int updateAddress(UserAddress userAddress);

    /**
     * @Description:通过Uid  地址ID删除个人地址
     * @Author: wh
     * @Date: 2019/6/11 17:46
     */
    int DeleteAddress(@Param("userId") String userId,@Param("sysId") String sysId);


}
