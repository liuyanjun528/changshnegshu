package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamHandoverSheet;
import com.annaru.upms.entity.vo.ExamHandoverSheetVo;
import com.annaru.upms.entity.vo.examHandoverSheetVoWh;
import com.annaru.upms.service.IExamHandoverSheetService;
import com.annaru.upms.service.IExamHandoverSheetVoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 查询长生树护士端服务订单详情
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
@Api(tags = {"查询护士端服务订单详情"}, description = "查询护士端服务订单详情")
@RestController
@RequestMapping("upms")
public class ExamHandoverSheetVoController extends BaseController {
    @Reference
    private IExamHandoverSheetVoService examHandoverSheetVoService;

    /**
     * 查询护士端服务订单详情
     */
    @ApiOperation(value = "查询护士端服务订单详情", notes = "查询护士端服务订单详情")
    @GetMapping("/handoverSheetList")
    public ResultMap HandoverSheetList(String orderNo){
        try {
            ExamHandoverSheetVo examHandoverSheetVo = examHandoverSheetVoService.selectNurseOrderInfo(orderNo);
            return ResultMap.ok().put("data",examHandoverSheetVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 查询二维码内的信息
     */
    @ApiOperation(value = "查询二维码内的信息", notes = "查询二维码内的信息")
    @GetMapping("/queryInfo")
    public ResultMap queryInfo(String orderNo){
        try {
            examHandoverSheetVoWh examHandoverSheetVoWh = examHandoverSheetVoService.selectUserInfo(orderNo);
            return ResultMap.ok().put("data",examHandoverSheetVoWh);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


}
