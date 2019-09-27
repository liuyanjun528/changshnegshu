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
     * 护士本周收入，总收入，总订单，我的余额
     */
    @ApiOperation(value = "护士本周收入，总收入，总订单，我的余额", notes = "护士本周收入，总收入，总订单，我的余额")
    @GetMapping("/nurseWalletInfo")
    public ResultMap selectWallet(String nurseNo,String userId){
        int i = nurseBalanceService.selectSingular(nurseNo);//总订单
        Double aDouble = nurseBalanceService.selectTotalMoney(nurseNo);//总收入
        Double bDouble = nurseBalanceService.selectTotalMoneyByWeek(nurseNo);//本周收入
        Double cDouble = nurseBalanceService.selectBalance(userId);//我的余额
        return ResultMap.ok().put("data1",i).put("data2",aDouble).put("data3",bDouble).put("data4",cDouble);
    }


    /**
     * 护士收入明细
     */
    @ApiOperation(value = "护士收入明细", notes = "护士收入明细")
    @GetMapping("/moneyInfoList")
    //@RequiresPermissions("upms/nurseBalance/moneyInfoList")
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
