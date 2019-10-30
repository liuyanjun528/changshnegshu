package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.exception.GlobalException;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.vo.OrderExtensionSuggestionVo;
import com.annaru.upms.service.IExamInspectReportService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.OrderExtensionSuggestionMapper;
import com.annaru.upms.entity.OrderExtensionSuggestion;
import com.annaru.upms.service.IOrderExtensionSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 进阶体检项目建议
 *
 * @author xck
 * @date 2019-05-22 17:42:35
 */
@Service
public class OrderExtensionSuggestionServiceImpl extends ServiceImpl<OrderExtensionSuggestionMapper, OrderExtensionSuggestion> implements IOrderExtensionSuggestionService {

    @Autowired
    private IExamInspectReportService examInspectReportService;

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderExtensionSuggestion> page = new PageUtils<OrderExtensionSuggestion>(params).getPage();
        IPage<OrderExtensionSuggestion> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderExtensionSuggestion>(iPage);
    }

    public List<OrderExtensionSuggestionVo> getItems(Map<String,Object> params){
        return this.baseMapper.getItems(params);
    }

    @Transactional
    @Override
    public boolean savaOE(String reportNo, String[] masterIds, String[] itemNames, String[] sysIds, String doctorNo, String[] suggestTimes) {
        if (itemNames.length != sysIds.length || itemNames.length != masterIds.length) {
            return false;
        }
        String selectByRno = examInspectReportService.selectByRno(reportNo);
        if(null == selectByRno || "".equals(selectByRno) ) {
            throw new GlobalException("系统异常：通过该检查报告编号未解析到对应的订单编号");
        }
        try {
            OrderExtensionSuggestion orderExtensionExam = new OrderExtensionSuggestion();
            orderExtensionExam.setOrderNo(selectByRno);// 订单编号
            orderExtensionExam.setDoctorNo(doctorNo);// 医生编号
            orderExtensionExam.setCreationTime(new Date());
            for (int i = 0, len = sysIds.length; i < len; i++) {
                orderExtensionExam.setExamDetailId(Integer.parseInt(sysIds[i].toString()));//体检项目编号
                orderExtensionExam.setExamMasterItem(itemNames[i].toString());//项目名称
                orderExtensionExam.setExamMasterId(Integer.parseInt(masterIds[i].toString()));//进阶检查项目总编号
                orderExtensionExam.setSuggestTime(suggestTimes[i].toString());// 建议赴检查的时间
                this.baseMapper.insert(orderExtensionExam);
            }
        return true;
    }catch (Exception e){
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return false;
    }

    }
}
