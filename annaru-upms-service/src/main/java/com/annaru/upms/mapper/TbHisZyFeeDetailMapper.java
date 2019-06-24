package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbHisZyFeeDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * tb_his_zy_fee_detail(住院费用结算明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbHisZyFeeDetailMapper extends BaseMapper<TbHisZyFeeDetail> {


    TbHisZyFeeDetail getHisZyFeeDetail(@Param("yljgdm") String yljgdm, @Param("sfmxid") String sfmxid, @Param("xgbz") String xgbz);

}
