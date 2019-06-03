package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportUploadAppNode;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 上传送检申请（申请医嘱节点）
 *
 * @author xck
 * @date 2019-05-30 13:35:49
 */
public interface IExamInspectReportUploadAppNodeService extends IService<ExamInspectReportUploadAppNode> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

