package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamInspectReport;
import com.annaru.upms.entity.ExamInspectReportUploadApp;
import com.annaru.upms.service.IExamInspectReportListService;
import com.annaru.upms.service.IExamInspectReportService;
import com.annaru.upms.service.IExamInspectReportUploadAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    private IExamInspectReportListService examInspectReportListService;
    @Reference
    private IExamInspectReportService examInspectReportService;
    @Reference
    private IExamInspectReportUploadAppService examInspectReportUploadAppService;


    @ApiOperation(value = "获取病人订单下所有报告列表")
    @GetMapping("/getAllByBYH")
    public ResultMap getAllByBYH(@ApiParam(value = "就诊号（订单号^病人姓名拼音全拼，如：123456^xiaochen）") @RequestParam String byh,
                                 @ApiParam(value = "报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）") @RequestParam(required = false) String reportType) {
        try {
            List<ExamInspectReport> list = examInspectReportService.getAllByBYH(byh, reportType);
            return ResultMap.ok().put("data", list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    @ApiOperation(value = "查看详情", notes = "查看详情")
    @GetMapping("/info")
    public ResultMap info(@ApiParam(value = "报告编号", required = true) @RequestParam String reportNO) {
        try {
            ExamInspectReport inspectReport = examInspectReportService.getByReportNO(reportNO);
            return ResultMap.ok().put("data", inspectReport);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


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
