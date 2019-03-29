package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.Call;
import com.annaru.upms.mapper.LcdShowMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.service.ILcdShowService;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wh
 * @date 2019-03-29 11:33:31
 */
@Service
public class LcdShowServiceImpl extends ServiceImpl<LcdShowMapper, LcdShow> implements ILcdShowService {

    @Override
    public List<Call> getCallListByMysql() {
        return this.baseMapper.selectCallByMysql();
    }

    @Override
    public List<Call> getCallListByOracle() {
        return this.baseMapper.selectCallByOracle();
    }

}
