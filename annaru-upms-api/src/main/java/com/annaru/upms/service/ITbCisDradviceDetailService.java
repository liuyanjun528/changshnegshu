package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbCisDradviceDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * tb_cis_dradvice_detail(住院医嘱明细表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbCisDradviceDetailService extends IService<TbCisDradviceDetail> {

    TbCisDradviceDetail getCisDradviceDetail(String yljgdm, String yzid);
}

