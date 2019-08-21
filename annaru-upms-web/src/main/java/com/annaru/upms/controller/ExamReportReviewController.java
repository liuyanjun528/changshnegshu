package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.vo.ReportInfoVo;
import com.annaru.upms.service.IExamReportReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



/**
 * 体检报告解读
 *
 * @author wh
 * @date 2019-06-26 08:56:44
 */
@Api(tags = {"体检报告解读管理"}, description = "体检报告解读管理")
@RestController
@RequestMapping("upms/examReportReview")
public class ExamReportReviewController extends BaseController {
    @Reference
    private IExamReportReviewService examReportReviewService;


    /**
     * 待解读报告列表-->wh
     */
    @ApiOperation(value = "待解读报告列表", notes = "待解读报告列表")
    @GetMapping("/info")
    //@RequiresPermissions("upms/examReportReview/info")
    public ResultMap reportReviewInfo(
            @ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
            @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
            @ApiParam(value = "医生编号")@RequestParam(required = false)String reviewNo,
            @ApiParam(value = "解读状态")@RequestParam(required = false)Integer status){
        try {
            if(status==null){
                status=100;
            }

            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("reviewNo", reviewNo);
            params.put("status", status);
            PageUtils<Map<String, Object>> pageList = examReportReviewService.selectReport(params);
            return ResultMap.ok().put("data",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 解读报告详情
     */
    @ApiOperation(value = "解读报告详情", notes = "解读报告详情")
    @GetMapping("/reportInfo")
    //@RequiresPermissions("upms/examReportReview/reportInfo")
    public ResultMap reportInfo(
            @ApiParam(value = "用户编号")@RequestParam(required = false)String userId,
            @ApiParam(value = "报告编号")@RequestParam(required = false)String reportNo){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("userId",userId);
            params.put("reportNo", reportNo);
            ReportInfoVo reportInfoVo = examReportReviewService.selectReportInfo(params);
            return ResultMap.ok().put("examReportReview",reportInfoVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 添加报告建议 实际为修改操作
     */
    @ApiOperation(value = "添加报告建议")
    @PostMapping("/saveSuggestions")
    //@RequiresPermissions("upms/examReportReview/saveSuggestions")
    public ResultMap save(String reportNo, String reviewNo, String suggestions) {
        try {
            examReportReviewService.insertReportSuggest(reportNo, reviewNo, suggestions);
            return ResultMap.ok("报告建议添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 确认解读接口
     */
    @ApiOperation(value = "确认解读接口")
    @PostMapping("/update")
    //@RequiresPermissions("upms/examReportReview/update")
    public ResultMap update(String reportNo) {
        try {
            examReportReviewService.updateReportStatus(reportNo);
            return ResultMap.ok("解读成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
