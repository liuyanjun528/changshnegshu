package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbCisDradviceDetail;
import com.annaru.upms.mapper.TbCisDradviceDetailMapper;
import com.annaru.upms.service.ITbCisDradviceDetailService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 住院医嘱明细表
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbCisDradviceDetailServiceImpl extends ServiceImpl<TbCisDradviceDetailMapper, TbCisDradviceDetail> implements ITbCisDradviceDetailService {


    @Override
    @DS("oracle")
    public TbCisDradviceDetail getCisDradviceDetail(String yljgdm, String yzid) {
        return this.baseMapper.getCisDradviceDetail(yljgdm, yzid);
    }

}
