package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 资源表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

    List<SysResource> selectResourceList(Map<String, Object> params);

}
