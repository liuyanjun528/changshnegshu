package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.ResultMap;
import com.annaru.common.result.UserBasicMenu;
import com.annaru.upms.entity.vo.UserCardVo;
import com.annaru.upms.entity.vo.UserExamMainDetail;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.mapper.UserBasicMapper;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.service.IUserBasicService;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Slf4j
@Service
public class UserBasicServiceImpl extends ServiceImpl<UserBasicMapper, UserBasic> implements IUserBasicService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params) {
        Page<UserBasic> page = new PageUtils<UserBasic>(params).getPage();
        IPage<UserBasic> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserBasic>(iPage);
    }

    @Override
    public UserBasic selectByData(Map<String, Object> params) {
        UserBasic userBasic = this.baseMapper.selectByData(params);
        return userBasic;
    }

    @Override
    public boolean updateBySysId(Map<String, Object> params) {
        if (this.baseMapper.updateBySysId(params) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public UserBasic selectDoctorByData(Map<String, Object> params) {
        UserBasic userBasic = this.baseMapper.selectDoctorByData(params);
        return userBasic;
    }

    @Override
    public UserBasic selectNurseByData(Map<String, Object> params) {
        UserBasic userBasic = this.baseMapper.selectNurseByData(params);
        return userBasic;
    }

    @Override
    public int setPwd(String password, String cellphoneNo) {
        return this.baseMapper.setPwd(password, cellphoneNo);
    }


    @Override
    public int updateOldPwd(String password, String userId) {
        return this.baseMapper.updatePwd(password, userId);
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
        if (StringUtil.isNotBlank(userId)) {
            if (0 < this.baseMapper.selectEntityHealthy(userId)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean updateLastTimeBySysId(UserBasic userBasic) {
        if (this.baseMapper.updateLastTimeBySysId(userBasic) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<UserExamMainDetail> getUserExamMainDetail(Map<String, Object> params) {
        return this.baseMapper.getUserExamMainDetail(params);
    }

    @Override
    public boolean uploadAuthorizationUrl(Integer sysId, String authorizationUrl) {
        if (this.baseMapper.uploadAuthorizationUrl(sysId, authorizationUrl) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserBascByParams(Map<String, Object> params) {
        if (this.baseMapper.updateUserBascByParams(params) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查看支付密码是否设置
     *
     * @param userId
     * @return
     */
    @Override
    public ResultMap paymentPinnoStatus(String userId) {
        UserBasic userBasic = this.selectUserBasic(userId);
        if (userBasic == null) {
            return ResultMap.error(UserBasicMenu.USER_IS_NULL.getMessage());
        }
        try {
            String paymentPinno = baseMapper.paymentPinnoStatus(userId);
            if (StringUtils.isEmpty(paymentPinno)) {
                return ResultMap.ok().put("data","0");
            } else {
                return ResultMap.ok().put("data","1");
            }
        } catch (Exception e) {
            //log.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 设置支付密码
     *
     * @param userId
     * @param paymentPinno
     * @return
     */
    @Override
    public ResultMap initPaymentPinno(String userId, String paymentPinno) {
        UserBasic userBasic = this.selectUserBasic(userId);
        if (userBasic == null) {
            return ResultMap.error(UserBasicMenu.USER_IS_NULL.getMessage());
        }
        try {
            int count = baseMapper.initPaymentPinno(userId, paymentPinno);
            if (count > 0) {
                return ResultMap.ok();
            } else {
                return ResultMap.error(UserBasicMenu.SHE_ZHI_ZHI_FU_MI_MA_ERROR.getMessage());
            }
        } catch (Exception e) {
            //log.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 验证支付密码
     *
     * @param userId
     * @param paymentPinno
     * @return
     */
    @Override
    public ResultMap verificationPaymentPinno(String userId, String paymentPinno) {
        UserBasic userBasic = this.selectUserBasic(userId);
        if (userBasic == null) {
            return ResultMap.error(UserBasicMenu.USER_IS_NULL.getMessage());
        }
        try {
            String paymentPinno2 = baseMapper.paymentPinnoStatus(userId);
            if (paymentPinno2.equals(paymentPinno)) {
                return ResultMap.ok();
            } else {
                return ResultMap.error("验证失败");
            }
        } catch (Exception e) {
            //log.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 忘记支付密码发送手机验证码
     *
     * @param userId
     * @param cellphoneNo
     * @return
     */
    @Override
    public ResultMap validated(String userId, String cellphoneNo) {
        UserBasic userBasic = this.selectUserBasic(userId);
        ResultMap resultMap = new ResultMap();
        if (userBasic == null) {
            return resultMap.error(UserBasicMenu.USER_IS_NULL.getMessage());
        }
        if (userBasic.getCellphoneNo().equals(cellphoneNo)) {
            return resultMap.ok();
        } else {
            return resultMap.error(UserBasicMenu.YON_HU_PHONENO_VALIDATED_ERROR.getMessage());
        }
    }

    public UserBasic selectUserBasic(String userId) {
        QueryWrapper wrapper = new QueryWrapper<UserBasic>();
        wrapper.eq("user_id", userId);
        return baseMapper.selectOne(wrapper);
    }

}
