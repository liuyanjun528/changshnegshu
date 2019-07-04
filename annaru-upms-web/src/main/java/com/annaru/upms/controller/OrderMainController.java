package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.exception.GlobalException;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.entity.vo.*;
import com.annaru.upms.im.rong.models.Result;
import com.annaru.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


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
    private IOrderMainService orderMainService;//订单主表

    @Reference
    private IOrderDetailService orderDetailService;//订单详情表

    @Reference
    private IOrderCustomerService orderCustomerService;//订单客户表

    @Reference
    private ISysConfigService iSysConfigService; //系统配置表

    @Reference
    private IExamPackageAppendService examPackageAppendService;

    @Reference
    private IUserFamilyDoctorService userFamilyDoctorService;//家庭医生

    @Reference
    private IUserRelativesService userRelativesService;//亲属表


    /**
     * 保存家庭医生订单
     */

    @ApiOperation(value = "家庭医生下订单")
    @PostMapping("/saveFamilyDoctor")
    @RequiresPermissions("upms/orderMain/saveFamilyDoctor")
    public ResultMap saveFamilyDoctor(@RequestBody OrderMain orderMain) {
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService , SysConfigUtil.ORDERNO);
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
            boolean save = orderMainService.save(orderMain);
            if(save=true){
                orderMain.getUserFamilyDoctor().setOrderNo(SysConfigUtil.getNoBySysConfig());
                orderMain.getUserFamilyDoctor().setEffectFrom(new Date());
                orderMain.getUserFamilyDoctor().setCreationTime(new Date());
                orderMain.getUserFamilyDoctor().setUserId(orderMain.getUserId());
                userFamilyDoctorService.save(orderMain.getUserFamilyDoctor());
            }
            if(save=true){
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
            }
            return ResultMap.ok("家庭医生订单成功").put("data",orderMain.getOrderNo());
        }catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    /**
     * 保存Toc下订单
     */
    @ApiOperation(value = "Toc套餐下订单")
    @PostMapping("/saveOrderMain")
    @RequiresPermissions("upms/orderMain/saveOrderMain")
    public ResultMap saveOrderMain(@RequestBody OrderMain orderMain,String []RelativeId) {
        int i=0;
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.ORDERNO);
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
            i = orderMainService.insertOrderMain(orderMain,RelativeId);

            if (i > 0) {
                    SysConfigUtil.saveRefNo(sysConfig.getRefNo());
                }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        if (i>0) {
            return ResultMap.ok("添加成功").put("data", orderMain.getOrderNo());
        } else {
            return ResultMap.error("没有相关亲属，请先添加亲属");
        }
    }


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
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/orderMain/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderMain orderMain = orderMainService.getById(sysId);
        return ResultMap.ok().put("data",orderMain);
    }


    /**
     * 查询我的的名单里面的订单
     * @author zk
     * @date 2019-05-16 10:58
     */
    @ApiOperation(value = "查询我的订单列表", notes = "查询我的订单列表")
    @GetMapping("/selectOrderPage")
    @RequiresPermissions("upms/orderMain/selectOrderPage")
    public ResultMap selectOrderPage(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                                     @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                                     Integer status, String userId){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("status", status);
        params.put("userId", userId);
        PageUtils<Map<String, Object>> pageList = orderMainService.selectOrderPage(params);
        return ResultMap.ok().put("data",pageList);
    }

    /**
     * 订单各状态的总数
     * @author zk
     * @date 2019-07-01
     */
    @ApiOperation(value = "订单各状态的总数", notes = "订单各状态的总数")
    @GetMapping("/selectSumByStatus")
    @RequiresPermissions("upms/orderMain/selectSumByStatus")
    public ResultMap selectSumByStatus(String userId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        OrderMainVoSumByStatusZ orderMainVoSumByStatusZ = orderMainService.selectSumByStatus(params);
        return ResultMap.ok().put("data",orderMainVoSumByStatusZ);
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
        OrderMainVoZTC orderMainList = orderMainService.selectPackageOrder(params);
        return ResultMap.ok().put("data",orderMainList);
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
        OrderMainVoZZF orderMainList = orderMainService.selectPackageAdvance(params);
        return ResultMap.ok().put("data",orderMainList);
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
        OrderMainVoZMzlt orderMainList = orderMainService.selectPackageGreen(params);
        return ResultMap.ok().put("data",orderMainList);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/orderMain/save")
    public ResultMap save(@Valid @RequestBody OrderMain orderMain) {
        try {
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
