package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.OrderDetail;
import com.annaru.upms.service.IOrderDetailService;
import com.annaru.upms.service.IOrderMainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 定单详细表
 *
 * @author xck
 * @date 2019-05-20 16:18:34
 */
@Api(tags = {"定单详细表管理"}, description = "定单详细表管理")
@RestController
@RequestMapping("upms/orderDetail")
public class OrderDetailController extends BaseController {
    @Reference
    private IOrderDetailService orderDetailService;
    @Reference
    private IOrderMainService orderMainService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderDetail/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderDetailService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看lcd详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/orderDetail/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderDetail orderDetail = orderDetailService.getById(sysId);
        return ResultMap.ok().put("data",orderDetail);
    }


    @ApiOperation(value = "查询绿通剩余次数", notes = "查询绿通剩余次数")
    @GetMapping("/rest")
    @RequiresPermissions("upms/orderDetail/rest")
    public ResultMap rest(@RequestParam String userId){
        int restTimes = 0;
        Map<String, Object> params = new HashMap<>();
        params.put("userId",userId);
        List<Integer> times = orderMainService.getTimes(params);
        for (int i = 0;i<times.size();i++){
            restTimes += times.get(i);
        }
        params.clear();
        params.put("data",restTimes);
        return ResultMap.ok(params);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/orderDetail/save")
    public ResultMap save(@Valid @RequestBody OrderDetail orderDetail) {
        try {
            orderDetailService.save(orderDetail);
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
    @RequiresPermissions("upms/orderDetail/update")
    public ResultMap update(@Valid @RequestBody OrderDetail orderDetail) {
        try {
            orderDetailService.updateById(orderDetail);
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
    @RequiresPermissions("upms/orderDetail/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderDetailService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
