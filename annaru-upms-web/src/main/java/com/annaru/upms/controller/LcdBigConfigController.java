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

import com.annaru.upms.entity.LcdBigConfig;
import com.annaru.upms.service.ILcdBigConfigService;
import javax.validation.Valid;



/**
 * 叫号大屏ip配置
 *
 * @author xck
 * @date 2019-04-02 17:31:23
 */
@Api(tags = {"叫号大屏ip配置管理"}, description = "叫号大屏ip配置管理")
@RestController
@RequestMapping("/lcdBigConfig")
public class LcdBigConfigController extends BaseController {
    @Reference
    private ILcdBigConfigService lcdBigConfigService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("lcdBigConfig/list")
    public ResultMap list(@ApiParam(value = "当前页", defaultValue="1")@RequestParam(required = false) long page,
                       @ApiParam(value = "每页数量", defaultValue = "10")@RequestParam(required = false) long limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = lcdBigConfigService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{id}")
    @RequiresPermissions("lcdBigConfig/info")
    public ResultMap info(@PathVariable("id") String id){
        LcdBigConfig lcdBigConfig = lcdBigConfigService.getById(id);
        return ResultMap.ok().put("lcdBigConfig",lcdBigConfig);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("lcdBigConfig/save")
    public ResultMap save(@Valid @RequestBody LcdBigConfig lcdBigConfig) {
        try {

            lcdBigConfig.setCreateTime(new Date());
            lcdBigConfig.setUpdateTime(new Date());
            lcdBigConfigService.save(lcdBigConfig);
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
    @RequiresPermissions("lcdBigConfig/update")
    public ResultMap update(@Valid @RequestBody LcdBigConfig lcdBigConfig) {
        try {
            lcdBigConfig.setUpdateTime(new Date());
            lcdBigConfigService.updateById(lcdBigConfig);
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
    @RequiresPermissions("lcdBigConfig/delete")
    public ResultMap delete(@RequestBody String[]ids) {
        try {
            lcdBigConfigService.removeByIds(Arrays.asList(ids));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
