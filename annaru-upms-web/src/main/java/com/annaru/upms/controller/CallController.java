package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.Call;
import com.annaru.upms.service.ICallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author wh
 * @date 2019-03-26 09:58:57
 */
@Api(tags = {"管理"}, description = "管理")
@RestController
@RequestMapping("/call")
public class CallController extends BaseController {

    @Reference
    private ICallService callService;

    /**
     * 查询主表
     */
    @ApiOperation(value = "查询")
    @RequestMapping("/find")
    public ResultMap findAll(){
        List<Call> jiaohaoList= callService.findAll();
        return ResultMap.ok().put("jiaohaoList",jiaohaoList);
    }

    //查询从表
    @RequestMapping("/select")
    public ResultMap selectAll(){
        List<Call> calls= callService.selectAll();
        return ResultMap.ok().put("calls",calls);
    }



}
