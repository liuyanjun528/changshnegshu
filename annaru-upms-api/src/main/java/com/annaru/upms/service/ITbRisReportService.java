package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbRisReport;
import com.annaru.upms.entity.medical.vo.TbRisReportListVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * tb_ris_report(影像检查报告表—放射类格式)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbRisReportService extends IService<TbRisReport> {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param studyuid	检查号
     * @param instanceuid 报告流水号
     * @return
     */
    TbRisReport getRisReport(String yljgdm, String studyuid, String instanceuid);

    /**
     * 根据卡号查询影像报告
     * @param kh 卡号
     * @return
     */
    List<TbRisReportListVo> getYxbg(String kh);

    /**
     * 根据就诊流水号查询影像报告
     * @param jzlsh 就诊流水号
     * @return
     */
    List<TbRisReportListVo> getYxbgByJzlsh(String jzlsh);
}

