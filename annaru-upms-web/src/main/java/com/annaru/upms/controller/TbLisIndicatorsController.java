package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbLisIndicators;
import com.annaru.upms.service.ITbLisIndicatorsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * tb_lis_indicators(检验结果指标表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"检验结果指标管理"}, description = "检验结果指标管理")
@RestController
@RequestMapping("upms/lisIndicators")
public class TbLisIndicatorsController extends BaseController {

    @Reference
    private ITbLisIndicatorsService iTbLisIndicatorsService;

    /**
     * 检验结果指标表
     * @param yljgdm 医疗机构代码
     * @param jyzblsh 检验指标流水号
     */
    @ApiOperation(value = "检验结果指标查询")
    @GetMapping("/getLisIndicators")
    @RequiresPermissions("upms/lisIndicators/getLisIndicators")
    public ResultMap getLisIndicators(String yljgdm, String jyzblsh) {
        try {
            TbLisIndicators lisIndicators = iTbLisIndicatorsService.getLisIndicators(yljgdm, jyzblsh);
            return ResultMap.ok().put("data",lisIndicators);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 检验结果指标表
     * @param bgdh 检验报告单号
     */
    @ApiOperation(value = "根据检验报告单号查询检验结果")
    @GetMapping("/getJybg")
    @RequiresPermissions("upms/lisIndicators/getJybg")
    public ResultMap getJybg(String bgdh) {
        try {
            List<TbLisIndicators> listLisIndicators = iTbLisIndicatorsService.getJybg(bgdh);
            return ResultMap.ok().put("data",listLisIndicators);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
