package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbCisPrescriptionDetail;
import com.annaru.upms.entity.medical.vo.TbCisPrescriptionDetailListVo;
import com.annaru.upms.entity.medical.vo.TbCisPrescriptionDetailVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门诊处方明细表
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbCisPrescriptionDetailMapper extends BaseMapper<TbCisPrescriptionDetail> {

    /**
     *根据原主键获取对象
     * @param cyh
     * @param yzid
     * @param yljgdm
     * @return
     */
    TbCisPrescriptionDetail getCisPrescriptionDetail(@Param("cyh") String cyh, @Param("cfmxh") String yzid, @Param("yljgdm") String yljgdm);

    /**
     * 根据就诊流水号查询药品
     * @param jzlsh 就诊流水号
     * @return
     */
    List<TbCisPrescriptionDetailVo> getYp(@Param("jzlsh") String jzlsh);

    /**
     * 根据卡号查询药品
     * @param kh 卡号
     * @return
     */
    List<TbCisPrescriptionDetailListVo> getYyjl(@Param("kh") String kh);

    /**
     * 根据卡就诊流水号查询用药记录
     * @param jzlsh 就诊流水号
     * @return
     */
    TbCisPrescriptionDetailListVo getYyjlByJzlsh(String jzlsh);
}
