package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.ExamReportReview;
import com.annaru.upms.entity.vo.OrderExtensionSuggestionVo;
import com.annaru.upms.mapper.ExamReportReviewMapper;
import com.annaru.upms.service.IExamInspectReportService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Autowired
    private ExamReportReviewMapper examReportReviewMapper;

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
    public boolean savaOE(String reportNo, String[] masterIds, String[] itemNames, String[] sysIds, String doctorNo, String[] suggestTimes, int dayNumbers, String selectByRno) {
        if (itemNames.length != sysIds.length || itemNames.length != masterIds.length) {
            return false;
        }

        try {

            OrderExtensionSuggestion exists = isExists(selectByRno);
            if (null != exists) {

                deleteByorder(selectByRno); // 删除旧记录
            }

            OrderExtensionSuggestion orderExtensionExam = new OrderExtensionSuggestion();
            orderExtensionExam.setOrderNo(selectByRno);// 订单编号
            orderExtensionExam.setDoctorNo(doctorNo);// 医生编号
            orderExtensionExam.setInterventionIime(DateUtil.date_Days(new Date(), dayNumbers)); // 干预时间
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


    @Override
    public OrderExtensionSuggestion isExists (String orderNo){
        QueryWrapper<OrderExtensionSuggestion> qw = new QueryWrapper<>();
        qw.eq("order_no", orderNo);
        qw.eq("is_deleted", 0);
        qw.last("LIMIT 1");
        return this.baseMapper.selectOne(qw);
    }

    private int deleteByorder (String orderNo){
        QueryWrapper<OrderExtensionSuggestion> qw = new QueryWrapper<>();
        qw.eq("order_no", orderNo);
        OrderExtensionSuggestion orderExtensionSuggestion = new OrderExtensionSuggestion();
        orderExtensionSuggestion.setIsDeleted(1);// 删除
        orderExtensionSuggestion.setEditTime(new Date());
        orderExtensionSuggestion.setOrderNo(orderNo);
        return this.baseMapper.update( orderExtensionSuggestion ,qw);
    }






}
