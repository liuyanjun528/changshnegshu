package com.annaru.upms.controller;


import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.webservice.LisWebServiceSoap12_Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 检查报告
 *
 * @author xck
 * @date 2019-05-16 15:44:28
 */
@Api(tags = "检查报告管理（直接调用第三方接口）", description = "第三方服务提供商千麦检查报告数据传输接口")
@RestController
@RequestMapping("/upms/inspectionReport")
public class ExamInspectionReportTestController extends BaseController {


    @ApiOperation(value = "获取登录令牌")
    @GetMapping("/Login")
    public ResultMap Login(@ApiParam(value = "登录ID号", defaultValue = "961002") @RequestParam String LogID,
                           @ApiParam(value = "登录密码", defaultValue = "961002") @RequestParam String LogPass) {
        try {
            Map<String, String> reqData = new HashMap<>();
            reqData.put("LogID", LogID);
            reqData.put("LogPass", LogPass);
            Map<String, Object> resData = LisWebServiceSoap12_Client.sendRequest("Login", reqData);

            if("0".equals(resData.get("ResultCode").toString())){
                return ResultMap.ok().put("data", resData.get("Results"));
            }
            return ResultMap.error("用户不存在，或密码错误");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    @ApiOperation(value = "获得报告单列表")
    @GetMapping("/getResultLists")
    public ResultMap getResultLists(@ApiParam(value = "访问口令", required=true) @RequestParam String Token,
                                    @ApiParam(value = "机构代码", required=true) @RequestParam String LogID,
                                    @ApiParam(value = "申请机构代码", required=true) @RequestParam String AppCode,
                                    @ApiParam(value = "指定执行机构代码") @RequestParam(required=false) String ExeCode,
                                    @ApiParam(value = "开始申请日期（yyyy-MM-dd）", required=true) @RequestParam String StartDate,
                                    @ApiParam(value = "截止申请日期（yyyy-MM-dd）", required=true) @RequestParam String EndDate,
                                    @ApiParam(value = "申请机构条码") @RequestParam(required=false) String AppBarcode,
                                    @ApiParam(value = "执行机构条码") @RequestParam(required=false) String ExBarcode,
                                    @ApiParam(value = "报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）") @RequestParam(required=false) String ReportType,
                                    @ApiParam(value = "是否包含已经下载的数据 （0-不包含；1-包含）") @RequestParam(required=false) String DataFlag) {
        try {
            Map<String, String> reqData = new HashMap<>();
            reqData.put("Token", Token);
            reqData.put("LogID", LogID);
            reqData.put("AppCode", AppCode);
            reqData.put("ExeCode", ExeCode);
            reqData.put("AppBarcode", AppBarcode);
            reqData.put("ExBarcode", ExBarcode);
            reqData.put("StartDate", StartDate);
            reqData.put("EndDate", EndDate);
            reqData.put("ReportType", ReportType);
            reqData.put("DataFlag", DataFlag);

            Map<String, Object> resData = LisWebServiceSoap12_Client.sendRequest("GetResultLists", reqData);
            if("0".equals(resData.get("ResultCode").toString())){
                return ResultMap.ok().put("data", resData.get("Results"));
            }
            return ResultMap.error((String) resData.get("ResultContent"));

        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    @ApiOperation(value = "下载检查结果")
    @GetMapping("/downLoadResult")
    public ResultMap downLoadResult(@ApiParam(value = "访问口令", required = true) @RequestParam String Token,
                                    @ApiParam(value = "机构代码", required = true) @RequestParam String LogID,
                                    @ApiParam(value = "报告编号", required = true) @RequestParam String ReportNO,
                                    @ApiParam(value = "申请机构代码(医院代码)") @RequestParam(required=false) String AppCode,
                                    @ApiParam(value = "指定执行机构代码") @RequestParam(required=false) String ExeCode,
                                    @ApiParam(value = "申请机构条码") @RequestParam(required=false) String AppBarcode,
                                    @ApiParam(value = "执行机构条码") @RequestParam(required=false) String ExBarcode,
                                    @ApiParam(value = "报告类型（1-临床检验报告；2-病理组织报告；3-TCT；4-微生物报告；9-其他报告）") @RequestParam(required=false) String ReportType) {
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

            if("0".equals(resData.get("ResultCode").toString())){
                return ResultMap.ok().put("data", resData.get("Results"));
            }
            return ResultMap.error((String) resData.get("ResultContent"));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    @ApiOperation(value = "更新数据状态")
    @GetMapping("/updateStatus")
    public ResultMap updateStatus(@ApiParam(value = "访问口令") @RequestParam String Token,
                                  @ApiParam(value = "机构代码") @RequestParam String LogID,
                                  @ApiParam(value = "报告编号") @RequestParam String ReportNO,
                                  @ApiParam(value = "申请机构代码") @RequestParam String AppCode,
                                  @ApiParam(value = "指定执行机构代码") @RequestParam(required=false) String ExeCode,
                                  @ApiParam(value = "实验室条码") @RequestParam(required=false) String AppBarcode,
                                  @ApiParam(value = "医院条码") @RequestParam(required=false) String ExBarcode) {
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

            if("1".equals(resData.get("ResultCode").toString())){
                return ResultMap.ok().put("data", resData);
            }
            return ResultMap.error((String) resData.get("ResultContent"));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    @ApiOperation(value = "上传一份送检申请")
    @GetMapping("/upLoadApp")
    public ResultMap upLoadApp(@RequestParam Map<String, String> params) {
        try {
            Map<String, Object> resData = LisWebServiceSoap12_Client.sendRequest("UpLoadApp", params);
            return ResultMap.ok();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

}
