package com.annaru.upms.controller;

import java.util.*;

import com.annaru.common.constants.TopupCardEnum;
import com.annaru.upms.entity.SysTopupCardFormular;
import com.annaru.upms.service.ISysTopupCardFormularService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import com.annaru.upms.entity.SysTopupCardCate;
import com.annaru.upms.service.ISysTopupCardCateService;

import javax.validation.Valid;


/**
 * 充值\套餐卡类别
 *
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
@Api(tags = {"充值卡、套餐卡类别管理"}, description = "充值卡、套餐卡类别管理")
@RestController
@RequestMapping("upms/sysTopupCardCate")
public class SysTopupCardCateController extends BaseController {
    @Reference
    private ISysTopupCardCateService sysTopupCardCateService;
    @Reference
    private ISysTopupCardFormularService sysTopupCardFormularService;

    /**
     * 商城充值卡（列表）
     */
    @ApiOperation(value = "商城充值卡（列表）")
    @GetMapping("/list")
    public ResultMap list(@ApiParam(value = "当前页") @RequestParam(defaultValue = "1") int page,
                          @ApiParam(value = "每页数量") @RequestParam(defaultValue = "10") int limit) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page", page);
            params.put("limit", limit);
            PageUtils<Map<String, Object>> pageList = sysTopupCardCateService.getDataPage(params);
            return ResultMap.ok().put("data", pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 充值卡详情
     */
    @ApiOperation(value = "充值卡详情", notes = "充值卡详情")
    @GetMapping("/info/{sysId}")
    public ResultMap info(@PathVariable("sysId") Integer sysId) {
        try {
            SysTopupCardCate sysTopupCardCate = sysTopupCardCateService.detail(sysId);
            return ResultMap.ok().put("data", sysTopupCardCate);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 充值卡规则
     */
    @ApiOperation(value = "充值卡规则")
    @GetMapping("/formular")
    public ResultMap formular() {
        try {
            List<SysTopupCardFormular> list = sysTopupCardFormularService.listFormular(TopupCardEnum.CardFormularCates.TOPUP_CARD.getValue());
            return ResultMap.ok().put("data", list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 充值卡赠送规则
     */
    @ApiOperation(value = "充值卡赠送规则")
    @GetMapping("/giveAwayFormular")
    public ResultMap giveAwayFormular() {
        try {
            List<SysTopupCardFormular> list = sysTopupCardFormularService.listFormular(TopupCardEnum.CardFormularCates.GIVE_AWAY.getValue());
            return ResultMap.ok().put("data", list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 激活充值卡
     */
    @ApiOperation(value = "激活充值卡", notes = "激活充值卡")
    @PostMapping("/activation")
    public ResultMap activation(@RequestParam("serialNo") String serialNo, @RequestParam("activepin") String activepin) {
        return sysTopupCardCateService.activation(serialNo, activepin);
    }


}
