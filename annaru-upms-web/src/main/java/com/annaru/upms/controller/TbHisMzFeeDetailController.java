package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbHisMzFeeDetail;
import com.annaru.upms.service.ITbHisMzFeeDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * tb_his_mz_fee_detail(门诊收费明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"门诊收费明细管理"}, description = "门诊收费明细管理")
@RestController
@RequestMapping("upms/hisMzFeeDetail")
public class TbHisMzFeeDetailController extends BaseController {

    @Reference
    private ITbHisMzFeeDetailService iTbHisMzFeeDetailService;

    /**
     * 门诊收费明细表
     * @param sfmxid 收费明细ID
     * @param yzid	退费标志
     * @param yljgdm 医疗机构代码
     */
    @ApiOperation(value = "门诊收费明细查询")
    @GetMapping("/getHisMzFeeDetail")
    @RequiresPermissions("upms/hisMzFeeDetail/getHisMzFeeDetail")
    public ResultMap getHisMzFeeDetail(String sfmxid, String yzid, String yljgdm) {
        try {
            TbHisMzFeeDetail hisMzFeeDetail = iTbHisMzFeeDetailService.getHisMzFeeDetail(sfmxid, yzid, yljgdm);
            return ResultMap.ok().put("data",hisMzFeeDetail);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
