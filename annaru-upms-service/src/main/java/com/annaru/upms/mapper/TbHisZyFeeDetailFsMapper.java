package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbHisZyFeeDetailFs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * tb_his_zy_fee_detail_fs(住院费用发生明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbHisZyFeeDetailFsMapper extends BaseMapper<TbHisZyFeeDetailFs> {


    TbHisZyFeeDetailFs getHisZyFeeDetailFs(@Param("yljgdm") String yljgdm, @Param("mxfsid") String mxfsid, @Param("xgbz") String xgbz);

}
