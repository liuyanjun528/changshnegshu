package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.mapper.LcdShowMapper;
import com.annaru.upms.service.ILcdShowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;

/**
 * @author wh
 * @date 2019-03-29 11:33:31
 */
@Service
public class LcdShowServiceImpl extends ServiceImpl<LcdShowMapper, LcdShow> implements ILcdShowService {

    @Override
    public List<LcdShow> getLcdShowListByMysql() {
        return this.baseMapper.selectLcdShowByMysql();
    }

    @Override
    public List<LcdShow> getLcdShowListBySqlServer() {
        return this.baseMapper.selectLcdShowBySqlServer();
    }


}
