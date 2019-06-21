package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbLisIndicators;
import com.annaru.upms.mapper.TbLisIndicatorsMapper;
import com.annaru.upms.service.ITbLisIndicatorsService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * tb_lis_indicators(检验结果指标表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbLisIndicatorsServiceImpl extends ServiceImpl<TbLisIndicatorsMapper, TbLisIndicators> implements ITbLisIndicatorsService {

    @Override
    @DS("oracle")
    public TbLisIndicators getLisIndicators(String yljgdm, String jyzblsh) {
        return this.baseMapper.getLisIndicators(yljgdm, jyzblsh);
    }

    @Override
    @DS("oracle")
    public List<TbLisIndicators> getJybg(String bgdh) {
        return this.baseMapper.getJybg(bgdh);
    }


}
