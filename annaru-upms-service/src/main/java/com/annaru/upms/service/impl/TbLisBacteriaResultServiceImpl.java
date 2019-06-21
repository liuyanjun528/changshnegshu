package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbLisBacteriaResult;
import com.annaru.upms.mapper.TbLisBacteriaResultMapper;
import com.annaru.upms.service.ITbLisBacteriaResultService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * tb_lis_bacteria_result(细菌结果表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbLisBacteriaResultServiceImpl extends ServiceImpl<TbLisBacteriaResultMapper, TbLisBacteriaResult> implements ITbLisBacteriaResultService {

    @Override
    @DS("oracle")
    public TbLisBacteriaResult getLisBacteriaResult(String yljgdm, String xjjglsh) {
        return this.baseMapper.getLisBacteriaResult(yljgdm, xjjglsh);
    }

}
