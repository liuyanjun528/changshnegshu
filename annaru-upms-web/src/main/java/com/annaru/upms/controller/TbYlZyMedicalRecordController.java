package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbYlZyMedicalRecord;
import com.annaru.upms.entity.medical.vo.TbYlZyMedicalRecordListVo;
import com.annaru.upms.service.ITbYlZyMedicalRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * tb_yl_zy_medical_record(住院就诊记录表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"住院就诊记录管理"}, description = "住院就诊记录管理")
@RestController
@RequestMapping("upms/ylZyMedicalRecord")
public class TbYlZyMedicalRecordController extends BaseController {

    @Reference
    private ITbYlZyMedicalRecordService iTbYlZyMedicalRecordService;

    /**
     * 住院就诊记录表
     * @param yljgdm 医疗机构代码
     * @param jzlsh	 门诊就诊流水号
     */
    @ApiOperation(value = "住院就诊记录查询")
    @GetMapping("/getYlZyMedicalRecord")
    @RequiresPermissions("upms/ylZyMedicalRecord/getYlZyMedicalRecord")
    public ResultMap getYlZyMedicalRecord(String yljgdm, String jzlsh) {
        try {
            TbYlZyMedicalRecord ylZyMedicalRecord = iTbYlZyMedicalRecordService.getYlZyMedicalRecord(yljgdm, jzlsh);
            return ResultMap.ok().put("data",ylZyMedicalRecord);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 住院就诊记录表
     * @param kh 卡号
     */
    @ApiOperation(value = "根据卡号查询住院就诊记录")
    @GetMapping("/getJzjl")
    @RequiresPermissions("upms/ylZyMedicalRecord/getJzjl")
    public ResultMap getJzjl(String kh) {
        try {
            List<TbYlZyMedicalRecordListVo> listYlZyMedicalRecord = iTbYlZyMedicalRecordService.getJyjl(kh);
            return ResultMap.ok().put("data",listYlZyMedicalRecord);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

}
