package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamInspectReportMicroorganismDetail;
import com.annaru.upms.service.IExamInspectReportMicroorganismDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



/**
 * 检查报告结果4_微生物药敏结果
 *
 * @author xck
 * @date 2019-06-12 14:43:09
 */
@Api(tags = {"检查报告结果4_微生物药敏结果管理"}, description = "检查报告结果4_微生物药敏结果管理")
@RestController
@RequestMapping("upms/examInspectReportMicroorganismDetail")
public class ExamInspectReportMicroorganismDetailController extends BaseController {
    @Reference
    private IExamInspectReportMicroorganismDetailService examInspectReportMicroorganismDetailService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examInspectReportMicroorganismDetail/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "微生物报告ID")@RequestParam(required = false)String microorganismId){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("microorganismId", microorganismId);
            PageUtils<ExamInspectReportMicroorganismDetail> pageList = examInspectReportMicroorganismDetailService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{id}")
    @RequiresPermissions("upms/examInspectReportMicroorganismDetail/info")
    public ResultMap info(@PathVariable("id") String id){
        try {
            ExamInspectReportMicroorganismDetail examInspectReportMicroorganismDetail = examInspectReportMicroorganismDetailService.getById(id);
            return ResultMap.ok().put("examInspectReportMicroorganismDetail",examInspectReportMicroorganismDetail);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

}
