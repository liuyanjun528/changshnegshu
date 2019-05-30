package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamInspectReport;
import com.annaru.upms.entity.ExamInspectReportList;
import com.annaru.upms.service.IExamInspectReportListService;
import com.annaru.upms.service.IExamInspectReportService;
import com.annaru.upms.webservice.LisWebServiceSoap12_Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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

    @ApiOperation(value = "获取登录令牌")
    @GetMapping("/Login")
    public ResultMap Login(@ApiParam(value = "登录ID号", defaultValue = "961002") @RequestParam String LogID,
                           @ApiParam(value = "登录密码", defaultValue = "961002") @RequestParam String LogPass) {
        try {
            Map<String, Object> resData = LisWebServiceSoap12_Client.Login(LogID, LogPass);
            if (resData == null) {
                return ResultMap.error("登陆失败:用户名或密码错误");
            }
            return ResultMap.ok().put("data", resData);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    @ApiOperation(value = "获取报告单列表")
    @GetMapping("/list")
    public ResultMap list(@ApiParam(value = "访问口令", required = true) @RequestParam String token,
                          @ApiParam(value = "机构代码", required = true) @RequestParam String logID,
                          @ApiParam(value = "申请机构代码(医院代码)", required = true) @RequestParam String appCode,
                          @ApiParam(value = "指定执行机构代码") @RequestParam(required = false) String exeCode,
                          @ApiParam(value = "开始申请日期（yyyy-MM-dd）") @RequestParam(defaultValue = "2000-01-01") String startDate,
                          @ApiParam(value = "截止申请日期（yyyy-MM-dd）") @RequestParam(required = false) String endDate,
                          @ApiParam(value = "申请机构条码") @RequestParam(required = false) String appBarcode,
                          @ApiParam(value = "执行机构条码") @RequestParam(required = false) String exeBarcode,
                          @ApiParam(value = "报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）") @RequestParam(required = false) String reportType) {
        try {

            // 获取千麦报告列表，并更新到本地数据库
            List<ExamInspectReportList> reportLists = LisWebServiceSoap12_Client.GetResultLists(token, logID, appCode, exeCode, startDate, endDate, appBarcode, exeBarcode, reportType, "0");
            if(CollectionUtils.isNotEmpty(reportLists)){
                examInspectReportListService.saveBatchInspectReportList(logID, reportLists);
            }

            // 获取列表信息
            Map<String, Object> params = new HashMap<>();
            params.put("logID", logID);
            params.put("appBarcode", appBarcode);
            params.put("exeBarcode", exeBarcode);
            params.put("reportType", reportType);

            List<ExamInspectReportList> list = examInspectReportListService.getDataList(params);
            return ResultMap.ok().put("data", list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    @ApiOperation(value = "查看详情", notes = "查看详情")
    @GetMapping("/info")
    public ResultMap info(@ApiParam(value = "访问口令", required = true) @RequestParam String token,
                          @ApiParam(value = "机构代码", required = true) @RequestParam String logID,
                          @ApiParam(value = "报告编号", required = true) @RequestParam String reportNO,
                          @ApiParam(value = "申请机构代码(医院代码)") @RequestParam(required = false) String appCode,
                          @ApiParam(value = "指定执行机构代码") @RequestParam(required = false) String exeCode,
                          @ApiParam(value = "申请机构条码") @RequestParam(required = false) String appBarcode,
                          @ApiParam(value = "执行机构条码") @RequestParam(required = false) String exeBarcode,
                          @ApiParam(value = "报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）") @RequestParam(required = false) String reportType) {

        ExamInspectReport inspectReport = examInspectReportService.getByReportNO(logID, reportNO);
        if(inspectReport==null || "0".equals(inspectReport.getWCBZ())){
            // 当本地数据库没有数据 或者 本地数据是未全部完成状态 则重新从第三方下载并更新数据
            List<ExamInspectReport> reportList = LisWebServiceSoap12_Client.downLoadResult(token, logID, reportNO, appCode, exeCode, appBarcode, exeBarcode, reportType);
            if(CollectionUtils.isNotEmpty(reportList)){
                for (ExamInspectReport report : reportList) {
                    // 保存检查结果
                    boolean bool = examInspectReportService.saveInspectReport(report);
                    // 检查送检条码是否全部检测完成
                    if(bool && "1".equals(report.getWCBZ())){
                        LisWebServiceSoap12_Client.updateStatus(token, logID, reportNO, appCode, exeCode, appBarcode, exeBarcode);
                    }
                }
                inspectReport = examInspectReportService.getByReportNO(logID, reportNO);
            }
        }
        return ResultMap.ok().put("data", inspectReport);
    }

}
