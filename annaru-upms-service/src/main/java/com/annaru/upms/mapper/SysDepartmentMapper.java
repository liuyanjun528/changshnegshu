package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysDepartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 科室
 * 
 * @author xck
 * @date 2019-05-10 10:44:18
 */
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysDepartment> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    List<SysDepartment> getDepartmentCommonList(@Param("params") Map<String, Object> params);


}
