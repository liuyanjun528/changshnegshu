package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.SysConfig;
import com.annaru.upms.entity.vo.OrderReceiptInfoSave;
import com.annaru.upms.service.ISysConfigService;
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

import com.annaru.upms.entity.OrderReceiptInfo;
import com.annaru.upms.service.IOrderReceiptInfoService;
import javax.validation.Valid;



/**
 * 开票记录
 *
 * @author zk
 * @date 2019-10-11 13:42:07
 */
@Api(tags = {"开票记录管理"}, description = "开票记录管理")
@RestController
@RequestMapping("upms/orderReceiptInfo")
public class OrderReceiptInfoController extends BaseController {

    @Reference
    private IOrderReceiptInfoService orderReceiptInfoService;
    @Reference
    private ISysConfigService sysConfigService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderReceiptInfo/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = orderReceiptInfoService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 开票中/已开票订单（列表）
     * @author zk
     * @date 2019/10/11
     */
    @ApiOperation(value = "开票中/已开票订单（列表）")
    @GetMapping("/receiptOfStatusList")
    @RequiresPermissions("upms/orderReceiptInfo/receiptOfStatusList")
    public ResultMap receiptOfStatusList(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "用户编号")@RequestParam String userId,
                          @ApiParam(value = "当前状态(1:进行中/2:已开票)")@RequestParam Integer status){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("userId", userId);
            params.put("status", status);
            PageUtils<Map<String, Object>> pageList = orderReceiptInfoService.receiptOfStatusList(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 开具发票
     * @author zk
     * @date 2019/10/11
     */
    @ApiOperation(value = "开具发票")
    @PostMapping("/receiptSave")
    @RequiresPermissions("upms/orderReceiptInfo/receiptSave")
    public ResultMap receiptSave(@Valid @RequestBody OrderReceiptInfoSave ors) {
        try {
            if (ors != null){
                SysConfig sysConfig = SysConfigUtil.getSysConfig(sysConfigService, SysConfigUtil.RECEIPT);
                OrderReceiptInfo oro = new OrderReceiptInfo();
                oro.setReceiptNo(SysConfigUtil.getNoBySysConfig());
                oro.setReceiptForms(ors.getReceiptForms());
                oro.setReceiptCate(ors.getReceiptCate());
                oro.setEntityCate(ors.getEntityCate());
                oro.setEntityName(ors.getEntityName());
                oro.setTaxNo(ors.getTaxNo());
                oro.setAddress(ors.getAddress());
                oro.setTelNo(ors.getTelNo());
                oro.setBankName(ors.getBankName());
                oro.setAccountNo(ors.getAccountNo());
                oro.setTotalAmount(ors.getTotalAmount());
                oro.setContent(ors.getContent());
                oro.setEmailAddress(ors.getEmailAddress());
                oro.setStatus(1);
                oro.setCreationTime(new Date());

                if (orderReceiptInfoService.receiptSave(oro, ors)){
                    if (SysConfigUtil.saveRefNo(sysConfig)){
                        return ResultMap.ok("开票保存成功");
                    }
                }
            }
            return ResultMap.error("开票保存失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 发票详情
     * @author zk
     * @date 2019/10/12
     */
    @ApiOperation(value = "发票详情")
    @GetMapping("/receiptDetail")
    @RequiresPermissions("upms/orderReceiptInfo/receiptDetail")
    public ResultMap receiptDetail(@ApiParam(value = "用户编号")@RequestParam String receiptNo){
        try {
            return ResultMap.ok().put("page", orderReceiptInfoService.receiptDetail(receiptNo));
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
    @RequiresPermissions("upms/orderReceiptInfo/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            OrderReceiptInfo orderReceiptInfo = orderReceiptInfoService.getById(sysId);
            return ResultMap.ok().put("orderReceiptInfo",orderReceiptInfo);
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
    @RequiresPermissions("upms/orderReceiptInfo/save")
    public ResultMap save(@Valid @RequestBody OrderReceiptInfo orderReceiptInfo) {
        try {

//            orderReceiptInfo.setCreateUser(ShiroKit.getUser().getId());
//            orderReceiptInfo.setCreateTime(new Date());
//            orderReceiptInfo.setUpdateTime(new Date());
            orderReceiptInfoService.save(orderReceiptInfo);
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
    @RequiresPermissions("upms/orderReceiptInfo/update")
    public ResultMap update(@Valid @RequestBody OrderReceiptInfo orderReceiptInfo) {
        try {
//            orderReceiptInfo.setUpdateTime(new Date());
            orderReceiptInfoService.updateById(orderReceiptInfo);
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
    @RequiresPermissions("upms/orderReceiptInfo/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderReceiptInfoService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
