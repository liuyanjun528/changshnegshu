package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamHpvAgreement;
import java.util.List;
import java.util.Map;

/**
 * HPV条款
 *
 * @author wh
 * @date 2019-10-11 09:35:38
 */
public interface IExamHpvAgreementService extends IService<ExamHpvAgreement> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

