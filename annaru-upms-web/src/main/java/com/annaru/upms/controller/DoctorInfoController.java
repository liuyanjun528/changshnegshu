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

import com.annaru.upms.entity.DoctorInfo;
import com.annaru.upms.service.IDoctorInfoService;
import javax.validation.Valid;



/**
 * 医生信息
 *
 * @author xck
 * @date 2019-04-08 18:34:08
 */
@Api(tags = {"医生信息管理"}, description = "医生信息管理")
@RestController
@RequestMapping("doctorInfo")
public class DoctorInfoController extends BaseController {
    @Reference
    private IDoctorInfoService doctorInfoService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("doctorInfo/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(required = false, defaultValue="1") Integer page,
                       @ApiParam(value = "每页数量")@RequestParam(required = false, defaultValue = "10") Integer limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String name){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("name", name);
        PageUtils<Map<String, Object>> pageList = doctorInfoService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{id}")
    @RequiresPermissions("doctorInfo/info")
    public ResultMap info(@PathVariable("id") String id){
        DoctorInfo doctorInfo = doctorInfoService.getById(id);
        return ResultMap.ok().put("doctorInfo",doctorInfo);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("doctorInfo/save")
    public ResultMap save(@Valid @RequestBody DoctorInfo doctorInfo) {
        try {

            doctorInfo.setCreateUser(ShiroKit.getUser().getId());
            doctorInfo.setCreateTime(new Date());
            doctorInfo.setUpdateTime(new Date());
            doctorInfoService.save(doctorInfo);
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
    @RequiresPermissions("doctorInfo/update")
    public ResultMap update(@Valid @RequestBody DoctorInfo doctorInfo) {
        try {
            doctorInfo.setUpdateTime(new Date());
            doctorInfoService.updateById(doctorInfo);
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
    @RequiresPermissions("doctorInfo/delete")
    public ResultMap delete(@RequestBody String[] ids) {
        try {
            doctorInfoService.removeByIds(Arrays.asList(ids));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
