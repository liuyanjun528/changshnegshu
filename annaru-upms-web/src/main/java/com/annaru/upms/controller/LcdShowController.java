package com.annaru.upms.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.upms.service.ILcdShowService;
import com.annaru.common.base.BaseController;
import io.swagger.annotations.ApiOperation;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.LcdShow;
import io.swagger.annotations.Api;

import java.util.Date;
import java.util.List;



/**
 * @author wh
 * @date 2019-03-29 11:33:31
 */
@Api(tags = "叫号管理", description = "叫号管理")
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
