package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.medical.TbCisPrescriptionDetail;
import com.annaru.upms.entity.medical.vo.TbCisPrescriptionDetailListVo;
import com.annaru.upms.entity.medical.vo.TbCisPrescriptionDetailVo;
import com.annaru.upms.entity.medical.vo.TbRisReportListVo;
import com.annaru.upms.mapper.TbCisPrescriptionDetailMapper;
import com.annaru.upms.service.ITbCisPrescriptionDetailService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * 门诊处方明细表
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbCisPrescriptionDetailServiceImpl extends ServiceImpl<TbCisPrescriptionDetailMapper, TbCisPrescriptionDetail> implements ITbCisPrescriptionDetailService {


    @Override
    @DS("oracle")
    public TbCisPrescriptionDetail getCisPrescriptionDetail(String cyh, String yzid, String yljgdm) {
        return this.baseMapper.getCisPrescriptionDetail(cyh, yzid, yljgdm);
    }

    /**
     * 根据就诊流水号查询药品
     * @param jzlsh 就诊流水号
     * @return
     */
    @Override
    @DS("oracle")
    public List<TbCisPrescriptionDetailVo> getYp(String jzlsh) {
         return this.baseMapper.getYp(jzlsh);
    }

    /**
     * 根据卡号分页查询药品
     * @param params
     * @return
     */
    @Override
    @DS("oracle")
    public PageUtils getYyjlPage(Map<String, Object> params){
        Page<TbCisPrescriptionDetailListVo> page = new PageUtils<TbCisPrescriptionDetailListVo>(params).getPage();
        IPage<TbCisPrescriptionDetailListVo> iPage = this.baseMapper.getYyjlPage(page, params);
        return new PageUtils<TbCisPrescriptionDetailListVo>(iPage);
    }

    /**
     * 根据卡号查询药品
     * @param kh 卡号
     * @return
     */
    @Override
    @DS("oracle")
    public List<TbCisPrescriptionDetailListVo> getYyjl(String kh) {
        return this.baseMapper.getYyjl(kh);
    }

    /**
     * 根据卡就诊流水号查询用药记录
     * @param jzlsh 就诊流水号
     * @return
     */
    @Override
    @DS("oracle")
    public TbCisPrescriptionDetailListVo getYyjlByJzlsh(String jzlsh) {
        return this.baseMapper.getYyjlByJzlsh(jzlsh);
    }

}
