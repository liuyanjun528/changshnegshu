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

import com.annaru.upms.entity.OrderReceiptOrderMapping;
import com.annaru.upms.service.IOrderReceiptOrderMappingService;
import javax.validation.Valid;



/**
 * 发票订单关联
 *
 * @author zk
 * @date 2019-10-11 13:42:07
 */
@Api(tags = {"发票订单关联管理"}, description = "发票订单关联管理")
@RestController
@RequestMapping("upms/orderReceiptOrderMapping")
public class OrderReceiptOrderMappingController extends BaseController {
    @Reference
    private IOrderReceiptOrderMappingService orderReceiptOrderMappingService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderReceiptOrderMapping/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = orderReceiptOrderMappingService.getDataPage(params);
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
    @RequiresPermissions("upms/orderReceiptOrderMapping/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            OrderReceiptOrderMapping orderReceiptOrderMapping = orderReceiptOrderMappingService.getById(sysId);
            return ResultMap.ok().put("orderReceiptOrderMapping",orderReceiptOrderMapping);
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
    @RequiresPermissions("upms/orderReceiptOrderMapping/save")
    public ResultMap save(@Valid @RequestBody OrderReceiptOrderMapping orderReceiptOrderMapping) {
        try {

//            orderReceiptOrderMapping.setCreateUser(ShiroKit.getUser().getId());
//            orderReceiptOrderMapping.setCreateTime(new Date());
//            orderReceiptOrderMapping.setUpdateTime(new Date());
            orderReceiptOrderMappingService.save(orderReceiptOrderMapping);
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
    @RequiresPermissions("upms/orderReceiptOrderMapping/update")
    public ResultMap update(@Valid @RequestBody OrderReceiptOrderMapping orderReceiptOrderMapping) {
        try {
//            orderReceiptOrderMapping.setUpdateTime(new Date());
            orderReceiptOrderMappingService.updateById(orderReceiptOrderMapping);
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
    @RequiresPermissions("upms/orderReceiptOrderMapping/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderReceiptOrderMappingService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
