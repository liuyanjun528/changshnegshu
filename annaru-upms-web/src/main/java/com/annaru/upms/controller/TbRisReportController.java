package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbRisReport;
import com.annaru.upms.entity.medical.vo.TbRisReportListVo;
import com.annaru.upms.service.ITbRisReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * tb_ris_report(影像检查报告表—放射类格式)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"影像检查报告管理"}, description = "影像检查报告管理")
@RestController
@RequestMapping("upms/risReport")
public class TbRisReportController extends BaseController {

    @Reference
    private ITbRisReportService iTbRisReportService;

    /**
     * 影像检查报告表
     * @param yljgdm 医疗机构代码
     * @param studyuid	检查号
     * @param instanceuid 报告流水号
     */
    @ApiOperation(value = "影像检查报告查询")
    @GetMapping("/getRisReport")
    @RequiresPermissions("upms/risReport/getRisReport")
    public ResultMap getRisReport(String yljgdm, String studyuid, String instanceuid) {
        try {
            TbRisReport risReport = iTbRisReportService.getRisReport(yljgdm, studyuid, instanceuid);
            return ResultMap.ok().put("data",risReport);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 影像检查报告表
     * @param kh 卡号
     */
    @ApiOperation(value = "根据卡号查询检查报告")
    @GetMapping("/getYxbg")
    @RequiresPermissions("upms/risReport/getYxbg")
    public ResultMap getYxbg(String kh) {
        try {
            List<TbRisReportListVo> listRisReport = iTbRisReportService.getYxbg(kh);
            return ResultMap.ok().put("data",listRisReport);
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
    @RequiresPermissions("upms/risReport/getYxbgByJzlsh")
    public ResultMap getYxbgByJzlsh(String jzlsh) {
        try {
            List<TbRisReportListVo> listRisReport = iTbRisReportService.getYxbgByJzlsh(jzlsh);
            return ResultMap.ok().put("data",listRisReport);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


}
