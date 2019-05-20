package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysCity;
import com.annaru.upms.service.ISysCityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 行政区域地州市信息表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"行政区域地州市信息表管理"}, description = "行政区域地州市信息表管理")
@RestController
@RequestMapping("upms/sysCity")
public class SysCityController extends BaseController {
    @Reference
    private ISysCityService sysCityService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysCity/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysCityService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{id}")
    @RequiresPermissions("upms/sysCity/info")
    public ResultMap info(@PathVariable("id") Integer id){
        SysCity sysCity = sysCityService.getById(id);
        return ResultMap.ok().put("sysCity",sysCity);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysCity/save")
    public ResultMap save(@Valid @RequestBody SysCity sysCity) {
        try {

//            sysCity.setCreateUser(ShiroKit.getUser().getId());
//            sysCity.setCreateTime(new Date());
//            sysCity.setUpdateTime(new Date());
            sysCityService.save(sysCity);
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
    @RequiresPermissions("upms/sysCity/update")
    public ResultMap update(@Valid @RequestBody SysCity sysCity) {
        try {
//            sysCity.setUpdateTime(new Date());
            sysCityService.updateById(sysCity);
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
    @RequiresPermissions("upms/sysCity/delete")
    public ResultMap delete(@RequestBody Integer[]ids) {
        try {
            sysCityService.removeByIds(Arrays.asList(ids));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
