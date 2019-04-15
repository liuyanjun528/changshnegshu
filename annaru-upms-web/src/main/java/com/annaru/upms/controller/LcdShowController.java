package com.annaru.upms.controller;


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

import java.util.List;
import java.util.Map;


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

    @ApiOperation(value = "小屏当前连接设备信息")
    @GetMapping("/lcdSmallList")
    public ResultMap lcdSmallList(){
        List<Map<String, String>> mapList = lcdShowService.getLcdSmallList();
        return ResultMap.ok().put("list",mapList);
    }

    @ApiOperation(value = "大屏当前连接设备信息")
    @GetMapping("/lcdBigList")
    public ResultMap lcdBigList(){
        List<Map<String, String>> mapList = lcdShowService.getLcdBigList();
        return ResultMap.ok().put("list",mapList);
    }


}
