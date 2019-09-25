package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbLisReport;
import com.annaru.upms.entity.medical.vo.TbLisReportDetailVo;
import com.annaru.upms.entity.medical.vo.TbLisReportListVo;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * tb_lis_report(实验室检验报告表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbLisReportMapper extends BaseMapper<TbLisReport> {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param bgdh	检验报告单号
     * @param bgrq	报告日期
     * @return
     */
    TbLisReport getLisReport(@Param("yljgdm") String yljgdm, @Param("bgdh") String bgdh, @Param("bgrq") String bgrq);

    /**
     * 根据卡号分页查询检验报告
     * @param params
     * @return
     */
    IPage<TbLisReportListVo> getJybgPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 根据卡号查询检验报告
     * @param kh 卡号
     * @return
     */
    List<TbLisReportListVo> getJybg(@Param("kh") String kh);

    /**
     *根据就诊流水号和报告单号查询检验报告
     * @param jzlsh 就诊流水号
     *@param jzlsh 报告单号
     * @return
     */
    TbLisReportDetailVo getJybgByJzlshAndBgdh(@Param("jzlsh") String jzlsh, @Param("bgdh") String bgdh);

    /**
     *根据就诊流水号查询检验报告
     * @param jzlsh 就诊流水号
     * @return
     */
    List<TbLisReportListVo> getJybgByJzlsh(@Param("jzlsh") String jzlsh);

    /**
     *根据报告单号查询检验报告
     * @param bgdh 报告单号
     * @return
     */
    TbLisReport getJybgByBgdh(@Param("bgdh") String bgdh);
}
