package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbLisBacteriaResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * tb_lis_bacteria_result(细菌结果表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbLisBacteriaResultMapper extends BaseMapper<TbLisBacteriaResult> {


    TbLisBacteriaResult getLisBacteriaResult(@Param("yljgdm") String yljgdm, @Param("xjjglsh") String xjjglsh);

}
