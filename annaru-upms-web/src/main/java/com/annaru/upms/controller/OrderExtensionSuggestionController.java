package com.annaru.upms.controller;

import java.util.*;

import com.annaru.common.exception.GlobalException;
import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.ExamReportReview;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.dto.OESaveDto;
import com.annaru.upms.entity.vo.ExamExtensionVo;
import com.annaru.upms.entity.vo.OrderExtensionSuggestionVo;
import com.annaru.upms.service.*;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.OrderExtensionSuggestion;

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
    @Reference
    private IOrderMainService orderMainService;
    @Reference
    private IExamPackageDetailService examPackageDetailService;
    @Reference
    private IExamReportReviewService examReportReviewService;

    /** 添加建议进阶项目
     * @params: OESaveDto
     * @return: com.annaru.common.result.ResultMap
     * @Author: jyehui
     * @Date: 2019/7/2 11:11
     */
    @ApiOperation(value = "添加建议进阶项目")
    @PostMapping("/savaOE")
    public ResultMap savaOE(@Valid @RequestBody OESaveDto oeSaveDto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {

                return ResultMap.error(400, bindingResult.getFieldError().getDefaultMessage());
            }
            String[] sIds = oeSaveDto.getSysIds().split(",");
            String[] items = oeSaveDto.getItemNames().split(",");
            String[] masters = oeSaveDto.getMasterIds().split(",");
            String[] suggestTimes = oeSaveDto.getSuggestTime().split(",");
            int numberDays = DateUtil.number_Days(oeSaveDto.getSuggestTime());
            if (sIds.length != items.length || sIds.length != masters.length || sIds.length != suggestTimes.length) {
                return ResultMap.error("参数有误!");
            }
            if (0 == numberDays) {

                return ResultMap.error("建议赴检查周期时间 格式有误！正确的格式：如一周、半个月、一个月等等");
            }
            ExamReportReview status = examReportReviewService.isStatus(oeSaveDto.getReportNo());
            if (null != status) {// 已解读
                return ResultMap.error("系统异常：您的报告已解读");
            }
            String selectByRno = examInspectReportService.selectByRno(oeSaveDto.getReportNo());
            if(null == selectByRno || "".equals(selectByRno) ) {
                return ResultMap.error("系统异常：通过该检查报告编号未解析到对应的订单编号");
            }
            boolean save = orderExtensionSuggestionService.savaOE(oeSaveDto.getReportNo(), masters, items,
                    sIds, oeSaveDto.getDoctorNo(), suggestTimes, numberDays, selectByRno);
            if(!save){
                return ResultMap.error("添加失败!");
            }
            return ResultMap.ok();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


    /**
     * 查看添加的进阶项目
     */
    @ApiOperation(value = "查看添加的进阶项目", notes = "查看添加的进阶项目")
    @GetMapping("/infoSuggestion")
    public ResultMap infoSuggestion(@ApiParam(value = "体检报告编号")@RequestParam(required = true)String reportNo){
        if (StringUtils.isBlank(reportNo)) {
            return ResultMap.error(400, "体检报告编号是必传字段");
        }

        OrderExtensionSuggestion suggestion = orderExtensionSuggestionService.isExists(examInspectReportService.selectByRno(reportNo));
        return ResultMap.ok().put("data",suggestion);
    }

    //@ApiOperation(value = "添加建议进阶项目")
    //@PostMapping("/savaOE")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "reportNo",value = "检查报告编号",dataType = "spring",paramType = "query"),
    //        @ApiImplicitParam(name = "masterIds",value = "进阶检查项目总编号",dataType = "spring",paramType = "query"),
    //        @ApiImplicitParam(name = "itemNames",value = "项目名称",dataType = "spring",paramType = "query"),
    //        @ApiImplicitParam(name = "sysIds",value = "体检项目编号",dataType = "spring",paramType = "query"),
    //        @ApiImplicitParam(name = "doctorNo",value = "医生编号",dataType = "spring",paramType = "query")
    //})
    //public ResultMap savaOE(String reportNo,String masterIds,String itemNames,String sysIds,String doctorNo) {
    //    try {
    //        if(StringUtils.isEmpty(reportNo) || StringUtils.isEmpty(itemNames)
    //                || StringUtils.isEmpty(sysIds) || StringUtils.isEmpty(doctorNo) || StringUtils.isEmpty(masterIds)){
    //            return ResultMap.error("参数不能为空!");
    //        }
    //        String[] sIds = sysIds.split(",");
    //        String[] items = itemNames.split(",");
    //        String[] masters = masterIds.split(",");
    //        if (sIds.length != items.length || sIds.length != masters.length) {
    //            return ResultMap.error("参数有误!");
    //        }
    //        boolean save = orderExtensionSuggestionService.savaOE(reportNo,masters,items,sIds,doctorNo);
    //        if(!save){
    //            return ResultMap.error("添加失败!");
    //        }
    //        return ResultMap.ok();
    //    } catch (Exception e) {
    //        logger.error(e.getMessage());
    //        return ResultMap.error("运行异常，请联系管理员");
    //    }
    //
    //}

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


    ///**
    // * 信息
    // */
    //@ApiOperation(value = "查看详情", notes = "查看upms详情")
    //@GetMapping("/info/{sysId}")
    //@RequiresPermissions("upms/orderExtensionSuggestion/info")
    //public ResultMap info(@PathVariable("sysId") Integer sysId){
    //    OrderExtensionSuggestion orderExtensionSuggestion = orderExtensionSuggestionService.getById(sysId);
    //    return ResultMap.ok().put("data",orderExtensionSuggestion);
    //}

    /**
     * 获取基础体检后需要进阶检查的体检项
     */
    @ApiOperation(value = "获取基础体检后需要进阶检查的体检项", notes = "获取基础体检后需要进阶检查的体检项")
    @GetMapping("/items/{orderNo}")
    @RequiresPermissions("upms/orderExtensionSuggestion/items")
    public ResultMap info(@PathVariable("orderNo") String orderNo){
        Map<String,Object> params = new HashMap<>();
        params.put("orderNo",orderNo);
        OrderMain orderMain = orderMainService.getReferenceNo(params);
        params.put("examId",orderMain.getReferenceNo());
        //套餐内进阶项
        List<ExamExtensionVo> extensionVos = examPackageDetailService.getEEChoosen(params);
        //进阶建议
        List<OrderExtensionSuggestionVo> orderExtensionSuggestion = orderExtensionSuggestionService.getItems(params);
        params.clear();
        for (int i=0;i<orderExtensionSuggestion.size();i++){
            for (int j = 0;j<extensionVos.size();j++){
                if (orderExtensionSuggestion.get(i).getName().equals(extensionVos.get(j).getName())&&
                orderExtensionSuggestion.get(i).getItemName().equals(extensionVos.get(j).getItemName())){
                    orderExtensionSuggestion.get(i).setAmount(0.0);
                }
            }
        }

        params.clear();
        params.put("packageItem",extensionVos);
        params.put("suggestItem",orderExtensionSuggestion);
        return ResultMap.ok().put("data",params);
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
