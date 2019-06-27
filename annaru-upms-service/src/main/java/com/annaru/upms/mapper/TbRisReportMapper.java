package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbRisReport;
import com.annaru.upms.entity.medical.vo.TbRisReportListVo;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * tb_ris_report(影像检查报告表—放射类格式)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbRisReportMapper extends BaseMapper<TbRisReport> {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param studyuid	检查号
     * @param instanceuid 报告流水号
     * @return
     */
    TbRisReport getRisReport(@Param("yljgdm") String yljgdm, @Param("studyuid") String studyuid, @Param("instanceuid") String instanceuid);

    /**
     * 根据卡号分页查询影像检查报告
     * @param params
     * @return
     */
    IPage<TbRisReportListVo> getYxbgPage(Page page, @Param("params") Map<String, Object> params);


    /**
     * 根据卡号查询影像报告
     * @param kh 卡号
     * @return
     */
    List<TbRisReportListVo> getYxbg(@Param("kh") String kh);

    /**
     * 根据就诊流水号查询影像报告
     * @param jzlsh 就诊流水号
     * @return
     */
    List<TbRisReportListVo> getYxbgByJzlsh(@Param("jzlsh") String jzlsh);
}
