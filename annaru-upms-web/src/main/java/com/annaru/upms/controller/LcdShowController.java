package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.service.ILcdShowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



/**
 * @author wh
 * @date 2019-03-29 11:33:31
 */
@Api(tags = {"叫号管理"}, description = "叫号管理")
@RestController
@RequestMapping("/lcdShow")
public class LcdShowController extends BaseController {
    @Reference
    private ILcdShowService lcdShowService;

    @ApiOperation(value = "mysql查询")
    @GetMapping("/mysql")
    public ResultMap mysqlAll(){
        List<LcdShow> LcdShowListByMysql = lcdShowService.getLcdShowListByMysql();
        return ResultMap.ok().put("mysql",LcdShowListByMysql);
    }

    @ApiOperation(value = "sqlServer查询")
    @GetMapping("/sqlServer")
    public ResultMap sqlServerAll(){
        List<LcdShow> LcdShowListBySqlServer = lcdShowService.getLcdShowListBySqlServer();
        return ResultMap.ok().put("sqlServer",LcdShowListBySqlServer);
    }


}