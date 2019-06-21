package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbLisBacteriaResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * tb_lis_bacteria_result(细菌结果表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbLisBacteriaResultService extends IService<TbLisBacteriaResult> {

    TbLisBacteriaResult getLisBacteriaResult(String yljgdm, String xjjglsh);
}

