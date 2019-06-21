package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbCisPrescriptionDetail;
import com.annaru.upms.service.ITbCisPrescriptionDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 门诊处方明细表
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"门诊处方明细管理"}, description = "门诊处方明细管理")
@RestController
@RequestMapping("upms/cisPrescriptionDetail")
public class TbCisPrescriptionDetailController extends BaseController {

    @Reference
    private ITbCisPrescriptionDetailService iTbCisPrescriptionDetailService;

    /**
     * 门诊处方明细表
     * @param cyh	处方号码
     * @param yzid	处方项目明细号码
     * @param yljgdm 医疗机构代码
     */
    @ApiOperation(value = "门诊处方明细查询")
    @GetMapping("/getCisPrescriptionDetail")
    @RequiresPermissions("upms/cisPrescriptionDetail/getCisPrescriptionDetail")
    public ResultMap getCisPrescriptionDetail(String cyh, String yljgdm, String yzid) {
        try {
            TbCisPrescriptionDetail cisPrescriptionDetail = iTbCisPrescriptionDetailService.getCisPrescriptionDetail(cyh, yzid, yljgdm);
            return ResultMap.ok().put("data",cisPrescriptionDetail);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
