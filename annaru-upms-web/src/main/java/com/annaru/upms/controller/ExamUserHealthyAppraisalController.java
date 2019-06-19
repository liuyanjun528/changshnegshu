package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.entity.ExamUserRecordMain;
import com.annaru.upms.service.IExamUserRecordMainService;
import jodd.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.ExamUserHealthyAppraisal;
import com.annaru.upms.service.IExamUserHealthyAppraisalService;
import javax.validation.Valid;



/**
 * 个人健康评估
 *
 * @author zk
 * @date 2019-06-17 13:19:24
 */
@Api(tags = {"个人健康评估管理"}, description = "个人健康评估管理")
@RestController
@RequestMapping("upms/examUserHealthyAppraisal")
public class ExamUserHealthyAppraisalController extends BaseController {
    @Reference
    private IExamUserHealthyAppraisalService examUserHealthyAppraisalService;
    @Reference
    private IExamUserRecordMainService examUserRecordMainService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examUserHealthyAppraisal/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = examUserHealthyAppraisalService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * @description 健康评估保存
     * @author zk
     * @date 2019-6-18
     */
    @ApiOperation(value = "健康评估保存", notes = "健康评估保存")
    @PostMapping("/info/saveExamUserHealthyAppraisal")
    @RequiresPermissions("upms/examUserHealthyAppraisal/saveExamUserHealthyAppraisal")
    public ResultMap saveExamUserHealthyAppraisal(@RequestBody ExamUserHealthyAppraisal examUserHealthyAppraisal){
        try {

            if (examUserHealthyAppraisal == null || StringUtil.isBlank(examUserHealthyAppraisal.getOrderNo()) || StringUtil.isBlank(examUserHealthyAppraisal.getUserId())){
                return ResultMap.error("参数不能为空！");
            }
            ExamUserHealthyAppraisal examUserHealthyAppraisal1 = examUserHealthyAppraisalService.getOneByExamUserHealthyAppraisal(examUserHealthyAppraisal);
            if (examUserHealthyAppraisal1 != null){
                return ResultMap.error("该订单编号和用户已存在！");
            }
            if (examUserHealthyAppraisalService.save(examUserHealthyAppraisal)){
                return ResultMap.ok("添加成功！");
            }
            return ResultMap.error("运行异常，请联系管理员");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * @description 健康评估查看
     * @author zk
     * @date 2019-6-18
     */
    @ApiOperation(value = "健康评估查看", notes = "健康评估查看")
    @GetMapping("/info/getExamUserHealthyAppraisal")
    @RequiresPermissions("upms/examUserHealthyAppraisal/getExamUserHealthyAppraisal")
    public ResultMap getExamUserHealthyAppraisal(@RequestParam("orderNo") String orderNo,
                                                 @RequestParam("userId") String userId){
        try {
            ExamUserHealthyAppraisal examUserHealthyAppraisal = new ExamUserHealthyAppraisal();
            examUserHealthyAppraisal.setOrderNo(orderNo);
            examUserHealthyAppraisal.setUserId(userId);
            return ResultMap.ok().put("data", examUserHealthyAppraisalService.getOneByExamUserHealthyAppraisal(examUserHealthyAppraisal));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * @description 健康评估提交
     * @author zk
     * @date 2019-6-18
     */
    @ApiOperation(value = "健康评估提交", notes = "健康评估提交")
    @PostMapping("/info/submitExamUserHealthyAppraisal")
    @RequiresPermissions("upms/examUserHealthyAppraisal/submitExamUserHealthyAppraisal")
    public ResultMap submitExamUserHealthyAppraisal(@RequestParam("orderNo") String orderNo,
                                                    @RequestParam("userId") String userId,
                                                    @RequestParam("submitBy") String submitBy){
        try {
            ExamUserRecordMain examUserRecordMain = new ExamUserRecordMain();
            examUserRecordMain.setOrderNo(orderNo);
            examUserRecordMain.setUserId(userId);
            ExamUserRecordMain examUserRecordMainIf = examUserRecordMainService.getOneByExamUserRecordMain(examUserRecordMain);
            if (examUserRecordMainIf == null){
                return ResultMap.error("数据登记未完成！");
            }
            ExamUserHealthyAppraisal examUserHealthyAppraisal = new ExamUserHealthyAppraisal();
            examUserHealthyAppraisal.setOrderNo(orderNo);
            examUserHealthyAppraisal.setUserId(userId);
            ExamUserHealthyAppraisal examUserHealthyAppraisal1 = examUserHealthyAppraisalService.getOneByExamUserHealthyAppraisal(examUserHealthyAppraisal);
            if (examUserHealthyAppraisal1 == null){
                return ResultMap.error("健康评估未完成！");
            }
            examUserHealthyAppraisal1.setIsSubmitted(1);
            examUserHealthyAppraisal1.setSubmitTime(new Date());
            examUserHealthyAppraisal1.setSubmitBy(submitBy);
            if (examUserHealthyAppraisalService.updateById(examUserHealthyAppraisal1)){
                return ResultMap.error("提交成功！");
            }
            return ResultMap.error("运行异常，请联系管理员");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * @description 健康评估与风险预测
     * @author zk
     * @date 2019-6-18
     */
    @ApiOperation(value = "健康评估与风险预测", notes = "健康评估与风险预测")
    @GetMapping("/liExamUserHealthyAppraisal")
    @RequiresPermissions("upms/examUserHealthyAppraisal/liExamUserHealthyAppraisal")
    public ResultMap liExamUserHealthyAppraisal(@RequestParam("userId") String userId){
        try {
            ExamUserHealthyAppraisal examUserHealthyAppraisal = new ExamUserHealthyAppraisal();
            examUserHealthyAppraisal.setUserId(userId);
            ExamUserHealthyAppraisal examUserHealthyAppraisal1 = examUserHealthyAppraisalService.getOneByExamUserHealthyAppraisal(examUserHealthyAppraisal);
            return ResultMap.ok().put("data",examUserHealthyAppraisal1);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * @description 健康评估详情
     * @author zk
     * @date 2019-6-18
     */
    @ApiOperation(value = "健康评估详情", notes = "健康评估详情")
    @GetMapping("/deatiaExamUserHealthyAppraisal")
    @RequiresPermissions("upms/examUserHealthyAppraisal/deatiaExamUserHealthyAppraisal")
    public ResultMap deatiaExamUserHealthyAppraisal(@RequestParam("userId") String userId, @RequestParam("userCate") Integer userCate){
        try {
            // 本人
            if (userCate == 1){
                return ResultMap.ok().put("data", examUserHealthyAppraisalService.getUserDeatailByExamUserHealthyAppraisal(userId));
            }
            // 亲属
            if (userCate == 2){
                return ResultMap.ok().put("data", examUserHealthyAppraisalService.getRelativesDeatailByExamUserHealthyAppraisal(userId));
            }
            return ResultMap.ok().put("data",null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/examUserHealthyAppraisal/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            ExamUserHealthyAppraisal examUserHealthyAppraisal = examUserHealthyAppraisalService.getById(sysId);
            return ResultMap.ok().put("examUserHealthyAppraisal",examUserHealthyAppraisal);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/examUserHealthyAppraisal/save")
    public ResultMap save(@Valid @RequestBody ExamUserHealthyAppraisal examUserHealthyAppraisal) {
        try {

            examUserHealthyAppraisalService.save(examUserHealthyAppraisal);
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
    @RequiresPermissions("upms/examUserHealthyAppraisal/update")
    public ResultMap update(@Valid @RequestBody ExamUserHealthyAppraisal examUserHealthyAppraisal) {
        try {
            examUserHealthyAppraisalService.updateById(examUserHealthyAppraisal);
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
    @RequiresPermissions("upms/examUserHealthyAppraisal/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examUserHealthyAppraisalService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
