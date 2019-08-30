package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.common.util.Constant;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.SysConfig;
import com.annaru.upms.entity.SysGlobalSetting;
import com.annaru.upms.entity.UserFamilyDoctor;
import com.annaru.upms.entity.vo.UserFamilyDoctorVo;
import com.annaru.upms.mapper.UserFamilyDoctorMapper;
import com.annaru.upms.service.IOrderMainService;
import com.annaru.upms.service.ISysGlobalSettingService;
import com.annaru.upms.service.IUserFamilyDoctorService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户家庭医生
 *
 * @author xck
 * @date 2019-05-22 10:07:32
 */
@Service
public class UserFamilyDoctorServiceImpl extends ServiceImpl<UserFamilyDoctorMapper, UserFamilyDoctor> implements IUserFamilyDoctorService {

    @Autowired
    private IOrderMainService orderMainService;//订单主表
    @Autowired
    private ISysGlobalSettingService sysGlobalSettingService;//系统全局参数管理

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserFamilyDoctor> page = new PageUtils<UserFamilyDoctor>(params).getPage();
        IPage<UserFamilyDoctor> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserFamilyDoctor>(iPage);
    }

    public UserFamilyDoctorVo getUserFDInfo(Map<String, Object> params){
        return this.baseMapper.getUserFDInfo(params);
    }

    public UserFamilyDoctor getUserFD(Map<String,Object> params){
        return this.baseMapper.getUserFD(params);
    }

    @Override
    @Transactional
    public Boolean saveFamilyDoctor(OrderMain orderMain) {
        boolean save=false;
        try {
            if(StringUtils.isBlank(orderMain.getUserId())){
                return false;
            }
            //添加订单主表
            orderMain.setOrderCates(5);
            orderMain.setCreationtime(new Date());
            orderMain.setStatus(Constant.PaymentState.UNPAID.getValue());
            save = orderMainService.save(orderMain);

            if(save){
                //查询sys_global_setting 获取家庭医生的次数 插入userFamilyDoctor
                Map<String, Object> params = new HashMap<>();
                params.put("category",105);
                SysGlobalSetting setting = sysGlobalSettingService.getSetting(params);

                //添加userFamilyDoctor
                orderMain.getUserFamilyDoctor().setOrderNo(orderMain.getOrderNo());
                orderMain.getUserFamilyDoctor().setUserId(orderMain.getUserId());
                orderMain.getUserFamilyDoctor().setEffectFrom(orderMain.getOrderTime());
                orderMain.getUserFamilyDoctor().setTotalCount(setting.getCounts());
                orderMain.getUserFamilyDoctor().setRestCount(setting.getCounts());
                orderMain.getUserFamilyDoctor().setCreationTime(orderMain.getOrderTime());
                this.baseMapper.insert(orderMain.getUserFamilyDoctor());
            }

        }catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return save;
    }


}
