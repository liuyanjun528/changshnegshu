package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysAppraisal;
import com.annaru.upms.entity.vo.EntityExclusiveDoctorVo;
import com.annaru.upms.service.IEntityExclusiveDoctorVoService;
import com.annaru.upms.service.ISysAppraisalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    private IEntityExclusiveDoctorVoService entityExclusiveDoctorVoService;
    @Reference
    private ISysAppraisalService sysAppraisalService;


    /**
     * 专属医生信息查询
     */
    @ApiOperation(value = "专属医生信息查询", notes = "专属医生信息查询")
    @GetMapping("/info")
    //@RequiresPermissions("upms/info")
    public ResultMap info(String entityId,String userId){

        EntityExclusiveDoctorVo entityExclusiveDoctorVo = entityExclusiveDoctorVoService.selectExclusiveDoctor(entityId);
        if(null==entityExclusiveDoctorVo){
            return ResultMap.error().put("data","该企业没有专属医生");
        }

        Map<String, Object> map=new HashMap();
        map.put("userId",userId);
        map.put("docNo",entityExclusiveDoctorVo.getDoctorNo());
        SysAppraisal sysAppraisal = sysAppraisalService.selectOne(map);
        if(null==sysAppraisal){
            entityExclusiveDoctorVo.setIsAppraise(0);
        }else {
            entityExclusiveDoctorVo.setIsAppraise(1);
        }

        return ResultMap.ok().put("data",entityExclusiveDoctorVo);
    }



}
