package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.entity.ExamUserRecordMain;
import com.annaru.upms.entity.vo.ExamUserRecordDetailVoSaveZ;
import com.annaru.upms.service.IExamUserRecordMainService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.ExamUserRecordDetail;
import com.annaru.upms.service.IExamUserRecordDetailService;
import javax.validation.Valid;



/**
 * 数据登记详细
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
@Api(tags = {"数据登记详细管理"}, description = "数据登记详细管理")
@RestController
@RequestMapping("upms/examUserRecordDetail")
public class ExamUserRecordDetailController extends BaseController {

    @Reference
    private IExamUserRecordDetailService examUserRecordDetailService;
    @Reference
    private IExamUserRecordMainService examUserRecordMainService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examUserRecordDetail/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = examUserRecordDetailService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
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
    @RequiresPermissions("upms/examUserRecordDetail/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            ExamUserRecordDetail examUserRecordDetail = examUserRecordDetailService.getById(sysId);
            return ResultMap.ok().put("examUserRecordDetail",examUserRecordDetail);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * @description 检测数据登记查询
     * @author zk
     * @date 2019-6-17
     */
    @ApiOperation(value = "检测数据登记查询", notes = "检测数据登记查询")
    @GetMapping("/selectRecordDetail")
    @RequiresPermissions("upms/examUserHealthyAppraisal/selectRecordDetail")
    public ResultMap selectRecordDetail(@RequestParam("orderNo") String orderNo,
                                        @RequestParam("userId") String userId){
        try {
            ExamUserRecordMain examUserRecordMain = new ExamUserRecordMain();
            examUserRecordMain.setOrderNo(orderNo);
            examUserRecordMain.setUserId(userId);
            ExamUserRecordMain examUserRecordMain1 = examUserRecordMainService.getOneByExamUserRecordMain(examUserRecordMain);
            if (examUserRecordMain1 != null){
                ExamUserRecordDetail examUserRecordDetail = new ExamUserRecordDetail();
                examUserRecordDetail.setMainId(examUserRecordMain1.getSysId());
                return ResultMap.ok().put("data", examUserRecordDetailService.getOneByExamUserRecordDetail(examUserRecordDetail));
            }else {
                return ResultMap.error("此用户订单的数据登记不存在！");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * @description 检测数据登记保存
     * @author zk
     * @date 2019-6-17
     */
    @ApiOperation(value = "检测数据登记保存", notes = "检测数据登记保存")
    @PostMapping("/recordDetailSave")
    @RequiresPermissions("upms/examUserHealthyAppraisal/recordDetailSave")
    public ResultMap recordDetailSave(@RequestBody ExamUserRecordDetailVoSaveZ examUserRecordDetailVoSaveZ){
        try {
            ExamUserRecordMain examUserRecordMain = new ExamUserRecordMain();
            examUserRecordMain.setOrderNo(examUserRecordDetailVoSaveZ.getOrderNo());
            examUserRecordMain.setUserId(examUserRecordDetailVoSaveZ.getUserId());
            ExamUserRecordMain examUserRecordMainIf = examUserRecordMainService.getOneByExamUserRecordMain(examUserRecordMain);
            if (examUserRecordMainIf != null) {
                return ResultMap.error("此用户订单的数据登记已存在！");
            }
            if (examUserRecordDetailService.recordDetailSave(examUserRecordDetailVoSaveZ.getOrderNo(), examUserRecordDetailVoSaveZ.getUserId(), examUserRecordDetailVoSaveZ.getExamUserRecordDetailList())){
                return ResultMap.ok("添加成功");
            }
            return ResultMap.error("运行异常，请联系管理员");
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
    @RequiresPermissions("upms/examUserRecordDetail/save")
    public ResultMap save(@Valid @RequestBody ExamUserRecordDetail examUserRecordDetail) {
        try {

            examUserRecordDetailService.save(examUserRecordDetail);
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
    @RequiresPermissions("upms/examUserRecordDetail/update")
    public ResultMap update(@Valid @RequestBody ExamUserRecordDetail examUserRecordDetail) {
        try {

            examUserRecordDetailService.updateById(examUserRecordDetail);
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
    @RequiresPermissions("upms/examUserRecordDetail/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examUserRecordDetailService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
