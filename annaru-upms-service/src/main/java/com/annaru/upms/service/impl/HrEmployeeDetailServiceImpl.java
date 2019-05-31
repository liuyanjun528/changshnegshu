package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.HrEmployeeDetail;
import com.annaru.upms.mapper.HrEmployeeDetailMapper;
import com.annaru.upms.service.IHrEmployeeDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * HR员工详情
 *
 * @author wh
 * @date 2019-05-31 11:14:29
 */
@Service
public class HrEmployeeDetailServiceImpl extends ServiceImpl<HrEmployeeDetailMapper, HrEmployeeDetail> implements IHrEmployeeDetailService {




    @Override
    public List<HrEmployeeDetail> selectEmployeeDetail(String userId, Integer referenceNo) {
        return this.baseMapper.selectEmployeeDetail(userId,referenceNo);

    }
}
