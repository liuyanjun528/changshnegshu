package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReportUploadAppNode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 上传送检申请（申请医嘱节点）
 * 
 * @author xck
 * @date 2019-05-30 13:35:49
 */
public interface ExamInspectReportUploadAppNodeMapper extends BaseMapper<ExamInspectReportUploadAppNode> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamInspectReportUploadAppNode> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
