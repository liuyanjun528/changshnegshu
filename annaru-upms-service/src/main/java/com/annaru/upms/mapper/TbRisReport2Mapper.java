package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbRisReport2;
import com.annaru.upms.entity.medical.vo.TbRisReport2ListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * tb_ris_report2(影像检查报告表—通用格式)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbRisReport2Mapper extends BaseMapper<TbRisReport2> {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param studyuid	检查号
     * @param instanceuid 报告流水号
     * @return
     */
    TbRisReport2 getRisReport2(@Param("yljgdm") String yljgdm, @Param("studyuid") String studyuid, @Param("instanceuid") String instanceuid);

    /**
     * 根据卡号查询影像报告
     * @param kh 卡号
     * @return
     */
    List<TbRisReport2> getYxbg(@Param("kh") String kh);

    /**
     * 根据就诊流水号查询影像报告
     * @param jzlsh 就诊流水号
     * @return
     */
    List<TbRisReport2ListVo> getYxbgByJzlsh(@Param("jzlsh") String jzlsh);
}
