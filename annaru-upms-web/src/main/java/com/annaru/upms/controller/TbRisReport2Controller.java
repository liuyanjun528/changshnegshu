package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbRisReport2;
import com.annaru.upms.entity.medical.vo.TbRisReport2ListVo;
import com.annaru.upms.service.ITbRisReport2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * tb_ris_report2(影像检查报告表—通用格式)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"影像检查报告管理2"}, description = "影像检查报告管理2")
@RestController
@RequestMapping("upms/risReport2")
public class TbRisReport2Controller extends BaseController {

    @Reference
    private ITbRisReport2Service iTbRisReport2Service;

    /**
     * 影像检查报告表
     * @param yljgdm 医疗机构代码
     * @param studyuid	检查号
     * @param instanceuid 报告流水号
     */
    @ApiOperation(value = "影像检查报告查询")
    @GetMapping("/getRisReport2")
    @RequiresPermissions("upms/risReport2/getRisReport2")
    public ResultMap getRisReport(String yljgdm, String studyuid, String instanceuid) {
        try {
            TbRisReport2 risReport2 = iTbRisReport2Service.getRisReport2(yljgdm, studyuid, instanceuid);
            return ResultMap.ok().put("data",risReport2);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 影像检查报告表
     * @param kh 卡号
     */
    @ApiOperation(value = "根据卡号查询影像报告")
    @GetMapping("/getYxbg")
    @RequiresPermissions("upms/risReport/getYxbg")
    public ResultMap getYxbg(String kh) {
        try {
            List<TbRisReport2> listRisReport2 = iTbRisReport2Service.getYxbg(kh);
            return ResultMap.ok().put("data",listRisReport2);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 根据就诊流水号查询影像报告
     * @param jzlsh
     */
    @ApiOperation(value = "根据就诊流水号查询检验报告")
    @GetMapping("/getYxbgByJzlsh")
    @RequiresPermissions("upms/risReport2/getYxbgByJzlsh")
    public ResultMap getYxbgByJzlsh(String jzlsh) {
        try {
            List<TbRisReport2ListVo> listRisReport2 = iTbRisReport2Service.getYxbgByJzlsh(jzlsh);
            return ResultMap.ok().put("data",listRisReport2);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


}
