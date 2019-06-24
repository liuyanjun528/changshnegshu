package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbCisDradviceDetail;
import com.annaru.upms.service.ITbCisDradviceDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 住院医嘱明细表
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"住院医嘱明细管理"}, description = "住院医嘱明细管理")
@RestController
@RequestMapping("upms/cisDradviceDetail")
public class TbCisDradviceDetailController extends BaseController {

    @Reference
    private ITbCisDradviceDetailService iTbCisDradviceDetailService;

    /**
     * 住院医嘱明细表
     * @param yljgdm	医疗机构代码
     * @param yzid	医嘱ID
     */
    @ApiOperation(value = "住院医嘱明细查询")
    @GetMapping("/getCisDradviceDetail")
    @RequiresPermissions("upms/cisDradviceDetail/getCisDradviceDetail")
    public ResultMap getCisDradviceDetail(String yljgdm, String yzid) {
        try {
            TbCisDradviceDetail cisDradviceDetail = iTbCisDradviceDetailService.getCisDradviceDetail(yljgdm, yzid);
            return ResultMap.ok().put("data",cisDradviceDetail);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
