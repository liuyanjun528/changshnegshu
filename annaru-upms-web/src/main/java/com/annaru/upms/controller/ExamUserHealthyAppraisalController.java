package com.annaru.upms.controller;

import java.util.*;

import jodd.util.StringUtil;
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

import com.annaru.upms.entity.ExamUserHealthyAppraisal;
import com.annaru.upms.service.IExamUserHealthyAppraisalService;
import javax.validation.Valid;



/**
 * 个人健康评估
 *
 * @author zk
 * @date 2019-06-17 13:19:24
 */
@Api(tags = {"个人健康评估管理"}, description = "个人健康评估管理")
@RestController
@RequestMapping("upms/examUserHealthyAppraisal")
public class ExamUserHealthyAppraisalController extends BaseController {
    @Reference
    private IExamUserHealthyAppraisalService examUserHealthyAppraisalService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examUserHealthyAppraisal/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = examUserHealthyAppraisalService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * @description 健康评估
     * @author zk
     * @date 2019-6-17 13:39
     */
    @ApiOperation(value = "健康评估", notes = "健康评估")
    @GetMapping("/healthyAppraisal")
    @RequiresPermissions("upms/examUserHealthyAppraisal/healthyAppraisal")
    public ResultMap healthyAppraisal(@PathVariable("userCate") Integer userCate,
                                      @PathVariable("orderNo") String orderNo,
                                      @PathVariable("userId") String userId){
        try {
//            ExamUserHealthyAppraisal examUserHealthyAppraisal = examUserHealthyAppraisalService.getById(sysId);
//            return ResultMap.ok().put("examUserHealthyAppraisal",examUserHealthyAppraisal);

            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    /**
     * @description 健康评估保存
     * @author zk
     * @date 2019-6-18
     */
    @ApiOperation(value = "健康评估保存", notes = "健康评估保存")
    @GetMapping("/info/saveExamUserHealthyAppraisal")
    @RequiresPermissions("upms/examUserHealthyAppraisal/saveExamUserHealthyAppraisal")
    public ResultMap saveExamUserHealthyAppraisal(ExamUserHealthyAppraisal examUserHealthyAppraisal){
        try {

            if (examUserHealthyAppraisal == null && StringUtil.isBlank(examUserHealthyAppraisal.getOrderNo()) ){

            }
            return ResultMap.ok().put("examUserHealthyAppraisal",examUserHealthyAppraisal);
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
    @RequiresPermissions("upms/examUserHealthyAppraisal/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            ExamUserHealthyAppraisal examUserHealthyAppraisal = examUserHealthyAppraisalService.getById(sysId);
            return ResultMap.ok().put("examUserHealthyAppraisal",examUserHealthyAppraisal);
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
    @RequiresPermissions("upms/examUserHealthyAppraisal/save")
    public ResultMap save(@Valid @RequestBody ExamUserHealthyAppraisal examUserHealthyAppraisal) {
        try {

            examUserHealthyAppraisalService.save(examUserHealthyAppraisal);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("upms/examUserHealthyAppraisal/update")
    public ResultMap update(@Valid @RequestBody ExamUserHealthyAppraisal examUserHealthyAppraisal) {
        try {
            examUserHealthyAppraisalService.updateById(examUserHealthyAppraisal);
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
    @RequiresPermissions("upms/examUserHealthyAppraisal/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examUserHealthyAppraisalService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
