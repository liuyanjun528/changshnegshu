package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
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
import java.util.HashMap;
import java.util.Map;

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

    @ApiOperation(value = "获取报告单列表")
    @GetMapping("/list")
    public ResultMap list(@ApiParam(value = "当前页", defaultValue = "1")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量", defaultValue = "10")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "开始日期", required = true) @RequestParam String startDate,
                          @ApiParam(value = "结束日期") @RequestParam(required = false) String endDate,
                          @ApiParam(value = "申请机构条码") @RequestParam(required = false) String appBarcode,
                          @ApiParam(value = "执行机构条码") @RequestParam(required = false) String exeBarcode,
                          @ApiParam(value = "报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）") @RequestParam(required = false) String reportType) {
        try {

            // 获取列表信息
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("startDate", startDate);
            params.put("endDate", endDate);
            params.put("appBarcode", appBarcode);
            params.put("exeBarcode", exeBarcode);
            params.put("reportType", reportType);

            PageUtils<ExamInspectReport> pageList = examInspectReportService.getDataPage(params);
            return ResultMap.ok().put("data", pageList);
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
