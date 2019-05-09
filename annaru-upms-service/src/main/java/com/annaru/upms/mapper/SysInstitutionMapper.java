package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysInstitution;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 医院机构
 * 
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface SysInstitutionMapper extends BaseMapper<SysInstitution> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysInstitution> selectDataPage(Page page, @Param("params") Map <String, Object> params);


}
