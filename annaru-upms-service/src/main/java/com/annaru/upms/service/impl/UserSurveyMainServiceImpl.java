package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.vo.UserSurveyMainVo;
import com.annaru.upms.entity.vo.UserSurveyVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;

import com.annaru.upms.mapper.UserSurveyMainMapper;
import com.annaru.upms.entity.UserSurveyMain;
import com.annaru.upms.service.IUserSurveyMainService;

import java.util.List;
import java.util.Map;

/**
 * 用户问券调查
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
@Service
public class UserSurveyMainServiceImpl extends ServiceImpl<UserSurveyMainMapper, UserSurveyMain> implements IUserSurveyMainService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserSurveyMain> page = new PageUtils<UserSurveyMain>(params).getPage();
        IPage<UserSurveyMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserSurveyMain>(iPage);
    }

    public UserSurveyVo getByUserId(Map<String,Object> params){
        return this.baseMapper.getByUserId(params);
    }

    @Override
    public UserSurveyMain getTimeByUserIdZ(Map<String,Object> params) {
        return this.baseMapper.getTimeByUserIdZ(params);
    }

    @Override
    public int selectCount(String userId) {
        return this.baseMapper.selectCount(userId);
    }

    public int saveOne(UserSurveyMain userSurveyMain){
         this.baseMapper.insert(userSurveyMain);
         return userSurveyMain.getSurveyId();
    }
}
