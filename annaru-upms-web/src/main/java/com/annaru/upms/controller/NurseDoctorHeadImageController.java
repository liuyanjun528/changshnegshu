package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.service.IExamCatesService;
import com.annaru.upms.service.INurseDoctorHeadImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 护士医生头像修改
 * @author wh
 * @date 2019-07-05 16:01:30
 */
@Api(tags = {"医护端护士医生头像修改"}, description = "医护端护士医生头像修改")
@RestController
@RequestMapping("upms/nurseDoctorHeadImage")
public class NurseDoctorHeadImageController extends BaseController {
    @Reference
    private INurseDoctorHeadImageService nurseDoctorHeadImageService;


    /**
     * 医护端修改护士头像
     */
    @ApiOperation(value = "医护端修改护士头像")
    @PostMapping("/updateNurseImage")
    //@RequiresPermissions("upms/nurseDoctorHeadImage/updateImage")
    public ResultMap updateNurseImage(String nurseNo,String headImage) {
        try {
                Boolean nurse = nurseDoctorHeadImageService.UpdateNurseHeadImage(nurseNo,headImage);
                if(nurse){
                    return ResultMap.ok("护士头像修改成功");
                }
            return ResultMap.error("修改失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


    /**
     * 医护端修改医生头像
     */
    @ApiOperation(value = "医护端修改医生头像")
    @PostMapping("/updateDoctorImage")
    //@RequiresPermissions("upms/nurseDoctorHeadImage/updateImage")
    public ResultMap updateDoctorImage(String doctorNo,String headImage) {
        try {
            Boolean doctor= nurseDoctorHeadImageService.UpdateDoctorHeadImage(doctorNo,headImage);
            if(doctor){
                return ResultMap.ok("医生头像修改成功");
            }
            return ResultMap.error("修改失败");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }








}
