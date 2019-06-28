package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysSubDepartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 二级科室(预约)
 * 
 * @author xck
 * @date 2019-06-27 16:05:36
 */
public interface SysSubDepartmentMapper extends BaseMapper<SysSubDepartment> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysSubDepartment> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
