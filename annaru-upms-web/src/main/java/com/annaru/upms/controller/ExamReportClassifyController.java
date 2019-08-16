package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.vo.ExamReportVo;
import com.annaru.upms.service.IExamReportClassifyService;
import com.annaru.upms.service.IOrderMainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
    private IOrderMainService orderMainService;

    /**
     * @Description: 用户检测报告列表
     * @Author: XCK
     * @Date: 2019/8/16
     */
    @ApiOperation(value = "用户所有检测报告列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",value = "第几页",dataType = "Integer",required = true),
        @ApiImplicitParam(name = "limit",value = "分页数",dataType = "Integer",required = true),
        @ApiImplicitParam(name = "userId",value = "用户编号",dataType = "String",required = true),
        @ApiImplicitParam(name = "packageCates",value = "套餐类别【1:标准套餐/2:HPV/3:肺保康/】",dataType = "Integer",required = true),
        @ApiImplicitParam(name = "orderCates",value = "订单类别【1:一般体检预约(C端) 2:进阶体检预约(C端) 3:分布式体检预约(B端) 4:进阶体检预约(B端)】",dataType = "Integer",required = false),
    })
    @GetMapping("/list")
    public ResultMap list(@RequestParam(defaultValue="1") int page,
                          @RequestParam(defaultValue = "10") int limit,
                          @RequestParam String userId,
                          @RequestParam Integer packageCates,
                          @RequestParam(required = false) Integer orderCates){
        PageUtils<ExamReportVo> pageList = examReportClassifyService.getExamReportVoPage(page, limit,
                userId, packageCates, orderCates);
        return ResultMap.ok().put("data",pageList);
    }

}
