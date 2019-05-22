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

import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.service.IOrderMainService;
import javax.validation.Valid;



/**
 * 定单主表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"定单主表管理"}, description = "定单主表管理")
@RestController
@RequestMapping("upms/orderMain")
public class OrderMainController extends BaseController {
    @Reference
    private IOrderMainService orderMainService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderMain/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderMainService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/orderMain/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderMain orderMain = orderMainService.getById(sysId);
        return ResultMap.ok().put("orderMain",orderMain);
    }

    /**
     * 查询我的的名单里面的订单
     * @author zk
     * @date 2019-05-16 10:58
     */
    @ApiOperation(value = "查询我的的名单里面的订单", notes = "查询我的的名单里面的订单")
    @GetMapping("/selectOrderPage")
    @RequiresPermissions("upms/orderMain/selectOrderPage")
    public ResultMap selectOrderPage(){
//        OrderMain orderMain = orderMainService.getById();
//        return ResultMap.ok().put("orderMain",orderMain);
        /*
        如果 appointmentCates 等于 1 ，则为套餐订单
        如果 appointmentCates 等于 3 ，并且 option_1 不等于 1 ，则为套餐订单
        如果 appointmentCates 等于 3 ，并且 option_1 等于 1 ，则为护士上门
        如果 appointmentCates 等于 2 或者 等于 4 ，并且 parentNo 不等于空 ，则为进阶体检
        如果 appointmentCates 等于 6 ，则为门诊绿通陪诊服务
        如果 status 等于 0 ，则为未支付 ，
        若status 等于 1 ，并且 opOderNo 不等于空 ，则为已支付
        若status 等于 2 ，并且 opOderNo 不等于空 ，则为完成
        */
        Map<String, Object> params = new HashMap<>();
        PageUtils<Map<String, Object>> pageList = orderMainService.selectOrderPage(params);
        return ResultMap.ok().put("page",pageList);
    }

    /**
     * 查询套餐订单详情
     * @author zk
     * @date 2019-05-16 17:59
     */
    @ApiOperation(value = "查询套餐订单详情", notes = "查询套餐订单详情")
    @GetMapping("/selectPackageOrder/{sysId}")
    @RequiresPermissions("upms/orderMain/selectPackageOrder")
    public ResultMap selectPackageOrder(@PathVariable("sysId") Integer sysId){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        List<OrderMain> orderMainList = orderMainService.selectPackageOrder(params);
        return ResultMap.ok().put("orderMainList",orderMainList);
    }

    /**
     * 查询自费(进阶)订单详情
     * @author zk
     * @date 2019-05-16 17:59
     */
    @ApiOperation(value = "查询自费(进阶)订单详情", notes = "查询自费(进阶)订单详情")
    @GetMapping("/selectPackageAdvance/{sysId}")
    @RequiresPermissions("upms/orderMain/selectPackageAdvance")
    public ResultMap selectPackageAdvance(@PathVariable("sysId") Integer sysId){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        List<OrderMain> orderMainList = orderMainService.selectPackageAdvance(params);
        return ResultMap.ok().put("orderMainList",orderMainList);
    }

    /**
     * 查询门诊绿通订单详情
     * @author zk
     * @date 2019-05-16 17:59
     */
    @ApiOperation(value = "查询门诊绿通订单详情", notes = "查询门诊绿通订单详情")
    @GetMapping("/selectPackageGreen/{sysId}")
    @RequiresPermissions("upms/orderMain/selectPackageGreen")
    public ResultMap selectPackageGreen(@PathVariable("sysId") Integer sysId){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        List<OrderMain> orderMainList = orderMainService.selectPackageGreen(params);
        return ResultMap.ok().put("orderMainList",orderMainList);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/orderMain/save")
    public ResultMap save(@Valid @RequestBody OrderMain orderMain) {
        try {

//            orderMain.setCreateUser(ShiroKit.getUser().getId());
//            orderMain.setCreateTime(new Date());
//            orderMain.setUpdateTime(new Date());
            orderMainService.save(orderMain);
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
    @RequiresPermissions("upms/orderMain/update")
    public ResultMap update(@Valid @RequestBody OrderMain orderMain) {
        try {
//            orderMain.setUpdateTime(new Date());
            orderMainService.updateById(orderMain);
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
    @RequiresPermissions("upms/orderMain/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderMainService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
