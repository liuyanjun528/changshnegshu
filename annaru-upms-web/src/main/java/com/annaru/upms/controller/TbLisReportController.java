package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbLisReport;
import com.annaru.upms.entity.medical.vo.TbLisReportListVo;
import com.annaru.upms.service.ITbLisReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * tb_lis_indicators(实验室检验报告表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"实验室检验报告管理"}, description = "实验室检验报告管理")
@RestController
@RequestMapping("upms/lisReport")
public class TbLisReportController extends BaseController {

    @Reference
    private ITbLisReportService iTbLisReportService;

    /**
     * 实验室检验报告表
     * @param yljgdm 医疗机构代码
     * @param bgdh	检验报告单号
     * @param bgrq	报告日期
     */
    @ApiOperation(value = "实验室检验报告查询")
    @GetMapping("/getLisReport")
    @RequiresPermissions("upms/lisReport/getLisReport")
    public ResultMap getLisReport(String yljgdm, String bgdh, String bgrq) {
        try {
            TbLisReport lisReport = iTbLisReportService.getLisReport(yljgdm, bgdh, bgrq);
            return ResultMap.ok().put("data",lisReport);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 实验室检验报告表
     * @param kh
     */
    @ApiOperation(value = "根据卡号查询检验报告列表")
    @GetMapping("/getJybg")
    @RequiresPermissions("upms/lisReport/getJybg")
    public ResultMap getJybg(String kh) {
        try {
            List<TbLisReportListVo> listLisReport = iTbLisReportService.getJybg(kh);
            return ResultMap.ok().put("data",listLisReport);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 实验室检验报告表
     * @param jzlsh
     */
    @ApiOperation(value = "根据就诊流水号查询检验报告")
    @GetMapping("/getJybgByJzlsh")
    @RequiresPermissions("upms/lisReport/getJybgByJzlsh")
    public ResultMap getJybgByJzlsh(String jzlsh) {
        try {
            List<TbLisReport> listLisReport = iTbLisReportService.getJybgByJzlsh(jzlsh);
            return ResultMap.ok().put("data",listLisReport);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 实验室检验报告表
     * @param bgdh
     */
    @ApiOperation(value = "根据报告单号查询检验报告")
    @GetMapping("/getJybgByBgdh")
    @RequiresPermissions("upms/lisReport/getJybgByBgdh")
    public ResultMap getJybgByBgdh(String bgdh) {
        try {
            TbLisReport lisReport = iTbLisReportService.getJybgByBgdh(bgdh);
            return ResultMap.ok().put("data",lisReport);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

}
