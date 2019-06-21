package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbHisZyFeeDetailFs;
import com.annaru.upms.service.ITbHisZyFeeDetailFsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * tb_his_zy_fee_detail_fs(住院费用发生明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"住院费用发生明细管理"}, description = "住院费用发生明细管理")
@RestController
@RequestMapping("upms/hisZyFeeDetailFs")
public class TbHisZyFeeDetailFsController extends BaseController {

    @Reference
    private ITbHisZyFeeDetailFsService iTbHisZyFeeDetailFsService;

    /**
     * 住院费用结算明细表
     * @param yljgdm 医疗机构代码
     * @param mxfsid 费用发生明细ID
     * @param xgbz 退费标志
     */
    @ApiOperation(value = "住院费用发生明细查询")
    @GetMapping("/getHisZyFeeDetailFs")
    @RequiresPermissions("upms/hisZyFeeDetailFs/getHisZyFeeDetailFs")
    public ResultMap getHisZyFeeDetailFs(String yljgdm, String mxfsid, String xgbz) {
        try {
            TbHisZyFeeDetailFs hisZyFeeDetailFs = iTbHisZyFeeDetailFsService.getHisZyFeeDetailFs(yljgdm, mxfsid, xgbz);
            return ResultMap.ok().put("data",hisZyFeeDetailFs);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
