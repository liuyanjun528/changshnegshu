package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.UserCardVo;
import com.annaru.upms.entity.vo.UserExamMainDetail;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.UserBasicMapper;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.mapper.UserBasicMapper;
import com.annaru.upms.service.IUserBasicService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jodd.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class UserBasicServiceImpl extends ServiceImpl<UserBasicMapper, UserBasic> implements IUserBasicService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserBasic> page = new PageUtils<UserBasic>(params).getPage();
        IPage<UserBasic> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserBasic>(iPage);
    }

    @Override
    public UserBasic selectByData(Map <String, Object> params) {
        UserBasic userBasic = this.baseMapper.selectByData(params);
        return userBasic;
    }

    @Override
    public boolean updateBySysId(Map<String, Object> params) {
        if (this.baseMapper.updateBySysId(params) > 0){
            return true;
        }
        return false;
    }

    @Override
    public UserBasic selectDoctorByData(Map <String, Object> params) {
        UserBasic userBasic = this.baseMapper.selectDoctorByData(params);
        return userBasic;
    }

    @Override
    public UserBasic selectNurseByData(Map <String, Object> params) {
        UserBasic userBasic = this.baseMapper.selectNurseByData(params);
        return userBasic;
    }

    @Override
    public int setPwd(String password,String cellphoneNo) {
        return this.baseMapper.setPwd(password,cellphoneNo);
    }


    @Override
    public int updateOldPwd( String password,String userId) {
        return this.baseMapper.updatePwd(password,userId);
    }

    @Override
    public UserBasic selectByUid(String userId) {
        return this.baseMapper.selectByUid(userId);
    }

    @Override
    public int updateCardAndBasics(UserCardVo userCardVo) {
        return this.baseMapper.updateCardAndBasics(userCardVo);
    }

    @Override
    public boolean selectEntityHealthy(String userId) {
        Boolean flag = false;
        if(StringUtil.isNotBlank(userId)){
            if(0 < this.baseMapper.selectEntityHealthy(userId)){
               flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean updateLastTimeBySysId(UserBasic userBasic) {
        if (this.baseMapper.updateLastTimeBySysId(userBasic) > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<UserExamMainDetail> getUserExamMainDetail(Map<String, Object> params) {
        return this.baseMapper.getUserExamMainDetail(params);
    }
}
