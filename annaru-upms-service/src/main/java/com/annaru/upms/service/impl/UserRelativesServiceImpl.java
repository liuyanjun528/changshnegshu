package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.entity.UserRelatives;
import com.annaru.upms.entity.vo.UserRelativesDetailVoZ;
import com.annaru.upms.entity.vo.UserRelativesVoZ;
import com.annaru.upms.mapper.UserRelativesMapper;
import com.annaru.upms.service.IUserCardsService;
import com.annaru.upms.service.IUserRelativesService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private IUserRelativesService userRelativesService;
    @Resource
    private IUserCardsService userCardsService;

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

    @Override
    public UserRelativesVoZ managerUserRelativesVoZ(String userId) {
        return this.baseMapper.managerUserRelativesVoZ(userId);
    }

    @Override
    public List<UserRelatives> getUserRelativesList(String userId) {
        return this.baseMapper.getUserRelativesList(userId);
    }

    @Override
    public int DeleteRelative(String userId, String relativeId) {
        return this.baseMapper.DeleteRelative(userId, relativeId);
    }

    @Override
    @Transactional
    public boolean updateUserRelatives(UserRelatives userRelatives1, UserRelativesDetailVoZ userRelativesDetailVoZ) {
        userRelatives1.setRelativeName(userRelativesDetailVoZ.getRelativeName());
        userRelatives1.setGender(userRelativesDetailVoZ.getUrGender());
        userRelatives1.setIdCardNo(userRelativesDetailVoZ.getIdCardNo());
        userRelatives1.setCellphoneNo(userRelativesDetailVoZ.getCellphoneNo());
        userRelatives1.setRemark(userRelativesDetailVoZ.getRemark());
        if (userRelativesService.updateById(userRelatives1)){
            UserCards userCards = userCardsService.getById(userRelativesDetailVoZ.getUcSysId());
            if (userCards == null){
                return false;
            }
            userCards.setCardNo(userRelativesDetailVoZ.getCardNo());
            userCards.setCellphoneNo(userRelativesDetailVoZ.getCellphoneNo());
            if (userCardsService.updateById(userCards)){
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean saveUserRelatives(UserRelativesDetailVoZ userRelativesDetailVoZ) {
        UserRelatives userRelatives = new UserRelatives();
        userRelatives.setUserId(userRelativesDetailVoZ.getUserId());
        userRelatives.setRelativeId(userRelativesDetailVoZ.getRelativeId());
        userRelatives.setRelativeName(userRelativesDetailVoZ.getRelativeName());
        userRelatives.setGender(userRelativesDetailVoZ.getUrGender());
        userRelatives.setIdCardNo(userRelativesDetailVoZ.getIdCardNo());
        userRelatives.setCellphoneNo(userRelativesDetailVoZ.getCellphoneNo());
        userRelatives.setRemark(userRelativesDetailVoZ.getRemark());
        if (userRelativesService.save(userRelatives)){
            UserCards userCards = new UserCards();
            userCards.setUserId(userRelativesDetailVoZ.getUserId());
            userCards.setUserCates(2);
            userCards.setCardCates(2);
            userCards.setCardNo(userRelativesDetailVoZ.getCardNo());
            userCards.setCellphoneNo(userRelativesDetailVoZ.getCellphoneNo());
            userCards.setStatus(1);
            userCards.setRemark("2");
            userCards.setCreationTime(new Date());
            if (userCardsService.save(userCards)){
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteUserRelatives(UserRelatives userRelatives1, UserRelativesDetailVoZ userRelativesDetailVoZ) {
        userRelatives1.setIsDeleted(1);
        if (userRelativesService.updateById(userRelatives1)){
            if (userCardsService.removeById(userRelativesDetailVoZ.getUcSysId())){
                return true;
            }
        }
        return false;
    }

}


















