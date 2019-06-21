package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbYlMzMedicalRecord;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordListVo;
import com.annaru.upms.service.ITbYlMzMedicalRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * tb_yl_mz_medical_record(门诊就诊记录表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"门诊就诊记录管理"}, description = "门诊就诊记录管理")
@RestController
@RequestMapping("upms/ylMzMedicalRecord")
public class TbYlMzMedicalRecordController extends BaseController {

    @Reference
    private ITbYlMzMedicalRecordService iTbYlMzMedicalRecordService;

    /**
     * 门诊就诊记录表
     * @param yljgdm 医疗机构代码
     * @param jzlsh	 门诊就诊流水号
     */
    @ApiOperation(value = "门诊就诊记录查询")
    @GetMapping("/getYlMzMedicalRecord")
    @RequiresPermissions("upms/ylMzMedicalRecord/getYlMzMedicalRecord")
    public ResultMap getYlMzMedicalRecord(String yljgdm, String jzlsh) {
        try {
            TbYlMzMedicalRecord ylMzMedicalRecord = iTbYlMzMedicalRecordService.getYlMzMedicalRecord(yljgdm, jzlsh);
            return ResultMap.ok().put("data",ylMzMedicalRecord);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     *  门诊就诊记录表
     * @param kh 卡号
     */
    @ApiOperation(value = "根据卡号查询门诊记录列表")
    @GetMapping("/getJzjl")
    @RequiresPermissions("upms/ylMzMedicalRecord/getJzjl")
    public ResultMap getJzjl(String kh) {
        try {
            List<TbYlMzMedicalRecordListVo> listYlMzMedicalRecord = iTbYlMzMedicalRecordService.getJzjl(kh);
            return ResultMap.ok().put("data",listYlMzMedicalRecord);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     *  门诊就诊记录表
     * @param jzlsh 就诊流水号
     */
    @ApiOperation(value = "根据就诊流水号查询就诊记录")
    @GetMapping("/getJzjlByJzlsh")
    @RequiresPermissions("upms/ylMzMedicalRecord/getJzjlByJzlsh")
    public ResultMap getJzjlByJzlsh(String jzlsh) {
        try {
            TbYlMzMedicalRecord ylMzMedicalRecord = iTbYlMzMedicalRecordService.getJzjlByJzlsh(jzlsh);
            return ResultMap.ok().put("data",ylMzMedicalRecord);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     *  门诊就诊记录表
     * @param csid 就诊记录id
     */
    @ApiOperation(value = "根据就诊记录id查询对应的就诊记录")
    @GetMapping("/getJzjlById")
    @RequiresPermissions("upms/ylMzMedicalRecord/getJzjlById")
    public ResultMap getJzjlById(String csid) {
        try {
            TbYlMzMedicalRecordListVo ylMzMedicalRecord = iTbYlMzMedicalRecordService.getJzjlById(csid);
            return ResultMap.ok().put("data",ylMzMedicalRecord);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


}
