package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbHisZyFeeDetail;
import com.annaru.upms.mapper.TbHisZyFeeDetailMapper;
import com.annaru.upms.service.ITbHisZyFeeDetailService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * tb_his_mz_fee_detail(门诊收费明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbHisZyFeeDetailServiceImpl extends ServiceImpl<TbHisZyFeeDetailMapper, TbHisZyFeeDetail> implements ITbHisZyFeeDetailService {


    @Override
    @DS("oracle")
    public TbHisZyFeeDetail getHisZyFeeDetail(String yljgdm, String sfmxid, String xgbz) {
        return this.baseMapper.getHisZyFeeDetail(yljgdm, sfmxid, xgbz);
    }

}
