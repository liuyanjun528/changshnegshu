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

import com.annaru.upms.entity.ExamHandoverSheet;
import com.annaru.upms.service.IExamHandoverSheetService;
import javax.validation.Valid;



/**
 * 交接单
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
@Api(tags = {"交接单管理"}, description = "交接单管理")
@RestController
@RequestMapping("upms/examHandoverSheet")
public class ExamHandoverSheetController extends BaseController {
    @Reference
    private IExamHandoverSheetService examHandoverSheetService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examHandoverSheet/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = examHandoverSheetService.getDataPage(params);
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
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/examHandoverSheet/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            ExamHandoverSheet examHandoverSheet = examHandoverSheetService.getById(sysId);
            return ResultMap.ok().put("examHandoverSheet",examHandoverSheet);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/examHandoverSheet/save")
    public ResultMap save(@Valid @RequestBody ExamHandoverSheet examHandoverSheet) {
        try {
            examHandoverSheetService.save(examHandoverSheet);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 通过订单编号修改已有 未完成的预约记录
     */
    @ApiOperation(value = "修改护士端服务订单详情")
    @PostMapping("/update")
    @RequiresPermissions("upms/examHandoverSheet/update")
    public ResultMap update(@Valid @RequestBody ExamHandoverSheet examHandoverSheet) {
        try {
            examHandoverSheet.setDrawCompleteTime(new Date());//抽血完成时间
            examHandoverSheetService.updateExamHandoverSheet(examHandoverSheet);
            return ResultMap.ok("修改成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    @RequiresPermissions("upms/examHandoverSheet/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examHandoverSheetService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
