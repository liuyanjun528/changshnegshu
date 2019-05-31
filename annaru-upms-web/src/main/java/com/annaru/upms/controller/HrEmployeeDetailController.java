package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.vo.HrEmployeeDetail;
import com.annaru.upms.service.IExamCatesService;
import com.annaru.upms.service.IHrEmployeeDetailService;
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
 * HR员工详情
 *
 * @author wh
 * @date 2019-05-31 11:14:30
 */
@Api(tags = {"HR员工详情"}, description = "HR员工详情")
@RestController
@RequestMapping("upms/depDetail")
public class HrEmployeeDetailController extends BaseController {
    @Reference
    private IHrEmployeeDetailService hrEmployeeDetailService;

    /**
     * 查看HR员工详情
     */
    @ApiOperation(value = "查看HR员工详情", notes = "查看HR员工详情")
    @GetMapping("/info")
    public ResultMap info(String userId,Integer referenceNo){
        List<HrEmployeeDetail> hrEmployeeDetail = hrEmployeeDetailService.selectEmployeeDetail(userId, referenceNo);
        return ResultMap.ok().put("data",hrEmployeeDetail);
    }



}
