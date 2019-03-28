package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.Call;
import com.annaru.upms.mapper.CallMapper;
import com.annaru.upms.service.ICallService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @author wh
 * @date 2019-03-26 09:58:57
 */
@Service
public class CallServiceImpl extends ServiceImpl<CallMapper, Call> implements ICallService {


    @Override
    public List<Call> getCallListByMysql() {
        return this.baseMapper.selectCallByMysql();
    }

    @Override
    public List<Call> getCallListByOracle() {
        return this.baseMapper.selectCallByOracle();
    }


}
