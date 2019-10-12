package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamHpvCategory;
import java.util.List;
import java.util.Map;

/**
 * HPV产品类别
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
public interface IExamHpvCategoryService extends IService<ExamHpvCategory> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

