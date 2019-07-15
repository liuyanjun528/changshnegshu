package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.UserWallet;
import com.annaru.upms.entity.vo.NurseBalance;
import com.annaru.upms.mapper.ExamCatesMapper;
import com.annaru.upms.mapper.NurseBalanceMapper;
import com.annaru.upms.service.IExamCatesService;
import com.annaru.upms.service.INurseBalanceService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @Description:护士收入信息
 * @Author: wh
 * @Date: 2019/7/11 10:24
 */
@Service
public class NurseBalanceServiceImpl extends ServiceImpl<NurseBalanceMapper, NurseBalance> implements INurseBalanceService {


    @Override
    public int selectSingular(String nurseNo) {
        int i = this.baseMapper.selectSingular(nurseNo);
        return i;
    }

    @Override
    public Double selectTotalMoney(String nurseNo) {
        Double aDouble = this.baseMapper.selectTotalMoney(nurseNo);
        return aDouble;
    }
    @Override
    public Double selectBalance1(String userId) {
        return this.baseMapper.selectBalance1(userId);
    }

    @Override
    public Double selectBalance2(String userId) {
        return this.baseMapper.selectBalance2(userId);
    }

    @Override
    public List<UserWallet> selectMoneyInfoList(Map<String, Object> params) {
        return this.baseMapper.selectMoneyInfoList(params);
    }
}
