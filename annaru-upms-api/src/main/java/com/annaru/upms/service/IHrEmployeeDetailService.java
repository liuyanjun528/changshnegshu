package com.annaru.upms.service;

import com.annaru.upms.entity.vo.HrEmployeeDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * HR员工详情
 *
 * @author wh
 * @date 2019-05-31 12:06:42
 */
public interface IHrEmployeeDetailService extends IService<HrEmployeeDetail> {

    /**
     * 查询HR员工详情
     * @param userId
     * @return
     */
    List<HrEmployeeDetail> selectEmployeeDetail(String userId, Integer referenceNo);

}

