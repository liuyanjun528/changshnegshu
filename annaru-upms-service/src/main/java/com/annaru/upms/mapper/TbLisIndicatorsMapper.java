package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbLisIndicators;
import com.annaru.upms.entity.medical.vo.TbLisIndicatorsListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * tb_lis_indicators(检验结果指标表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbLisIndicatorsMapper extends BaseMapper<TbLisIndicators> {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     *@param jyzblsh 检验指标流水号
     * @return
     */
    TbLisIndicators getLisIndicators(@Param("yljgdm") String yljgdm, @Param("jyzblsh") String jyzblsh);

    /**
     * 根据检验报告单号查询检验结果
     * @param bgdh
     * @return
     */
    List<TbLisIndicatorsListVo> getJybg(String bgdh);

}
