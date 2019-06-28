package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysDepartment;
import com.annaru.upms.entity.vo.SysDepartmentVo;
import com.annaru.upms.mapper.SysDepartmentMapper;
import com.annaru.upms.service.ISysDepartmentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * 科室
 *
 * @author xck
 * @date 2019-05-10 10:44:18
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements ISysDepartmentService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysDepartment> page = new PageUtils<SysDepartment>(params).getPage();
        IPage<SysDepartment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysDepartment>(iPage);
    }

    @Override
    public List<SysDepartmentVo> getDepartmentCommonList(Map<String, Object> params){
        return this.baseMapper.getDepartmentCommonList(params);
    }

    public List<SysDepartment> getFrequentUsedList(Map<String, Object> params){
        return this.baseMapper.getFrequentUsedList(params);
    }

}
