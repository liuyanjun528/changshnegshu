package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityHealthyAppraisalMainMapper;
import com.annaru.upms.entity.EntityHealthyAppraisalMain;
import com.annaru.upms.service.IEntityHealthyAppraisalMainService;

import java.util.List;
import java.util.Map;

/**
 * 企业健康评估主表
 *
 * @author xck
 * @date 2019-05-30 13:28:09
 */
@Service
public class EntityHealthyAppraisalMainServiceImpl extends ServiceImpl<EntityHealthyAppraisalMainMapper, EntityHealthyAppraisalMain> implements IEntityHealthyAppraisalMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityHealthyAppraisalMain> page = new PageUtils<EntityHealthyAppraisalMain>(params).getPage();
        IPage<EntityHealthyAppraisalMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityHealthyAppraisalMain>(iPage);
    }

}
