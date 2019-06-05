package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.vo.EntityExclusiveDoctorVo;
import com.annaru.upms.service.IEntityExclusiveDoctorVoService;
import com.annaru.upms.service.IExamCatesService;
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
 * @Description:专属医生查询
 * @Author: wh 2019/6/3 13:43
 */
@Api(tags = {"专属医生信息查询"}, description = "专属医生信息查询")
@RestController
@RequestMapping("/upms")
public class EntityExclusiveDoctorVoController extends BaseController {
    @Reference
    private IEntityExclusiveDoctorVoService eedv;

    /**
     * 专属医生信息查询
     */
    @ApiOperation(value = "专属医生信息查询", notes = "专属医生信息查询")
    @GetMapping("/info/{entityId}")
    @RequiresPermissions("upms/info")
    public ResultMap info(@PathVariable("entityId") String entityId){
        List<EntityExclusiveDoctorVo> entityExclusiveDoctorVos = eedv.selectExclusiveDoctor(entityId);
        return ResultMap.ok().put("data",entityExclusiveDoctorVos);
    }



}
