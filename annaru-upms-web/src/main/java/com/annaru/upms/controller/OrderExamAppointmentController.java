package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.OrderExamAppointment;
import com.annaru.upms.service.IOrderExamAppointmentService;
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
 * 定单(体检)预约
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"定单(体检)预约管理"}, description = "定单(体检)预约管理")
@RestController
@RequestMapping("upms/orderExamAppointment")
public class OrderExamAppointmentController extends BaseController {
    @Reference
    private IOrderExamAppointmentService orderExamAppointmentService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderExamAppointment/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderExamAppointmentService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/orderExamAppointment/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderExamAppointment orderExamAppointment = orderExamAppointmentService.getById(sysId);
        return ResultMap.ok().put("orderExamAppointment",orderExamAppointment);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/orderExamAppointment/save")
    public ResultMap save(@Valid @RequestBody OrderExamAppointment orderExamAppointment) {
        try {

//            orderExamAppointment.setCreateUser(ShiroKit.getUser().getId());
//            orderExamAppointment.setCreateTime(new Date());
//            orderExamAppointment.setUpdateTime(new Date());
            orderExamAppointmentService.save(orderExamAppointment);
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
    @RequiresPermissions("upms/orderExamAppointment/update")
    public ResultMap update(@Valid @RequestBody OrderExamAppointment orderExamAppointment) {
        try {
//            orderExamAppointment.setUpdateTime(new Date());
            orderExamAppointmentService.updateById(orderExamAppointment);
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
    @RequiresPermissions("upms/orderExamAppointment/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderExamAppointmentService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
