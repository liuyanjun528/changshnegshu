package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.Call;
import com.annaru.upms.service.ICallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author wh
 * @date 2019-03-26 09:58:57
 */
@Api(tags = {"叫号管理"}, description = "叫号管理")
@RestController
@RequestMapping("/call")
public class CallController extends BaseController {

    @Reference
    private ICallService callService;

    @ApiOperation(value = "mysql查询")
    @GetMapping("/mysql")
    public ResultMap mysqlAll(){
        List<Call> callList= callService.getCallListByMysql();
        return ResultMap.ok().put("mysql",callList);
    }

    @ApiOperation(value = "oracle查询")
    @GetMapping("/oracle")
    public ResultMap oracleAll(){
        List<Call> callList= callService.getCallListByOracle();
        return ResultMap.ok().put("oracle",callList);
    }



}
