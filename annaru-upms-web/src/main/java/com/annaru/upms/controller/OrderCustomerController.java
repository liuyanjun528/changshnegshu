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

import com.annaru.upms.entity.OrderCustomer;
import com.annaru.upms.service.IOrderCustomerService;
import javax.validation.Valid;



/**
 * 定单客户信息
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"定单客户信息管理"}, description = "定单客户信息管理")
@RestController
@RequestMapping("upms/orderCustomer")
public class OrderCustomerController extends BaseController {
    @Reference
    private IOrderCustomerService orderCustomerService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderCustomer/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderCustomerService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/orderCustomer/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderCustomer orderCustomer = orderCustomerService.getById(sysId);
        return ResultMap.ok().put("orderCustomer",orderCustomer);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/orderCustomer/save")
    public ResultMap save(@Valid @RequestBody OrderCustomer orderCustomer) {
        try {

//            orderCustomer.setCreateUser(ShiroKit.getUser().getId());
//            orderCustomer.setCreateTime(new Date());
//            orderCustomer.setUpdateTime(new Date());
            orderCustomerService.save(orderCustomer);
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
    @RequiresPermissions("upms/orderCustomer/update")
    public ResultMap update(@Valid @RequestBody OrderCustomer orderCustomer) {
        try {
//            orderCustomer.setUpdateTime(new Date());
            orderCustomerService.updateById(orderCustomer);
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
    @RequiresPermissions("upms/orderCustomer/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderCustomerService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
