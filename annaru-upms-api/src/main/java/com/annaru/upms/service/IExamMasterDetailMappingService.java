package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamMasterDetailMapping;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 体检项目主附关联表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
public interface IExamMasterDetailMappingService extends IService<ExamMasterDetailMapping> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

