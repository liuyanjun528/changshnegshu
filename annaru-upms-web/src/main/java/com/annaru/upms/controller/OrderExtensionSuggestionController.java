package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.service.IExamInspectReportService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.OrderExtensionSuggestion;
import com.annaru.upms.service.IOrderExtensionSuggestionService;
import javax.validation.Valid;



/**
 * 进阶体检项目建议
 *
 * @author xck
 * @date 2019-05-22 17:42:35
 */
@Api(tags = {"进阶体检项目建议管理"}, description = "进阶体检项目建议管理")
@RestController
@RequestMapping("upms/orderExtensionSuggestion")
public class OrderExtensionSuggestionController extends BaseController {
    @Reference
    private IOrderExtensionSuggestionService orderExtensionSuggestionService;
    @Reference
    private IExamInspectReportService examInspectReportService;

   /***添加建议进阶项目
   * @params: [reportNo, masterId, itemName, sysId, doctorNo]
   * @return: com.annaru.common.result.ResultMap
   * @Author: jyehui
   * @Date: 2019/7/2 11:11
   */
    @ApiOperation(value = "添加建议进阶项目")
    @PostMapping("/savaOE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reportNo",value = "检查报告编号",dataType = "spring",paramType = "query"),
            @ApiImplicitParam(name = "masterId",value = "进阶检查项目总编号",dataType = "spring",paramType = "query"),
            @ApiImplicitParam(name = "itemName",value = "项目名称",dataType = "spring",paramType = "query"),
            @ApiImplicitParam(name = "sysId",value = "体检项目编号",dataType = "spring",paramType = "query"),
            @ApiImplicitParam(name = "doctorNo",value = "医生编号",dataType = "spring",paramType = "query")
    })
    public ResultMap savaOE(String reportNo,Integer masterId,String itemName,Integer sysId,String doctorNo) {
        try {
            String selectByRno = examInspectReportService.selectByRno(reportNo);
            if(null != selectByRno ){
                OrderExtensionSuggestion orderExtensionExam = new OrderExtensionSuggestion();
                orderExtensionExam.setOrderNo(selectByRno);//订单编号
                orderExtensionExam.setExamMasterId(masterId);//进阶检查项目总编号
                orderExtensionExam.setExamDetailId(sysId);//体检项目编号
                orderExtensionExam.setExamMasterItem(itemName);//项目名称
                orderExtensionExam.setDoctorNo(doctorNo);//医生编号
                orderExtensionExam.setCreationTime(new Date());
                //orderExtensionExam.setCreateBy();
                boolean save = orderExtensionSuggestionService.save(orderExtensionExam);
                if(save)
                return ResultMap.ok();
                return ResultMap.error("增加失败！");
            }else{
                return ResultMap.error("检查报告编号没有找到!");
            }
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
    @RequiresPermissions("upms/orderExtensionSuggestion/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderExtensionSuggestionService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/orderExtensionSuggestion/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderExtensionSuggestion orderExtensionSuggestion = orderExtensionSuggestionService.getById(sysId);
        return ResultMap.ok().put("data",orderExtensionSuggestion);
    }

    /**
     * 获取基础体检后需要进阶检查的体检项
     */
    @ApiOperation(value = "获取基础体检后需要进阶检查的体检项", notes = "获取基础体检后需要进阶检查的体检项")
    @GetMapping("/items/{orderNo}")
    @RequiresPermissions("upms/orderExtensionSuggestion/items")
    public ResultMap info(@PathVariable("orderNo") String orderNo){
        Map<String,Object> params = new HashMap<>();
        params.put("orderNo",orderNo);
        List<OrderExtensionSuggestion> orderExtensionSuggestion = orderExtensionSuggestionService.getItems(params);
        return ResultMap.ok().put("data",orderExtensionSuggestion);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/orderExtensionSuggestion/save")
    public ResultMap save(@Valid @RequestBody OrderExtensionSuggestion orderExtensionSuggestion) {
        try {
            orderExtensionSuggestionService.save(orderExtensionSuggestion);
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
    @RequiresPermissions("upms/orderExtensionSuggestion/update")
    public ResultMap update(@Valid @RequestBody OrderExtensionSuggestion orderExtensionSuggestion) {
        try {
            orderExtensionSuggestionService.updateById(orderExtensionSuggestion);
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
    @RequiresPermissions("upms/orderExtensionSuggestion/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderExtensionSuggestionService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
