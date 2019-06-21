package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbLisAllergyResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * tb_lis_allergy_result(药敏结果表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbLisAllergyResultService extends IService<TbLisAllergyResult> {

    TbLisAllergyResult getLisAllergyResult(String yljgdm, String ymjglsh);
}

