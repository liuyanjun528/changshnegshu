package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbHisMzFeeDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * tb_his_mz_fee_detail(门诊收费明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbHisMzFeeDetailMapper extends BaseMapper<TbHisMzFeeDetail> {


    TbHisMzFeeDetail getHisMzFeeDetail(@Param("sfmxid") String sfmxid, @Param("xgbz") String xgbz, @Param("yljgdm") String yljgdm);

}
