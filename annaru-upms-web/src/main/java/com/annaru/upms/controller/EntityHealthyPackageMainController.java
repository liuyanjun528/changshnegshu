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

import com.annaru.upms.entity.EntityHealthyPackageMain;
import com.annaru.upms.service.IEntityHealthyPackageMainService;
import javax.validation.Valid;



/**
 * 企业健康服务主表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
@Api(tags = {"企业健康服务主表管理"}, description = "企业健康服务主表管理")
@RestController
@RequestMapping("upms/entityHealthyPackageMain")
public class EntityHealthyPackageMainController extends BaseController {
    @Reference
    private IEntityHealthyPackageMainService entityHealthyPackageMainService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/entityHealthyPackageMain/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = entityHealthyPackageMainService.getDataPage(params);
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
    @RequiresPermissions("upms/entityHealthyPackageMain/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            EntityHealthyPackageMain entityHealthyPackageMain = entityHealthyPackageMainService.getById(sysId);
            return ResultMap.ok().put("entityHealthyPackageMain",entityHealthyPackageMain);
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
    @RequiresPermissions("upms/entityHealthyPackageMain/save")
    public ResultMap save(@Valid @RequestBody EntityHealthyPackageMain entityHealthyPackageMain) {
        try {
            entityHealthyPackageMainService.save(entityHealthyPackageMain);
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
    @RequiresPermissions("upms/entityHealthyPackageMain/update")
    public ResultMap update(@Valid @RequestBody EntityHealthyPackageMain entityHealthyPackageMain) {
        try {
            entityHealthyPackageMainService.updateById(entityHealthyPackageMain);
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
    @RequiresPermissions("upms/entityHealthyPackageMain/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            entityHealthyPackageMainService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
