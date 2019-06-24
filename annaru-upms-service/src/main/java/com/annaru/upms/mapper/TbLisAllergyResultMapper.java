package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbLisAllergyResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * tb_lis_allergy_result(药敏结果表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbLisAllergyResultMapper extends BaseMapper<TbLisAllergyResult> {


    TbLisAllergyResult getLisAllergyResult(@Param("yljgdm") String yljgdm, @Param("ymjglsh") String ymjglsh);

}
