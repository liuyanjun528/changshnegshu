package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.medical.TbLisReport;
import com.annaru.upms.entity.medical.vo.TbLisReportDetailVo;
import com.annaru.upms.entity.medical.vo.TbLisReportListVo;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordListVo;
import com.annaru.upms.mapper.TbLisReportMapper;
import com.annaru.upms.service.ITbLisReportService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * tb_lis_indicators(实验室检验报告表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbLisReportServiceImpl extends ServiceImpl<TbLisReportMapper, TbLisReport> implements ITbLisReportService {

    @Override
    @DS("oracle")
    public TbLisReport getLisReport(String yljgdm, String bgdh, String bgrq) {
        return this.baseMapper.getLisReport(yljgdm, bgdh, bgrq);
    }

    /**
     * 根据卡号分页查询检验报告
     * @param params
     * @return
     */
    @Override
    @DS("oracle")
    public PageUtils getJybgPage(Map<String, Object> params){
        Page<TbLisReportListVo> page = new PageUtils<TbLisReportListVo>(params).getPage();
        IPage<TbLisReportListVo> iPage = this.baseMapper.getJybgPage(page, params);
        return new PageUtils<TbLisReportListVo>(iPage);
    }

    @Override
    @DS("oracle")
    public List<TbLisReportListVo> getJybg(String bgdh) {
        return this.baseMapper.getJybg(bgdh);
    }

    @Override
    @DS("oracle")
    public List<TbLisReportListVo> getJybgByJzlsh(String jzlsh) {
        return this.baseMapper.getJybgByJzlsh(jzlsh);
    }

    @Override
    @DS("oracle")
    public TbLisReportDetailVo getJybgByJzlshAndBgdh(String jzlsh, String bgdh) {
        return this.baseMapper.getJybgByJzlshAndBgdh(jzlsh, bgdh);
    }

    @Override
    @DS("oracle")
    public TbLisReport getJybgByBgdh(String bgdh) {
        return this.baseMapper.getJybgByBgdh(bgdh);
    }


}
