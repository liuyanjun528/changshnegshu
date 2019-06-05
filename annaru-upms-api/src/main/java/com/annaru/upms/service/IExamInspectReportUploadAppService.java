package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportUploadApp;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.Valid;
import java.util.Map;

/**
 * 上传送检申请
 *
 * @author xck
 * @date 2019-05-30 13:35:49
 */
public interface IExamInspectReportUploadAppService extends IService<ExamInspectReportUploadApp> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 保存送检申请
     * @param uploadApp 送检申请
     * @return
     */
    boolean saveUploadApp(@Valid ExamInspectReportUploadApp uploadApp);

}

