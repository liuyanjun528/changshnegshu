package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.SysConfig;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.entity.UserRelatives;
import com.annaru.upms.entity.vo.UserRelativesDetailVoZ;
import com.annaru.upms.entity.vo.UserRelativesVoZ;
import com.annaru.upms.mapper.UserRelativesMapper;
import com.annaru.upms.service.ISysConfigService;
import com.annaru.upms.service.IUserBasicService;
import com.annaru.upms.service.IUserCardsService;
import com.annaru.upms.service.IUserRelativesService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.DateUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
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
    @Resource
    private ISysConfigService iSysConfigService; //系统配置表
    @Resource
    private IUserBasicService userBasicService;

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
        userRelatives1.setEditTime(new Date());
        if (userRelativesService.updateById(userRelatives1)){
            UserCards userCards = userCardsService.getById(userRelativesDetailVoZ.getUcSysId());
            if (userCards == null){
                return false;
            }
            userCards.setCardNo(userRelativesDetailVoZ.getCardNo());
            userCards.setCellphoneNo(userRelativesDetailVoZ.getCellphoneNo());
            if (userCardsService.updateById(userCards)){
                UserBasic userBasic = userBasicService.selectByUid(userRelatives1.getRefNo());
                if (userBasic == null){
                    return false;
                }
                userBasic.setFullName(userRelativesDetailVoZ.getRelativeName());
                userBasic.setGender(userRelativesDetailVoZ.getUrGender());
                userBasic.setIdCardNo(userRelativesDetailVoZ.getIdCardNo());
                userBasic.setCellphoneNo(userRelativesDetailVoZ.getCellphoneNo());
                userBasic.setDateOfBirth(DateUtil.stringToDate(getYearMonthDayOfIdCard(userRelativesDetailVoZ.getIdCardNo()), DateUtil.DATE_PATTERN.YYYY_MM_DD));
                if (userBasicService.updateById(userBasic)){
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean saveUserRelatives(UserRelativesDetailVoZ userRelativesDetailVoZ, String relativeId, String userId) {

        UserRelatives userRelatives = new UserRelatives();
        userRelatives.setUserId(userRelativesDetailVoZ.getUserId());
        userRelatives.setRelativeId(relativeId);
        userRelatives.setRefNo(userId);
        userRelatives.setRelativeName(userRelativesDetailVoZ.getRelativeName());
        userRelatives.setGender(userRelativesDetailVoZ.getUrGender());
        userRelatives.setIdCardNo(userRelativesDetailVoZ.getIdCardNo());
        userRelatives.setDateOfBirth(DateUtil.stringToDate(getYearMonthDayOfIdCard(userRelativesDetailVoZ.getIdCardNo()), DateUtil.DATE_PATTERN.YYYY_MM_DD));
        userRelatives.setCellphoneNo(userRelativesDetailVoZ.getCellphoneNo());
        userRelatives.setRemark(userRelativesDetailVoZ.getRemark());
        userRelatives.setCreationTime(new Date());
        if (userRelativesService.save(userRelatives)){
            UserCards userCards = new UserCards();
            userCards.setUserId(userId);
            userCards.setUserCates(2);
            userCards.setCardCates(2);
            userCards.setCardNo(userRelativesDetailVoZ.getCardNo());
            userCards.setCellphoneNo(userRelativesDetailVoZ.getCellphoneNo());
            userCards.setStatus(1);
            userCards.setRemark("2");
            userCards.setCreationTime(new Date());
            if (userCardsService.save(userCards)){
                Map<String, Object> params = new HashMap<>();
                params.put("cellphoneNo", userRelativesDetailVoZ.getCellphoneNo());
                UserBasic userBasic1 = userBasicService.selectByData(params);
                if (userBasic1 != null){
                    return false;
                }
                UserBasic userBasic = new UserBasic();
                userBasic.setUserId(userId);
                userBasic.setFullName(userRelativesDetailVoZ.getRelativeName());
                userBasic.setGender(userRelativesDetailVoZ.getUrGender());
                userBasic.setIdCardNo(userRelativesDetailVoZ.getIdCardNo());
                userBasic.setCellphoneNo(userRelativesDetailVoZ.getCellphoneNo());
                userBasic.setPassword("123456");
                userBasic.setDateOfBirth(DateUtil.stringToDate(getYearMonthDayOfIdCard(userRelativesDetailVoZ.getIdCardNo()), DateUtil.DATE_PATTERN.YYYY_MM_DD));
                userBasic.setRegistrationTime(new Date());
                userBasic.setCreationTime(new Date());
                if (userBasicService.save(userBasic)){
                    return true;
                }
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
                UserBasic userBasic = userBasicService.selectByUid(userRelatives1.getRefNo());
                if (userBasic == null){
                    return false;
                }
                userBasic.setIsactive(0);
                if (userBasicService.updateById(userBasic)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 省份证的正则表达式^(\d{15}|\d{17}[\dx])$
     * @param id    省份证号
     * @return    生日（yyyy-MM-dd）
     */
    public String getYearMonthDayOfIdCard(String id) {
        String year = null;
        String month = null;
        String day = null;
        //正则匹配身份证号是否是正确的，15位或者17位数字+数字/x/X
        if (id.matches("^\\d{15}|\\d{17}[\\dxX]$")) {
            year = id.substring(6, 10);
            month = id.substring(10,12);
            day = id.substring(12,14);
        }else {
            System.out.println("身份证号码不匹配！");
            return null;
        }
        return year + "-" + month + "-" + day;
    }

}


















