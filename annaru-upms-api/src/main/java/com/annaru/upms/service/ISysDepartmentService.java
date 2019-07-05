package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysDepartment;
import com.annaru.upms.entity.vo.SysDepartmentVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 科室
 *
 * @author xck
 * @date 2019-05-10 10:44:18
 */
public interface ISysDepartmentService extends IService<SysDepartment> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    List<SysDepartmentVo> getDepartmentCommonList(Map<String, Object> params);

    List<SysDepartment> getFrequentUsedList(Map<String, Object> params);
}

