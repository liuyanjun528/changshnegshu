package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbHisZyFeeDetailFs;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * tb_his_zy_fee_detail_fs(住院费用发生明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbHisZyFeeDetailFsService extends IService<TbHisZyFeeDetailFs> {

    TbHisZyFeeDetailFs getHisZyFeeDetailFs(String yljgdm, String mxfsid, String xgbz);
}

