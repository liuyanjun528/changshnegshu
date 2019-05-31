package com.annaru.upms.controller;

import java.util.*;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.vo.SysLinkageTypeVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


import com.annaru.upms.entity.SysLinkageType;
import com.annaru.upms.service.ISysLinkageTypeService;
import javax.validation.Valid;



/**
 *
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
@Api(tags = {"sysLinkageType管理"}, description = "sysLinkageType管理")
@RestController
@RequestMapping("/sysLinkageType")
public class SysLinkageTypeController extends BaseController {
    @Reference
    private ISysLinkageTypeService sysLinkageTypeService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("/sysLinkageType/list")
    public ResultMap list(@ApiParam(value = "当前页", defaultValue="1")@RequestParam(required = false) long page,
                          @ApiParam(value = "每页数量", defaultValue = "10")@RequestParam(required = false) long limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysLinkageTypeService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看详情")
    @GetMapping("/info/{id}")
    @RequiresPermissions("/sysLinkageType/info")
    public ResultMap info(@PathVariable("id") Integer id){
        SysLinkageType sysLinkageType = sysLinkageTypeService.getById(id);
        return ResultMap.ok().put("data",sysLinkageType);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("/sysLinkageType/save")
    public ResultMap save(@Valid @RequestBody SysLinkageType sysLinkageType) {
        try {

            //sysLinkageType.setCreateUser(ShiroKit.getUser().getId());
            sysLinkageTypeService.save(sysLinkageType);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    @ApiOperation(value = "问卷问题列表")
    @GetMapping("/answerlist")
    @RequiresPermissions("/sysLinkageType/answerlist")
    public ResultMap answerlist(@ApiParam(value = "问题类型")@RequestParam String type){
        Map<String,Object> params = new HashMap<>();
        params.put("type",type);
        List<SysLinkageTypeVo> list = sysLinkageTypeService.getList(params);
        return ResultMap.ok().put("data",list);
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("/sysLinkageType/update")
    public ResultMap update(@Valid @RequestBody SysLinkageType sysLinkageType) {
        try {
            sysLinkageTypeService.updateById(sysLinkageType);
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
    @RequiresPermissions("/sysLinkageType/delete")
    public ResultMap delete(@RequestBody Integer[]ids) {
        try {
            sysLinkageTypeService.removeByIds(Arrays.asList(ids));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
