package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamInspectReportUploadApp;
import com.annaru.upms.entity.vo.ExamInspectReportVo;
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
    private IExamInspectReportService examInspectReportService;
    @Reference
    private IExamInspectReportUploadAppService examInspectReportUploadAppService;


    @ApiOperation(value = "获取用户所有检测报告列表")
    @GetMapping("/listAll")
    public ResultMap listAll(@ApiParam(value = "用户编号") @RequestParam String userId) {
        try {
            List<ExamInspectReportVo> list = examInspectReportService.getAllByBYH(userId, null);
            return ResultMap.ok().put("reportList", list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    @ApiOperation(value = "查看详情", notes = "查看详情")
    @GetMapping("/info")
    public ResultMap info(@ApiParam(value = "报告编号") @RequestParam String reportNO) {
        try {
            ExamInspectReportVo inspectReport = examInspectReportService.getByReportNO(reportNO);
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
