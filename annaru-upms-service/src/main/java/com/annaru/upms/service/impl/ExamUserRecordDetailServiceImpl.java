package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.ExamUserRecordMain;
import com.annaru.upms.service.IExamUserRecordMainService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamUserRecordDetailMapper;
import com.annaru.upms.entity.ExamUserRecordDetail;
import com.annaru.upms.service.IExamUserRecordDetailService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 数据登记详细
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
@Service
public class ExamUserRecordDetailServiceImpl extends ServiceImpl<ExamUserRecordDetailMapper, ExamUserRecordDetail> implements IExamUserRecordDetailService {

    @Resource
    private IExamUserRecordMainService examUserRecordMainService;
    private IExamUserRecordDetailService examUserRecordDetailService;

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<ExamUserRecordDetail> page = new PageUtils<ExamUserRecordDetail>(params).getPage();
        IPage<ExamUserRecordDetail> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<ExamUserRecordDetail>(iPage);
    }

    /**
     * 检测数据登记保存
     * @param orderNo 订单编号
     * @param userId  用户编号
     * @param userRecordDetailList 数据登记详细表
     * @return
     */
    @Override
    @Transactional
    public boolean recordDetailSave(String orderNo, String userId, List<ExamUserRecordDetail> userRecordDetailList) {
        ExamUserRecordMain examUserRecordMain1 = new ExamUserRecordMain();
        examUserRecordMain1.setOrderNo(orderNo);
        examUserRecordMain1.setUserId(userId);
        examUserRecordMain1.setCreationTime(new Date());
        if (examUserRecordMainService.save(examUserRecordMain1)){
            ExamUserRecordMain examUserRecordMain = examUserRecordMainService.getOneByExamUserRecordMain(examUserRecordMain1);
            if (examUserRecordMain != null){
                if (userRecordDetailList != null && userRecordDetailList.size() > 0){
                    for (int i = 0 ; i < userRecordDetailList.size() ; i++){
                        userRecordDetailList.get(i).setMainId(examUserRecordMain.getSysId());
                    }
                }
                if (examUserRecordDetailService.saveBatch(userRecordDetailList)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<ExamUserRecordDetail> getOneByExamUserRecordDetail(ExamUserRecordDetail examUserRecordDetail) {
        return this.baseMapper.getOneByExamUserRecordDetail(examUserRecordDetail);
    }

}
