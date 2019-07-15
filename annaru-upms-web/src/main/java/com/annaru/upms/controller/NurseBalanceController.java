package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.UserWallet;
import com.annaru.upms.service.IExamCatesService;
import com.annaru.upms.service.INurseBalanceService;
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
 * @Description:护士收入信息
 * @Author: wh
 * @Date: 2019/7/11 10:24
 */
@Api(tags = {"护士收入信息"}, description = "护士收入信息")
@RestController
@RequestMapping("upms/nurseBalance")
public class NurseBalanceController extends BaseController {
    @Reference
    private INurseBalanceService nurseBalanceService;


    /**
     * 护士完成的累计单数
     */
    @ApiOperation(value = "护士的累计单数", notes = "护士的累计单数")
    @GetMapping("/singularInfo")
    @RequiresPermissions("upms/nurseBalance/singularInfo")
    public ResultMap selectSingular(String nurseNo){
        int i = nurseBalanceService.selectSingular(nurseNo);
        return ResultMap.ok().put("data",i);
    }

    /**
     * 护士完成的累计单数
     */
    @ApiOperation(value = "护士的应收入", notes = "护士的应收入")
    @GetMapping("/totalMoneyInfo")
    @RequiresPermissions("upms/nurseBalance/totalMoneyInfo")
    public ResultMap totalMoneyInfo(String nurseNo){
        Double aDouble = nurseBalanceService.selectTotalMoney(nurseNo);
        return ResultMap.ok().put("data",aDouble);
    }

    /**
     * 我的余额  到账金额-提现金额 =余额
     */
    @ApiOperation(value = "我的余额", notes = "我的余额")
    @GetMapping("/myBalance")
    @RequiresPermissions("upms/nurseBalance/myBalance")
    public ResultMap selectMyBalance(String userId){
        Double aDouble1 = nurseBalanceService.selectBalance1(userId);
        Double aDouble2 = nurseBalanceService.selectBalance2(userId);
        Double aDouble=aDouble1-aDouble2;
        return ResultMap.ok().put("data",aDouble);
    }

    /**
     * 护士收入明细
     */
    @ApiOperation(value = "护士收入明细", notes = "护士收入明细")
    @GetMapping("/moneyInfoList")
    @RequiresPermissions("upms/nurseBalance/moneyInfoList")
    public ResultMap selectMoneyInfoList(String userId,Integer tranCate){
        if(tranCate==null){
            tranCate=100;
        }
        Map<String, Object> params=new HashMap<>();
        params.put("userId",userId);
        params.put("tranCate",tranCate);
        List<UserWallet> userWallets = nurseBalanceService.selectMoneyInfoList(params);
        return ResultMap.ok().put("data",userWallets);
    }

}
