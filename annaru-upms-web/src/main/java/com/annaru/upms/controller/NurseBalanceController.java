package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamCates;
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
    @ApiOperation(value = "护士的累计收入", notes = "护士的累计收入")
    @GetMapping("/totalMoneyInfo")
    @RequiresPermissions("upms/nurseBalance/totalMoneyInfo")
    public ResultMap totalMoneyInfo(String nurseNo){
        Double aDouble = nurseBalanceService.selectTotalMoney(nurseNo);
        return ResultMap.ok().put("data",aDouble);
    }


}
