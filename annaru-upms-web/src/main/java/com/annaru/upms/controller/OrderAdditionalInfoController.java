package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.OrderAdditionalInfo;
import com.annaru.upms.service.IOrderAdditionalInfoService;
import com.annaru.upms.service.IOrderAppointmentService;
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
 * 预约其他信息
 *
 * @author xck
 * @date 2019-05-20 16:18:39
 */
@Api(tags = {"预约其他信息管理"}, description = "预约其他信息管理")
@RestController
@RequestMapping("lcd/orderAdditionalInfo")
public class OrderAdditionalInfoController extends BaseController {
    @Reference
    private IOrderAdditionalInfoService orderAdditionalInfoService;

    @Reference
    private IOrderAppointmentService orderAppointmentService;

    /**
     * 保存绿通行
     */
    @ApiOperation(value = "保存绿通行")
    @PostMapping("/saveGreenPassage1")
    //@RequiresPermissions("lcd/orderAdditionalInfo/save")
    public ResultMap saveGreenPassage(@Valid @RequestBody int option_1, int option_2, String situations,String institution_id, String department_id) {
        try {
            Map<String, Object> params1 = new HashMap<>();
            params1.put("option_1",option_1);
            params1.put("option_2",option_2);
            params1.put("situations",situations);
            orderAdditionalInfoService.insertAdditional_info(params1);

            Map<String, Object> params2 = new HashMap<>();
            params2.put("institution_id",institution_id);
            params2.put("department_id",department_id);
            orderAppointmentService.insertOrder_appointment(params2);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }





    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("lcd/orderAdditionalInfo/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderAdditionalInfoService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看lcd详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("lcd/orderAdditionalInfo/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderAdditionalInfo orderAdditionalInfo = orderAdditionalInfoService.getById(sysId);
        return ResultMap.ok().put("data",orderAdditionalInfo);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("lcd/orderAdditionalInfo/save")
    public ResultMap save(@Valid @RequestBody OrderAdditionalInfo orderAdditionalInfo) {
        try {
            orderAdditionalInfoService.save(orderAdditionalInfo);

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
    @RequiresPermissions("lcd/orderAdditionalInfo/update")
    public ResultMap update(@Valid @RequestBody OrderAdditionalInfo orderAdditionalInfo) {
        try {
            orderAdditionalInfoService.updateById(orderAdditionalInfo);
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
    @RequiresPermissions("lcd/orderAdditionalInfo/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderAdditionalInfoService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
