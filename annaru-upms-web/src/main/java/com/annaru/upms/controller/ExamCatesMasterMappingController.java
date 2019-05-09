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

import com.annaru.upms.entity.ExamCatesMasterMapping;
import com.annaru.upms.service.IExamCatesMasterMappingService;
import javax.validation.Valid;



/**
 * 体检类别与主检项目关联表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@Api(tags = {"体检类别与主检项目关联表管理"}, description = "体检类别与主检项目关联表管理")
@RestController
@RequestMapping("upms/examCatesMasterMapping")
public class ExamCatesMasterMappingController extends BaseController {
    @Reference
    private IExamCatesMasterMappingService examCatesMasterMappingService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examCatesMasterMapping/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = examCatesMasterMappingService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/examCatesMasterMapping/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        ExamCatesMasterMapping examCatesMasterMapping = examCatesMasterMappingService.getById(sysId);
        return ResultMap.ok().put("examCatesMasterMapping",examCatesMasterMapping);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/examCatesMasterMapping/save")
    public ResultMap save(@Valid @RequestBody ExamCatesMasterMapping examCatesMasterMapping) {
        try {

//            examCatesMasterMapping.setCreateUser(ShiroKit.getUser().getId());
//            examCatesMasterMapping.setCreateTime(new Date());
//            examCatesMasterMapping.setUpdateTime(new Date());
            examCatesMasterMappingService.save(examCatesMasterMapping);
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
    @RequiresPermissions("upms/examCatesMasterMapping/update")
    public ResultMap update(@Valid @RequestBody ExamCatesMasterMapping examCatesMasterMapping) {
        try {
//            examCatesMasterMapping.setUpdateTime(new Date());
            examCatesMasterMappingService.updateById(examCatesMasterMapping);
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
    @RequiresPermissions("upms/examCatesMasterMapping/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examCatesMasterMappingService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
