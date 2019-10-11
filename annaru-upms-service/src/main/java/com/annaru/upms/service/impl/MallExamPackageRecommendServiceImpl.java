package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.MallExamPackageRecommendExtends;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.MallExamPackageRecommendMapper;
import com.annaru.upms.entity.MallExamPackageRecommend;
import com.annaru.upms.service.IMallExamPackageRecommendService;

import java.util.List;
import java.util.Map;

/**
 * 商城推荐产品
 *
 * @author zk
 * @date 2019-10-10 13:11:23
 */
@Service
public class MallExamPackageRecommendServiceImpl extends ServiceImpl<MallExamPackageRecommendMapper, MallExamPackageRecommend> implements IMallExamPackageRecommendService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<MallExamPackageRecommend> page = new PageUtils<MallExamPackageRecommend>(params).getPage();
        IPage<MallExamPackageRecommend> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<MallExamPackageRecommend>(iPage);
    }

    @Override
    public List<MallExamPackageRecommendExtends> selectAll() {
        return this.baseMapper.selectAll();
    }

}
