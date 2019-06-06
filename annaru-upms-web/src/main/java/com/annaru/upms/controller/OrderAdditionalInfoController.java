package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.OrderAdditionalInfo;
import com.annaru.upms.entity.OrderAppointment;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.SysConfig;
import com.annaru.upms.service.*;
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
 * 企业绿通行
 *
 * @author xck
 * @date 2019-05-20 16:18:39
 */
@Api(tags = {"企业绿通行"}, description = "企业绿通行")
@RestController
@RequestMapping("lcd/orderAdditionalInfo")
public class OrderAdditionalInfoController extends BaseController {
    @Reference
    private IOrderAdditionalInfoService orderAdditionalInfoService;

    @Reference
    private IEntityHealthyAppointmentService entityHealthyAppointmentService;

    @Reference
    private ISysConfigService iSysConfigService; //系统配置表

    @Reference
    private IOrderMainService orderMainService;

    /**
     * 添加企业绿通行
     */
    @ApiOperation(value = "添加企业绿通行")
    @PostMapping("/saveGreenPassage")
    public ResultMap saveGreenPassage(@RequestBody OrderAdditionalInfo orderAdditionalInfo) {
        OrderMain orderMain = new OrderMain();
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService , SysConfigUtil.ORDERNO);
            //添加订单主表
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
            orderMain.setOrderCates(orderAdditionalInfo.getAppointmentCates());
            orderMain.setAmount(orderAdditionalInfo.getAmount());
            boolean result = orderMainService.save(orderMain);
            //添加orderAdditionalInfo 表
            orderAdditionalInfo.setOrderNo(SysConfigUtil.getNoBySysConfig());
            orderAdditionalInfoService.save(orderAdditionalInfo);

            if(result=true){
                //添加entityHealthyAppointment 表
                orderAdditionalInfo.getEntityHealthyAppointment().setOrderNo(SysConfigUtil.getNoBySysConfig());
                entityHealthyAppointmentService.save(orderAdditionalInfo.getEntityHealthyAppointment());

            }
            if(result=true){
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
            }
            return ResultMap.ok("添加成功").put("data",orderAdditionalInfo.getOrderNo());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }





    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("lcd/orderAdditionalInfo/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderAdditionalInfoService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看lcd详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("lcd/orderAdditionalInfo/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderAdditionalInfo orderAdditionalInfo = orderAdditionalInfoService.getById(sysId);
        return ResultMap.ok().put("data",orderAdditionalInfo);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("lcd/orderAdditionalInfo/save")
    public ResultMap save(@Valid @RequestBody OrderAdditionalInfo orderAdditionalInfo) {
        try {
            orderAdditionalInfoService.save(orderAdditionalInfo);

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
    @RequiresPermissions("lcd/orderAdditionalInfo/update")
    public ResultMap update(@Valid @RequestBody OrderAdditionalInfo orderAdditionalInfo) {
        try {
            orderAdditionalInfoService.updateById(orderAdditionalInfo);
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
    @RequiresPermissions("lcd/orderAdditionalInfo/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderAdditionalInfoService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
