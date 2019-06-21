package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbCisDradviceDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 住院医嘱明细表
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbCisDradviceDetailMapper extends BaseMapper<TbCisDradviceDetail> {


    TbCisDradviceDetail getCisDradviceDetail(@Param("yljgdm") String yljgdm, @Param("yzid") String yzid);

}
