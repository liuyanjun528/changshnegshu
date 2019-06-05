package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserRelatives;
import com.annaru.upms.mapper.UserRelativesMapper;
import com.annaru.upms.service.IUserRelativesService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * 用户亲属信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class UserRelativesServiceImpl extends ServiceImpl<UserRelativesMapper, UserRelatives> implements IUserRelativesService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserRelatives> page = new PageUtils<UserRelatives>(params).getPage();
        IPage<UserRelatives> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserRelatives>(iPage);
    }

    @Override
    public List<UserRelatives> selectAll(String userId) {
        return this.baseMapper.selectAll(userId);
    }

}
