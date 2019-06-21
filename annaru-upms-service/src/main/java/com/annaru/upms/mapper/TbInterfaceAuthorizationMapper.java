package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbInterfaceAuthorization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户授权信息
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbInterfaceAuthorizationMapper extends BaseMapper<TbInterfaceAuthorization> {


    List<TbInterfaceAuthorization> selectByUserId(@Param("userId") String userId);

}
