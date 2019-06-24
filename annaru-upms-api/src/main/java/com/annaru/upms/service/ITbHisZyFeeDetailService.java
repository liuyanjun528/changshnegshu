package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbHisZyFeeDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * tb_his_zy_fee_detail(住院费用结算明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbHisZyFeeDetailService extends IService<TbHisZyFeeDetail> {

    TbHisZyFeeDetail getHisZyFeeDetail(String yljgdm, String sfmxid, String xgbz);
}

