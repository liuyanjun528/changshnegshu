package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.ExamInspectReportResult;
import com.annaru.upms.service.IExamInspectReportResultService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.ExamInspectReportMapper;
import com.annaru.upms.entity.ExamInspectReport;
import com.annaru.upms.service.IExamInspectReportService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 检查报告
 *
 * @author xck
 * @date 2019-05-22 14:28:40
 */
@Service
public class ExamInspectReportServiceImpl extends ServiceImpl<ExamInspectReportMapper, ExamInspectReport> implements IExamInspectReportService {

    @Autowired
    private IExamInspectReportResultService examInspectReportResultService;

    // 控制线程数，最优选择是处理器线程数*3，本机处理器是4线程
    private final static int THREAD_COUNT = 12;

    @Override
    public PageUtils<Map<String, String>> getDataPage(Map<String, Object> params){
        Page<Map<String, String>> page = new PageUtils(params).getPage();
        IPage<Map<String, String>> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils(iPage);
    }

    @Override
    public List<Map<String, String>> getDataList(Map<String, Object> params) {
        if(StringUtils.isBlank((String)params.get("logID"))){
            return null;
        }
        return this.baseMapper.selectDataList(params);
    }

    @Override
    public ExamInspectReport getByReportNO(String logID, String ReportNO) {
        if (StringUtils.isBlank(ReportNO)){
            return null;
        }
        ExamInspectReport report = this.baseMapper.selectByReportNO(logID, ReportNO);
        if(report != null){
            List<ExamInspectReportResult> resultList = examInspectReportResultService.getListByInspectReportId(report.getId());
            report.setInspectReportResultList(resultList);
        }
        return report;
    }


    @Override
    public boolean saveInspectReport(ExamInspectReport inspectReport) {
        if(inspectReport == null
                || StringUtils.isBlank(inspectReport.getREPORTNO())){
            return false;
        }
        ExamInspectReport report = this.getByReportNO(null, inspectReport.getREPORTNO());
        if(report != null){
            //先删除从前保存的还未完成的 检查报告 及所有 结果，
            List<String> idList = new ArrayList<>();
            List<ExamInspectReportResult> resultList = report.getInspectReportResultList();
            for (ExamInspectReportResult result : resultList) {
                idList.add(result.getId());
            }
            if(CollectionUtils.isNotEmpty(idList)){
                examInspectReportResultService.removeByIds(idList);
            }
            report.deleteById();
        }
        // 保存检查报告
        this.baseMapper.insert(inspectReport);
        List<ExamInspectReportResult> resultList = inspectReport.getInspectReportResultList();
        if(CollectionUtils.isNotEmpty(resultList)){
            // 保存检查报告的所有项目结果
            List<ExamInspectReportResult> resultListSave = new ArrayList<>(resultList.size());
            for (ExamInspectReportResult result : resultList) {
                result.setInspectReportId(inspectReport.getId());
                resultListSave.add(result);
            }
            if(CollectionUtils.isNotEmpty(resultListSave)){
                examInspectReportResultService.saveBatch(resultListSave, resultListSave.size());
            }
        }
        return true;
    }


    @Override
    public void saveBatchByDownLoadResult(List<ExamInspectReport> inspectReportList) {
        if(CollectionUtils.isEmpty(inspectReportList)){
            return;
        }
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
        for (ExamInspectReport report : inspectReportList) {
            saveInspectReport(report);
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    saveInspectReport(report);
                }
            });
        }
        pool.shutdown();
    }

}
