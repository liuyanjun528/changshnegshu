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

import com.annaru.upms.entity.SysNurse;
import com.annaru.upms.service.ISysNurseService;
import javax.validation.Valid;



/**
 * 护士
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"护士管理"}, description = "护士管理")
@RestController
@RequestMapping("upms/sysNurse")
public class SysNurseController extends BaseController {
    @Reference
    private ISysNurseService sysNurseService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysNurse/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysNurseService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/sysNurse/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        SysNurse sysNurse = sysNurseService.getById(sysId);
        return ResultMap.ok().put("sysNurse",sysNurse);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysNurse/save")
    public ResultMap save(@Valid @RequestBody SysNurse sysNurse) {
        try {

//            sysNurse.setCreateUser(ShiroKit.getUser().getId());
//            sysNurse.setCreateTime(new Date());
//            sysNurse.setUpdateTime(new Date());
            sysNurseService.save(sysNurse);
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
    @RequiresPermissions("upms/sysNurse/update")
    public ResultMap update(@Valid @RequestBody SysNurse sysNurse) {
        try {
//            sysNurse.setUpdateTime(new Date());
            sysNurseService.updateById(sysNurse);
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
    @RequiresPermissions("upms/sysNurse/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysNurseService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}