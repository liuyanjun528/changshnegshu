package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCatesMasterMapping;
import java.util.List;
import java.util.Map;

/**
 * 体检类别与主检项目关联表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
public interface IExamCatesMasterMappingService extends IService<ExamCatesMasterMapping> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map <String, Object> params);


}

