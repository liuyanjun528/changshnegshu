package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbHisMzFeeDetail;
import com.annaru.upms.mapper.TbHisMzFeeDetailMapper;
import com.annaru.upms.service.ITbHisMzFeeDetailService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * tb_his_mz_fee_detail(门诊收费明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbHisMzFeeDetailServiceImpl extends ServiceImpl<TbHisMzFeeDetailMapper, TbHisMzFeeDetail> implements ITbHisMzFeeDetailService {


    @Override
    @DS("oracle")
    public TbHisMzFeeDetail getHisMzFeeDetail(String sfmxid, String xgbz, String yljgdm) {
        return this.baseMapper.getHisMzFeeDetail(sfmxid, xgbz, yljgdm);
    }

}
