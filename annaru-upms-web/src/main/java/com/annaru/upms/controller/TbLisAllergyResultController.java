package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbLisAllergyResult;
import com.annaru.upms.service.ITbLisAllergyResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * tb_lis_allergy_result(药敏结果表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"药敏结果管理"}, description = "药敏结果管理")
@RestController
@RequestMapping("upms/lisAllergyResult")
public class TbLisAllergyResultController extends BaseController {

    @Reference
    private ITbLisAllergyResultService iTbLisAllergyResultService;

    /**
     * 药敏结果表
     * @param yljgdm 医疗机构代码
     * @param ymjglsh 药敏结果流水号
     */
    @ApiOperation(value = "药敏结果查询")
    @GetMapping("/getLisAllergyResult")
    @RequiresPermissions("upms/lisAllergyResult/getLisAllergyResult")
    public ResultMap getLisAllergyResult(String yljgdm, String ymjglsh) {
        try {
            TbLisAllergyResult lisAllergyResult = iTbLisAllergyResultService.getLisAllergyResult(yljgdm, ymjglsh);
            return ResultMap.ok().put("data",lisAllergyResult);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
