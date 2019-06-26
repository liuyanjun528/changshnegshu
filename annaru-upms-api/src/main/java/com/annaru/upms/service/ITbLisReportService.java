package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.medical.TbLisReport;
import com.annaru.upms.entity.medical.vo.TbLisReportDetailVo;
import com.annaru.upms.entity.medical.vo.TbLisReportListVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * tb_lis_indicators(实验室检验报告表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbLisReportService extends IService<TbLisReport> {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param bgdh	检验报告单号
     * @param bgrq	报告日期
     * @return
     */
    TbLisReport getLisReport(String yljgdm, String bgdh, String bgrq);

    /**
     * 根据卡号分页查询检验报告
     * @param params
     * @return
     */
    PageUtils getJybgPage(Map<String, Object> params);

    /**
     * 根据卡号查询检验报告
     * @param kh 卡号
     * @return
     */
    List<TbLisReportListVo> getJybg(String kh);

    /**
     * 根据就诊流水号查询检验报告
     * @param jzlsh 就诊流水号
     * @return
     */
    List<TbLisReportDetailVo> getJybgByJzlsh(String jzlsh);

    /**
     * 根据报告单号查询检验报告
     * @param bgdh 报告单号
     * @return
     */
    TbLisReport getJybgByBgdh(String bgdh);
}

