package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReportUploadApp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 上传送检申请
 * 
 * @author xck
 * @date 2019-05-30 13:35:49
 */
public interface ExamInspectReportUploadAppMapper extends BaseMapper<ExamInspectReportUploadApp> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamInspectReportUploadApp> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
