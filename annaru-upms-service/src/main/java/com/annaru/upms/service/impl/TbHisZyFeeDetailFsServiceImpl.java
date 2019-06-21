package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbHisZyFeeDetailFs;
import com.annaru.upms.mapper.TbHisZyFeeDetailFsMapper;
import com.annaru.upms.service.ITbHisZyFeeDetailFsService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * tb_his_zy_fee_detail_fs(住院费用发生明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbHisZyFeeDetailFsServiceImpl extends ServiceImpl<TbHisZyFeeDetailFsMapper, TbHisZyFeeDetailFs> implements ITbHisZyFeeDetailFsService {


    @Override
    @DS("oracle")
    public TbHisZyFeeDetailFs getHisZyFeeDetailFs(String yljgdm, String mxfsid, String xgbz) {
        return this.baseMapper.getHisZyFeeDetailFs(yljgdm, mxfsid, xgbz);
    }

}
