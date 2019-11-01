package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.ResultMap;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysTopupCardCateMapper;
import com.annaru.upms.entity.SysTopupCardCate;
import com.annaru.upms.service.ISysTopupCardCateService;

import java.util.List;
import java.util.Map;

/**
 * 充值\套餐卡类别
 *
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
@Service
public class SysTopupCardCateServiceImpl extends ServiceImpl<SysTopupCardCateMapper, SysTopupCardCate> implements ISysTopupCardCateService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params) {
        Page<SysTopupCardCate> page = new PageUtils<SysTopupCardCate>(params).getPage();
        IPage<SysTopupCardCate> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysTopupCardCate>(iPage);
    }

    @Override
    public SysTopupCardCate detail(int sysId) {
        QueryWrapper<SysTopupCardCate> qw = new QueryWrapper<>();
        qw.eq("sys_id", sysId);
        qw.select("sys_id", "image_url", "title", "sub_title");
        return this.baseMapper.selectOne(qw);
    }

    @Override
    public ResultMap activation(String serialNo, String activepin) {
        try {
            int count = this.baseMapper.activation(serialNo, activepin);
            if (count > 0) {
                return ResultMap.ok("激活成功");
            } else {
                return ResultMap.error("激活失败");
            }
        } catch (Exception e) {
            return ResultMap.error();
        }


    }

}
