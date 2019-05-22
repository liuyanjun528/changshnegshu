package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysAppraisal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 家庭医生评分
 *
 * @author xck
 * @date 2019-05-22 11:33:58
 */
public interface ISysAppraisalService extends IService<SysAppraisal> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

