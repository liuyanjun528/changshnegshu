package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamInspectReportUploadApp;
import com.annaru.upms.service.IExamInspectReportService;
import com.annaru.upms.service.IExamInspectReportUploadAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 检查报告
 *
 * @author xck
 * @date 2019-05-22 14:28:40
 */
@Api(tags = "A体检报告管理", description = "体检报告管理")
@RestController
@RequestMapping("upms/examInspectReport")
public class ExamInspectReportController extends BaseController {
    @Reference
    private IExamInspectReportService examInspectReportService;
    @Reference
    private IExamInspectReportUploadAppService examInspectReportUploadAppService;


    @ApiOperation(value = "上传送检申请")
    @PostMapping("/upLoadApp")
    public ResultMap upLoadApp(@Valid @RequestBody ExamInspectReportUploadApp uploadApp) {
        try {
            boolean b = examInspectReportUploadAppService.saveUploadApp(uploadApp);
            if(b){
                return ResultMap.ok("送检申请上传成功");
            }
            return ResultMap.error("送检申请上传失败，请稍后重试");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

}
