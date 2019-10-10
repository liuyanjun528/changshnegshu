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

import com.annaru.upms.entity.SysBannerShop;
import com.annaru.upms.service.ISysBannerShopService;
import javax.validation.Valid;



/**
 * 商城banner
 *
 * @author zk
 * @date 2019-10-10 13:11:54
 */
@Api(tags = {"商城banner管理"}, description = "商城banner管理")
@RestController
@RequestMapping("upms/sysBannerShop")
public class SysBannerShopController extends BaseController {
    @Reference
    private ISysBannerShopService sysBannerShopService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysBannerShop/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = sysBannerShopService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /*** 查询所有商城Banner
     * @Author: zxk
     * @Date: 2019/10/10
     */
    @ApiOperation(value = "查询所有商城Banner")
    @GetMapping("/listAll")
    public ResultMap listAll(){
        List<SysBannerShop> sysBannersShop = sysBannerShopService.selectAll();
        return ResultMap.ok().put("data",sysBannersShop);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/sysBannerShop/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            SysBannerShop sysBannerShop = sysBannerShopService.getById(sysId);
            return ResultMap.ok().put("sysBannerShop",sysBannerShop);
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
    @RequiresPermissions("upms/sysBannerShop/save")
    public ResultMap save(@Valid @RequestBody SysBannerShop sysBannerShop) {
        try {

//            sysBannerShop.setCreateUser(ShiroKit.getUser().getId());
//            sysBannerShop.setCreateTime(new Date());
//            sysBannerShop.setUpdateTime(new Date());
            sysBannerShopService.save(sysBannerShop);
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
    @RequiresPermissions("upms/sysBannerShop/update")
    public ResultMap update(@Valid @RequestBody SysBannerShop sysBannerShop) {
        try {
//            sysBannerShop.setUpdateTime(new Date());
            sysBannerShopService.updateById(sysBannerShop);
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
    @RequiresPermissions("upms/sysBannerShop/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysBannerShopService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
