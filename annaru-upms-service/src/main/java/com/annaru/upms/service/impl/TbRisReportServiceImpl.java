package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.medical.TbRisReport;
import com.annaru.upms.entity.medical.vo.TbRisReportDetailVo;
import com.annaru.upms.entity.medical.vo.TbRisReportListVo;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordListVo;
import com.annaru.upms.mapper.TbRisReportMapper;
import com.annaru.upms.service.ITbRisReportService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * tb_ris_report(影像检查报告表—放射类格式)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbRisReportServiceImpl extends ServiceImpl<TbRisReportMapper, TbRisReport> implements ITbRisReportService {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param studyuid	检查号
     * @param instanceuid 报告流水号
     * @return
     */
    @Override
    @DS("oracle")
    public TbRisReport getRisReport(String yljgdm, String studyuid, String instanceuid) {
        return this.baseMapper.getRisReport(yljgdm, studyuid, instanceuid);
    }

    /**
     * 根据卡号分页查询影像检查报告表
     * @param params
     * @return
     */
    @Override
    @DS("oracle")
    public PageUtils getYxbgPage(Map<String, Object> params){
        Page<TbRisReportListVo> page = new PageUtils<TbRisReportListVo>(params).getPage();
        IPage<TbRisReportListVo> iPage = this.baseMapper.getYxbgPage(page, params);
        return new PageUtils<TbRisReportListVo>(iPage);
    }

    /**
     * 根据卡号查询影像报告
     * @param kh 卡号
     * @return
     */
    @Override
    @DS("oracle")
    public List<TbRisReportListVo> getYxbg(String kh) {
        return this.baseMapper.getYxbg(kh);
    }

    /**
     * 根据影像检查报告ID查询影像报告
     * @param csid 影像检查报告ID
     * @return
     */
    @Override
    @DS("oracle")
    public  TbRisReportDetailVo getYxbgDetail(String csid) {
        return this.baseMapper.getYxbgDetail(csid);
    }

    /**
     * 根据就诊流水号查询影像报告
     * @param jzlsh 就诊流水号
     * @return
     */
    @Override
    @DS("oracle")
    public List<TbRisReportListVo> getYxbgByJzlsh(String jzlsh) {
        return this.baseMapper.getYxbgByJzlsh(jzlsh);
    }
}
