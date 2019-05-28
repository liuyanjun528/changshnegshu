package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.OrderExtensionExam;
import com.annaru.upms.service.IOrderExtensionExamService;
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
 * 进阶体检项目
 *
 * @author xck
 * @date 2019-05-20 16:18:23
 */
@Api(tags = {"进阶体检项目管理"}, description = "进阶体检项目管理")
@RestController
@RequestMapping("lcd/orderExtensionExam")
public class OrderExtensionExamController extends BaseController {
    @Reference
    private IOrderExtensionExamService orderExtensionExamService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("lcd/orderExtensionExam/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderExtensionExamService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看lcd详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("lcd/orderExtensionExam/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderExtensionExam orderExtensionExam = orderExtensionExamService.getById(sysId);
        return ResultMap.ok().put("data",orderExtensionExam);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("lcd/orderExtensionExam/save")
    public ResultMap save(@Valid @RequestBody OrderExtensionExam orderExtensionExam) {
        try {
            orderExtensionExamService.save(orderExtensionExam);
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
    @RequiresPermissions("lcd/orderExtensionExam/update")
    public ResultMap update(@Valid @RequestBody OrderExtensionExam orderExtensionExam) {
        try {
            orderExtensionExamService.updateById(orderExtensionExam);
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
    @RequiresPermissions("lcd/orderExtensionExam/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderExtensionExamService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
