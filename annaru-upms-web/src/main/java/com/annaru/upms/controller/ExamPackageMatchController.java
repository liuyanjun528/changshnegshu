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

import com.annaru.upms.entity.ExamPackageMatch;
import com.annaru.upms.service.IExamPackageMatchService;
import javax.validation.Valid;



/**
 * 适用人群
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"适用人群管理"}, description = "适用人群管理")
@RestController
@RequestMapping("upms/examPackageMatch")
public class ExamPackageMatchController extends BaseController {
    @Reference
    private IExamPackageMatchService examPackageMatchService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examPackageMatch/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = examPackageMatchService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/examPackageMatch/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        ExamPackageMatch examPackageMatch = examPackageMatchService.getById(sysId);
        return ResultMap.ok().put("examPackageMatch",examPackageMatch);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/examPackageMatch/save")
    public ResultMap save(@Valid @RequestBody ExamPackageMatch examPackageMatch) {
        try {

//            examPackageMatch.setCreateUser(ShiroKit.getUser().getId());
//            examPackageMatch.setCreateTime(new Date());
//            examPackageMatch.setUpdateTime(new Date());
            examPackageMatchService.save(examPackageMatch);
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
    @RequiresPermissions("upms/examPackageMatch/update")
    public ResultMap update(@Valid @RequestBody ExamPackageMatch examPackageMatch) {
        try {
//            examPackageMatch.setUpdateTime(new Date());
            examPackageMatchService.updateById(examPackageMatch);
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
    @RequiresPermissions("upms/examPackageMatch/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examPackageMatchService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
