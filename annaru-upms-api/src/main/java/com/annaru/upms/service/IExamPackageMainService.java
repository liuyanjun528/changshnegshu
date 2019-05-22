package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamPackageMain;
import java.util.List;
import java.util.Map;

/**
 * 套餐
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface IExamPackageMainService extends IService<ExamPackageMain> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils selectDataPageZ(Map <String, Object> params);

    /**
     * 根据套餐编号查询套餐详情
     * @param params
     * @return
     */
    List<ExamPackageMain> selectInfoBySysId(Map <String, Object> params);


}

