package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbLisBacteriaResult;
import com.annaru.upms.service.ITbLisBacteriaResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * tb_lis_bacteria_result(细菌结果表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"细菌结果管理"}, description = "细菌结果管理")
@RestController
@RequestMapping("upms/lisBacteriaResult")
public class TbLisBacteriaResultController extends BaseController {

    @Reference
    private ITbLisBacteriaResultService iTbLisBacteriaResultService;

    /**
     * 细菌结果表
     * @param yljgdm 医疗机构代码
     * @param xjjglsh 细菌结果流水号
     */
    @ApiOperation(value = "细菌结果查询")
    @GetMapping("/getLisBacteriaResult")
    @RequiresPermissions("upms/lisBacteriaResult/getLisBacteriaResult")
    public ResultMap getLisBacteriaResult(String yljgdm, String xjjglsh) {
        try {
            TbLisBacteriaResult lisBacteriaResult = iTbLisBacteriaResultService.getLisBacteriaResult(yljgdm, xjjglsh);
            return ResultMap.ok().put("data",lisBacteriaResult);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
