package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysDepartment;
import com.annaru.upms.entity.vo.SysDepartmentVo;
import com.annaru.upms.service.ISysDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 科室
 *
 * @author xck
 * @date 2019-05-10 10:44:18
 */
@Api(tags = {"科室管理"}, description = "科室管理")
@RestController
@RequestMapping("upms/sysDepartment")
public class SysDepartmentController extends BaseController {
    @Reference
    private ISysDepartmentService sysDepartmentService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysDepartment/list")
    public ResultMap list(@RequestParam String institutionId){
        Map<String, Object> params = new HashMap<>();
//        params.put("frequentUsed", frequentUsed);
        params.put("institutionId",institutionId);
        List<SysDepartmentVo> commonList = sysDepartmentService.getDepartmentCommonList(params);
        List<SysDepartment> frequentUsedList = sysDepartmentService.getFrequentUsedList(params);
        params.clear();
        params.put("frequentUsedList",frequentUsedList);
        params.put("commonList",commonList);
        return ResultMap.ok().put("data",params);
    }

}
