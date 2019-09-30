package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.vo.EntityExclusiveDoctorVo;
import com.annaru.upms.service.IEntityExclusiveDoctorVoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:专属医生查询
 * @Author: wh 2019/6/3 13:43
 */
@Api(tags = {"专属医生信息查询"}, description = "专属医生信息查询")
@RestController
@RequestMapping("/upms")
public class EntityExclusiveDoctorVoController extends BaseController {
    @Reference
    private IEntityExclusiveDoctorVoService entityExclusiveDoctorVoService;


    /**
     * 专属医生信息查询 wh
     */
    @ApiOperation(value = "专属医生信息查询", notes = "专属医生信息查询")
    @GetMapping("/entityDoctorInfo")
    public ResultMap entityDoctorInfo(String userId){

        EntityExclusiveDoctorVo entityExclusiveDoctorVo = entityExclusiveDoctorVoService.selectExclusiveDoctor(userId);
        if(null==entityExclusiveDoctorVo){
            return ResultMap.ok().put("data",null);
        }
        return ResultMap.ok().put("data",entityExclusiveDoctorVo);
    }
}
