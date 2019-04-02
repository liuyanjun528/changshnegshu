package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.LcdShow;
import com.annaru.upms.mapper.LcdShowMapper;
import com.annaru.upms.service.ILcdShowService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author wh
 * @date 2019-03-29 11:33:31
 */
@Service
public class LcdShowServiceImpl extends ServiceImpl<LcdShowMapper, LcdShow> implements ILcdShowService {


    @Override
    public void updateByXpdz(LcdShow lcdShow) {
        if(StringUtils.isBlank(lcdShow.getXpdz())){
            return;
        }
        this.baseMapper.updateByXpdz(lcdShow);
        System.out.println("=====================>我更新了");
    }

    @Override
    public LcdShow getByXpdz(String xpdz) {
        if (StringUtils.isBlank(xpdz)) {
            return null;
        }
        return this.baseMapper.selectByXpdz(xpdz);
    }

    @Override
    public List<LcdShow> getLcdShowListByMysql() {
        return this.baseMapper.selectLcdShowByMysql();
    }

    @Override
    public List<LcdShow> getLcdShowListBySqlServer() {
        return this.baseMapper.selectLcdShowBySqlServer();
    }


}
