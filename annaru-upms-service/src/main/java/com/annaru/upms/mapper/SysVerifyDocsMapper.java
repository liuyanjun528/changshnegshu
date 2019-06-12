package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysVerifyDocs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 认证资料
 * 
 * @author xck
 * @date 2019-06-10 14:59:12
 */
public interface SysVerifyDocsMapper extends BaseMapper<SysVerifyDocs> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysVerifyDocs> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
