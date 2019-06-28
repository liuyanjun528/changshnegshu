package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysSubDepartment;
import java.util.List;
import java.util.Map;

/**
 * 二级科室(预约)
 *
 * @author xck
 * @date 2019-06-27 16:05:36
 */
public interface ISysSubDepartmentService extends IService<SysSubDepartment> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

