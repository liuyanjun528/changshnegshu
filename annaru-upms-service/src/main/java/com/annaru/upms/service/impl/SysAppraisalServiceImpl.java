package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysAppraisal;
import com.annaru.upms.mapper.SysAppraisalMapper;
import com.annaru.upms.service.ISysAppraisalService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * 家庭医生评分
 *
 * @author xck
 * @date 2019-05-22 11:33:58
 */
@Service
public class SysAppraisalServiceImpl extends ServiceImpl<SysAppraisalMapper, SysAppraisal> implements ISysAppraisalService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysAppraisal> page = new PageUtils<SysAppraisal>(params).getPage();
        IPage<SysAppraisal> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysAppraisal>(iPage);
    }

    @Override
    public List<SysAppraisal> selectStart(String userId) {
        return this.baseMapper.selectStart(userId);
    }

}
