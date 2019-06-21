package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbCisPrescriptionDetail;
import com.annaru.upms.entity.medical.vo.TbCisPrescriptionDetailListVo;
import com.annaru.upms.entity.medical.vo.TbCisPrescriptionDetailVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * tb_cis_prescription_detail(门诊处方明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbCisPrescriptionDetailService extends IService<TbCisPrescriptionDetail> {

    TbCisPrescriptionDetail getCisPrescriptionDetail(String cyh, String yzid, String yljgdm);

    /**
     * 根据就诊流水号查询药品
     * @param jzlsh 就诊流水号
     * @return
     */
    List<TbCisPrescriptionDetailVo> getYp(String jzlsh);

    /**
     * 根据卡号查询药品
     * @param kh 卡号
     * @return
     */
    List<TbCisPrescriptionDetailListVo> getYyjl(String kh);

    /**
     * 根据就诊流水号查询用药记录
     * @param jzlsh 就诊流水号
     * @return
     */
    TbCisPrescriptionDetailListVo getYyjlByJzlsh(String jzlsh);

}

