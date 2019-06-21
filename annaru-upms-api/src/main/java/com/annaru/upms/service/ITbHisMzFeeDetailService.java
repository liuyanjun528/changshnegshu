package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbHisMzFeeDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * tb_his_mz_fee_detail(门诊收费明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbHisMzFeeDetailService extends IService<TbHisMzFeeDetail> {

    TbHisMzFeeDetail getHisMzFeeDetail(String sfmxid,String xgbz,String yljgdm);
}

