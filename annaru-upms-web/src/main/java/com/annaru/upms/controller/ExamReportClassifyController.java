package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.OrderExtensionExam;
import com.annaru.upms.entity.vo.ExamPackageDetailVo;
import com.annaru.upms.entity.vo.ExamReportInfoVo;
import com.annaru.upms.entity.vo.ExamReportVo;
import com.annaru.upms.entity.vo.ReportAbnormalW;
import com.annaru.upms.service.*;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 体检报告分类
 *
 * @author xck
 * @date 2019-07-26 09:30:52
 */
@Api(tags = "体检报告分类管理", description = "体检报告分类管理")
@RestController
@RequestMapping("upms/examReportClassify")
public class ExamReportClassifyController extends BaseController {
    @Reference
    private IExamReportClassifyService examReportClassifyService;
    @Reference
    private IExamPackageDetailService examPackageDetailService;
    @Reference
    private IOrderMainService orderMainService;
    @Reference
    private IExamReportReviewService examReportReviewService;
    @Reference
    private IOrderExtensionExamService orderExtensionExamService;

    /**
     * @Description: 用户检测报告列表
     * @Author: XCK
     * @Date: 2019/8/16
     */
    @ApiOperation(value = "用户所有检测报告列表")
    @GetMapping("/list")
    public ResultMap list(@ApiParam(value = "第几页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "分页数")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "用户编号")@RequestParam String userId,
                          @ApiParam(value = "套餐类别【1:标准套餐/2:HPV/3:肺保康】")@RequestParam Integer packageCates,
                          @ApiParam(value = "订单类别【1:一般体检预约(C端) 2:进阶体检预约(C端) 3:分布式体检预约(B端) 4:进阶体检预约(B端)】")@RequestParam(required = false) Integer orderCates,
                          @ApiParam(value = "报告类别【1:检测报告/2:影像报告/3:基因报告/4:其他报告】")@RequestParam(required = false) Integer cateId){
        PageUtils<ExamReportVo> pageList = orderMainService.getExamReportVoPage(page, limit,
                userId, packageCates, orderCates,cateId);
        return ResultMap.ok().put("data",pageList);
    }

    /**
     * @Description: 用户检测报告详情，报告建议
     * @Author: XCK
     * @Date: 2019/8/19
     */
    @ApiOperation(value = "报告建议")
    @GetMapping("/getSuggest")
    public ResultMap getSuggest(String orderNo){
        String suggestions = examReportReviewService.getSuggestions(orderNo);
        return ResultMap.ok().put("data", suggestions);
    }

    /**
     * @Description: 用户检测报告详情，建议进阶项
     * @Author: XCK
     * @Date: 2019/8/19
     */
    @ApiOperation(value = "建议进阶项")
    @GetMapping("/extensionList")
    public ResultMap extensionList(String orderNo){
        List<OrderExtensionExam> list = orderExtensionExamService.getListByOrderNo(orderNo);
        return ResultMap.ok().put("data", list);
    }

    /**
     * @Description: 用户检测报告详情，健康检查结果列表
     * @Author: XCK
     * @Date: 2019/8/19
     */
    @ApiOperation(value = "健康检查项目列表")
    @GetMapping("/getMasterList")
    public ResultMap getMasterList(Integer packageId){
        List<ExamPackageDetailVo> list = examPackageDetailService.getMasterList(packageId);
        return ResultMap.ok().put("data", list);
    }

    @ApiOperation(value = "查看报告结果详情")
    @GetMapping("/getReportInfo")
    public ResultMap getReportInfo(String orderNo, String masterId){
        ExamReportInfoVo reportInfo = examReportClassifyService.getReportInfo(orderNo, masterId);
        return ResultMap.ok().put("data", reportInfo);
    }

    /**
     * @Author:  wh
     * @param orderNo
     * @return
     */

    @ApiOperation(value = "查看报告异常项")
    @GetMapping("/getReportAbnormal")
    public ResultMap getReportAbnormal(String orderNo){
        List<ReportAbnormalW> reportAbnormalWS = examReportClassifyService.selectReportAbnormal(orderNo);
        return ResultMap.ok().put("data", reportAbnormalWS);
    }

}
