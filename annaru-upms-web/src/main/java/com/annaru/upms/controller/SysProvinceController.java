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

import com.annaru.upms.entity.SysProvince;
import com.annaru.upms.service.ISysProvinceService;
import javax.validation.Valid;



/**
 * 省份信息表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"省份信息表管理"}, description = "省份信息表管理")
@RestController
@RequestMapping("upms/sysProvince")
public class SysProvinceController extends BaseController {
    @Reference
    private ISysProvinceService sysProvinceService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysProvince/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysProvinceService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{id}")
    @RequiresPermissions("upms/sysProvince/info")
    public ResultMap info(@PathVariable("id") Integer id){
        SysProvince sysProvince = sysProvinceService.getById(id);
        return ResultMap.ok().put("sysProvince",sysProvince);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysProvince/save")
    public ResultMap save(@Valid @RequestBody SysProvince sysProvince) {
        try {

//            sysProvince.setCreateUser(ShiroKit.getUser().getId());
//            sysProvince.setCreateTime(new Date());
//            sysProvince.setUpdateTime(new Date());
            sysProvinceService.save(sysProvince);
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
    @RequiresPermissions("upms/sysProvince/update")
    public ResultMap update(@Valid @RequestBody SysProvince sysProvince) {
        try {
//            sysProvince.setUpdateTime(new Date());
            sysProvinceService.updateById(sysProvince);
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
    @RequiresPermissions("upms/sysProvince/delete")
    public ResultMap delete(@RequestBody Integer[]ids) {
        try {
            sysProvinceService.removeByIds(Arrays.asList(ids));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
