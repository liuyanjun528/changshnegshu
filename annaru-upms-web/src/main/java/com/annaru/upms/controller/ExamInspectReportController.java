package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamInspectReport;
import com.annaru.upms.entity.ExamInspectReportResult;
import com.annaru.upms.service.IExamInspectReportService;
import com.annaru.upms.webservice.LisWebServiceSoap12_Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 检查报告
 *
 * @author xck
 * @date 2019-05-22 14:28:40
 */
@Api(tags = "体检报告管理", description = "体检报告管理")
@RestController
@RequestMapping("upms/examInspectReport")
public class ExamInspectReportController extends BaseController {
    @Reference
    private IExamInspectReportService examInspectReportService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    public ResultMap list(@ApiParam(value = "访问口令", required = true) @RequestParam String token,
                          @ApiParam(value = "机构代码", required = true) @RequestParam String logID,
                          @ApiParam(value = "申请机构代码", required = true) @RequestParam String sjgdm,
                          @ApiParam(value = "指定执行机构代码") @RequestParam(required = false) String djgdm,
                          @ApiParam(value = "开始申请日期（yyyy-MM-dd）", required = true) @RequestParam String startDate,
                          @ApiParam(value = "截止申请日期（yyyy-MM-dd）", required = true) @RequestParam String endDate,
                          @ApiParam(value = "申请机构条码") @RequestParam(required = false) String appBarcode,
                          @ApiParam(value = "执行机构条码") @RequestParam(required = false) String exeBarcode,
                          @ApiParam(value = "报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）") @RequestParam(required = false) String bglx) {

        try {

            // 获取千麦报告列表，并更新到本地数据库
            this.getResultLists(token, logID, sjgdm, djgdm, startDate, endDate, appBarcode, exeBarcode, bglx, "0");
            // 获取列表信息
            Map<String, Object> params = new HashMap<>();
            params.put("logID", logID);
            params.put("sjgdm", sjgdm);
            params.put("djgdm", djgdm);
            params.put("startDate", startDate);
            params.put("endDate", endDate);
            params.put("appBarcode", appBarcode);
            params.put("exeBarcode", exeBarcode);
            params.put("bglx", bglx);

            List<Map<String, String>> list = examInspectReportService.getDataList(params);
            return ResultMap.ok().put("data", list);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    @ApiOperation(value = "查看详情", notes = "查看详情")
    @GetMapping("/info")
    public ResultMap info(@ApiParam(value = "机构代码", required = true) @RequestParam String logID,
                          @ApiParam(value = "报告编号", required = true) @RequestParam String ReportNO) {
        ExamInspectReport inspectReport = examInspectReportService.getByReportNO(logID, ReportNO);
        return ResultMap.ok().put("data", inspectReport);
    }



    @ApiOperation(value = "获取登录令牌")
    @GetMapping("/Login")
    public ResultMap Login(@ApiParam(value = "登录ID号", defaultValue = "961002") @RequestParam String LogID,
                           @ApiParam(value = "登录密码", defaultValue = "961002") @RequestParam String LogPass) {
        try {
            Map<String, String> reqData = new HashMap<>();
            reqData.put("LogID", LogID);
            reqData.put("LogPass", LogPass);
            Map<String, Object> resData = LisWebServiceSoap12_Client.sendRequest("Login", reqData);

            if ("0".equals(resData.get("RESULTCODE").toString())) {
                return ResultMap.ok().put("data", resData.get("RESULTS"));
            }else{
                return ResultMap.error("用户不存在，或密码错误");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * @Description: 获得报告单列表并下载
     * @param  Token 访问口令
     * @param LogID 机构代码
     * @param AppCode 申请机构代码
     * @param ExeCode 指定执行机构代码
     * @param StartDate 开始申请日期（yyyy-MM-dd）
     * @param EndDate 截止申请日期（yyyy-MM-dd）
     * @param AppBarcode 申请机构条码
     * @param ExeBarcode 执行机构条码
     * @param ReportType 报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）
     * @param DataFlag 是否包含已经下载的数据 （0-不包含；1-包含）
     * @Author: XCK
     * @Date: 2019/5/22
     * @return com.annaru.common.result.ResultMap
     */
    private boolean getResultLists(String Token, String LogID, String AppCode, String ExeCode, String StartDate, String EndDate,
                                   String AppBarcode, String ExeBarcode, String ReportType, String DataFlag) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("Token", Token);
            params.put("LogID", LogID);
            params.put("AppCode", AppCode);
            params.put("ExeCode", ExeCode);
            params.put("AppBarcode", AppBarcode);
            params.put("ExeBarcode", ExeBarcode);
            params.put("StartDate", StartDate);
            params.put("EndDate", EndDate);
            params.put("ReportType", ReportType);
            params.put("DataFlag", DataFlag);

            Map<String, Object> resData = LisWebServiceSoap12_Client.sendRequest("GetResultLists", params);
            if("0".equals(resData.get("RESULTCODE"))){
                List<Map<String, Object>> results = (List) resData.get("RESULTS");
                if(CollectionUtils.isNotEmpty(results)){
                    for (Map<String, Object> result : results) {
                        String reportNO = (String) result.get("REPORTNO");
                        // 下载检查结果
                        List<ExamInspectReport> inspectReportList = this.downLoadResult(Token, LogID, reportNO, AppCode, ExeCode, AppBarcode, ExeBarcode, ReportType);
                        examInspectReportService.saveBatchByDownLoadResult(inspectReportList);
                        // 检查送检条码是否全部检测完成
                        if("1".equals(result.get("APPCOMP"))){
                            // this.updateStatus(Token, LogID, reportNO, AppCode, ExeCode, AppBarcode, ExeBarcode);
                            System.out.println("更新数据状态为已下载：" + reportNO);
                        }
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * @Description:下载检查结果
     * @param Token 访问口令
     * @param LogID 机构代码
     * @param ReportNO 报告编号
     * @param AppCode 申请机构代码(医院代码)
     * @param ExeCode 指定执行机构代码
     * @param AppBarcode 申请机构条码
     * @param ExBarcode 执行机构条码
     * @param ReportType 报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）
     * @Author: XCK
     * @Date: 2019/5/22
     */
    private List<ExamInspectReport> downLoadResult(String Token, String LogID, String ReportNO, String AppCode, String ExeCode, String AppBarcode,
                                  String ExBarcode, String ReportType) {
        try {
            Map<String, String> reqData = new HashMap<>();
            reqData.put("Token", Token);
            reqData.put("LogID", LogID);
            reqData.put("ReportNO", ReportNO);
            reqData.put("AppCode", AppCode);
            reqData.put("ExeCode", ExeCode);
            reqData.put("AppBarcode", AppBarcode);
            reqData.put("ExBarcode", ExBarcode);
            reqData.put("ReportType", ReportType);

            Map<String, Object> resData = LisWebServiceSoap12_Client.sendRequest("DownLoadResult", reqData);

            List<ExamInspectReport> inspectReportList = new ArrayList<>();
            if("0".equals(resData.get("RESULTCODE").toString())){
                List<Map<String, Object>> results = (List) resData.get("RESULTS");
                if(CollectionUtils.isNotEmpty(results)){
                    for (Map<String, Object> result : results) {
                        ExamInspectReport inspectReport = new ExamInspectReport();
                        BeanUtils.populate(inspectReport, result);
                        inspectReport.setLogID(LogID);
                        inspectReportList.add(inspectReport);

                        if(result.get("ITEMRESULTLIST") instanceof List){
                            List<ExamInspectReportResult> inspectReportResultList = new ArrayList<>();
                            List<Map<String, Object>> itemResultList = (List) result.get("ITEMRESULTLIST");
                            for (Map<String, Object> itemResult : itemResultList) {
                                ExamInspectReportResult inspectReportResult = new ExamInspectReportResult();
                                BeanUtils.populate(inspectReportResult, itemResult);
                                inspectReportResultList.add(inspectReportResult);
                            }
                            inspectReport.setInspectReportResultList(inspectReportResultList);
                        }
                    }
                }
            }
            return inspectReportList;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * @Description:更新数据状态
     * @param Token 访问口令
     * @param LogID 机构代码
     * @param ReportNO 报告编号
     * @param AppCode 申请机构代码
     * @param ExeCode 指定执行机构代码
     * @param AppBarcode 实验室条码
     * @param ExBarcode 医院条码
     * @Author: XCK
     * @Date: 2019/5/22
     * @return boolean
     */
    private boolean updateStatus(String Token, String LogID, String ReportNO, String AppCode, String ExeCode, String AppBarcode,
                                String ExBarcode) {
        try {
            Map<String, String> reqData = new HashMap<>();
            reqData.put("Token", Token);
            reqData.put("LogID", LogID);
            reqData.put("ReportNO", ReportNO);
            reqData.put("AppCode", AppCode);
            reqData.put("ExeCode", ExeCode);
            reqData.put("AppBarcode", AppBarcode);
            reqData.put("ExBarcode", ExBarcode);
            Map<String, Object> resData = LisWebServiceSoap12_Client.sendRequest("UpdateStatus", reqData);

            if("1".equals(resData.get("RESULTCODE").toString())){
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

}
