package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.constants.TopupCardEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysTopupCardFormularMapper;
import com.annaru.upms.entity.SysTopupCardFormular;
import com.annaru.upms.service.ISysTopupCardFormularService;

import java.util.List;
import java.util.Map;

/**
 * 卡规则
 *
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
@Service
public class SysTopupCardFormularServiceImpl extends ServiceImpl<SysTopupCardFormularMapper, SysTopupCardFormular> implements ISysTopupCardFormularService {

    @Override
    public List<SysTopupCardFormular> listFormular(int cates) {
        QueryWrapper<SysTopupCardFormular> qw = new QueryWrapper<>();
        qw.eq("cates", cates);
        qw.eq("is_active", TopupCardEnum.CardIsActive.ACTIVE.getValue());
        qw.select("sys_id","descr");
        qw.orderByAsc("seq_no");
        return this.baseMapper.selectList(qw);
    }
}
