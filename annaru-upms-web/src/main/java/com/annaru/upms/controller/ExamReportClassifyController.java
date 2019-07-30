package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.vo.ExamReportClassifyInfoVo;
import com.annaru.upms.entity.vo.ExamReportClassifyListVo;
import com.annaru.upms.service.IExamReportClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
@Api(tags = "体检报告分类管理", description = "体检报告分类管理")
@RestController
@RequestMapping("upms/examReportClassify")
public class ExamReportClassifyController extends BaseController {
    @Reference
    private IExamReportClassifyService examReportClassifyService;

    @ApiOperation(value = "用户所有检测报告列表")
    @GetMapping("/list")
    public ResultMap list(@ApiParam(value = "用户编号") @RequestParam String userId) {
        try {
            List<ExamReportClassifyListVo> list = examReportClassifyService.getDataListByUserId(userId);
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
            ExamReportClassifyInfoVo classifyInfoVo = examReportClassifyService.getByReportNo(reportNO);
            return ResultMap.ok().put("reportInfo", classifyInfoVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

}
