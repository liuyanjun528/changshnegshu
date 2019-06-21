package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbHisZyFeeDetail;
import com.annaru.upms.service.ITbHisZyFeeDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * tb_his_zy_fee_detail(住院费用结算明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"住院费用结算明细管理"}, description = "住院费用结算明细管理")
@RestController
@RequestMapping("upms/hisZyFeeDetail")
public class TbHisZyFeeDetailController extends BaseController {

    @Reference
    private ITbHisZyFeeDetailService iTbHisZyFeeDetailService;

    /**
     * 住院费用结算明细表
     * @param yljgdm 医疗机构代码
     * @param sfmxid 收费明细ID
     * @param xgbz 退费标志
     */
    @ApiOperation(value = "住院费用结算明细查询")
    @GetMapping("/getHisZyFeeDetail")
    @RequiresPermissions("upms/hisMzFeeDetail/getHisZyFeeDetail")
    public ResultMap getHisZyFeeDetail(String yljgdm, String sfmxid, String xgbz) {
        try {
            TbHisZyFeeDetail hisZyFeeDetail = iTbHisZyFeeDetailService.getHisZyFeeDetail(yljgdm, sfmxid, xgbz);
            return ResultMap.ok().put("data",hisZyFeeDetail);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
