package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbLisAllergyResult;
import com.annaru.upms.mapper.TbLisAllergyResultMapper;
import com.annaru.upms.service.ITbLisAllergyResultService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * tb_lis_allergy_result(药敏结果表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbLisAllergyResultServiceImpl extends ServiceImpl<TbLisAllergyResultMapper, TbLisAllergyResult> implements ITbLisAllergyResultService {

    @Override
    @DS("oracle")
    public TbLisAllergyResult getLisAllergyResult(String yljgdm, String ymjglsh) {
        return this.baseMapper.getLisAllergyResult(yljgdm, ymjglsh);
    }

}
