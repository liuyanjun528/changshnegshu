package com.annaru.upms.controller;

import java.util.*;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.shiro.ShiroKit;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.ExamReportReview;
import com.annaru.upms.service.IExamReportReviewService;
import javax.validation.Valid;



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
    @RequiresPermissions("upms/examReportReview/info")
    public ResultMap reportReviewInfo(
            @ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
            @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
            @ApiParam(value = "医生编号")@RequestParam(required = false)String reviewNo,
            @ApiParam(value = "解读状态")@RequestParam(required = false)Integer status,
            @ApiParam(value = "报告状态")@RequestParam(required = false)String JGPD){
        try {
            if(status==null){
                status=100;
            }
            if(JGPD==null){
                JGPD="3";
            }
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("reviewNo", reviewNo);
            params.put("status", status);
            params.put("JGPD", JGPD);
            PageUtils<Map<String, Object>> pageList = examReportReviewService.selectReport(params);
            return ResultMap.ok().put("data",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }







    /**
     * 列表
     */
//    @ApiOperation(value = "列表")
//    @GetMapping("/list")
//    @RequiresPermissions("upms/examReportReview/list")
//    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
//                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
//                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
//        try {
//            Map<String, Object> params = new HashMap<>();
//            params.put("page",page);
//            params.put("limit", limit);
//            params.put("key", key);
//            PageUtils<Map<String, Object>> pageList = examReportReviewService.getDataPage(params);
//            return ResultMap.ok().put("page",pageList);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return ResultMap.error("运行异常，请联系管理员");
//        }
//    }


//    /**
//     * 信息
//     */
//    @ApiOperation(value = "查看详情", notes = "查看upms详情")
//    @GetMapping("/info/{sysId}")
//    @RequiresPermissions("upms/examReportReview/info")
//    public ResultMap info(@PathVariable("sysId") Integer sysId){
//        try {
//            ExamReportReview examReportReview = examReportReviewService.getById(sysId);
//            return ResultMap.ok().put("examReportReview",examReportReview);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return ResultMap.error("运行异常，请联系管理员");
//        }
//    }
//
//    /**
//     * 保存
//     */
//    @ApiOperation(value = "保存")
//    @PostMapping("/save")
//    @RequiresPermissions("upms/examReportReview/save")
//    public ResultMap save(@Valid @RequestBody ExamReportReview examReportReview) {
//        try {
//            examReportReviewService.save(examReportReview);
//            return ResultMap.ok("添加成功");
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return ResultMap.error("运行异常，请联系管理员");
//        }
//    }
//
//    /**
//     * 修改
//     */
//    @ApiOperation(value = "修改")
//    @PostMapping("/update")
//    @RequiresPermissions("upms/examReportReview/update")
//    public ResultMap update(@Valid @RequestBody ExamReportReview examReportReview) {
//        try {
//            examReportReviewService.updateById(examReportReview);
//            return ResultMap.ok("修改成功");
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return ResultMap.error("运行异常，请联系管理员");
//        }
//
//    }
//
//    /**
//     * 删除
//     */
//    @ApiOperation(value = "删除")
//    @PostMapping("/delete")
//    @RequiresPermissions("upms/examReportReview/delete")
//    public ResultMap delete(@RequestBody Integer[]sysIds) {
//        try {
//            examReportReviewService.removeByIds(Arrays.asList(sysIds));
//            return ResultMap.ok("删除成功！");
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return ResultMap.error("运行异常，请联系管理员");
//        }
//
//    }

}
