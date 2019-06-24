package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.INTERFACE_AUTHORIZATION;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.entity.vo.UserCardInfoVo;
import com.annaru.upms.mapper.UserCardsMapper;
import com.annaru.upms.service.IUserCardsService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * 用户绑卡信息
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class UserCardsServiceImpl extends ServiceImpl<UserCardsMapper, UserCards> implements IUserCardsService {



    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserCards> page = new PageUtils<UserCards>(params).getPage();
        IPage<UserCards> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserCards>(iPage);
    }

    @Override
    public List<UserCards> selectByStatus(String userId) {
        return this.baseMapper.selectByStatus(userId);
    }


    /**
     * 查询企业门诊绿通预约人信息
     * @param userId 用户ID
     * @return
     */
    public List<UserCardInfoVo> getGreenPassUserInfo(String userId) {
        return this.baseMapper.getGreenPassUserInfo(userId);
    }

    @Override
    public int updateCardAndBasic(String userId,String cardNo) {
        return this.baseMapper.updateCardAndBasic(userId, cardNo);
    }

    @Override
    @DS("oracle")
    public List<INTERFACE_AUTHORIZATION> selectByUserId(String userId) {
        return this.baseMapper.selectByUserId(userId);
    }

}
