package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.*;
import com.annaru.upms.mapper.ExamInspectReportMapper;
import com.annaru.upms.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 检查报告
 *
 * @author xck
 * @date 2019-05-22 14:28:40
 */
@Service
public class ExamInspectReportServiceImpl extends ServiceImpl<ExamInspectReportMapper, ExamInspectReport> implements IExamInspectReportService {

    @Autowired
    private IExamInspectReportClinicService examInspectReportClinicService;
    @Autowired
    private IExamInspectReportPathologyService examInspectReportPathologyService;
    @Autowired
    private IExamInspectReportTctService examInspectReportTctService;
    @Autowired
    private IExamInspectReportMicroorganismService examInspectReportMicroorganismService;

    @Override
    public PageUtils<ExamInspectReport> getDataPage(Map<String, Object> params) {
        Page<ExamInspectReport> page = new PageUtils<ExamInspectReport>(params).getPage();
        IPage<ExamInspectReport> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils(iPage);
    }

    @Override
    public List<ExamInspectReport> getAllByBYH(String byh, String reportType) {

        if(StringUtils.isBlank(byh)){
            return null;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("byh", byh);
        params.put("reportType", reportType);
        return this.baseMapper.selectDataList(params);
    }

    @Override
    public ExamInspectReport getByReportNO(String reportNO) {
        if (StringUtils.isBlank(reportNO)){
            return null;
        }

        ExamInspectReport report = this.baseMapper.selectByReportNO(reportNO);
        if(report != null){
            String InspectReportId = report.getId();
            String reportType = reportNO.substring(0,1);
            switch (reportType){
                case "1":
                    // 临床检验报告
                    List<ExamInspectReportClinic> clinicList = examInspectReportClinicService.getByInspectReportId(InspectReportId);
                    report.setClinicList(clinicList);
                    break;
                case "2":
                    // 病理组织报告
                    List<ExamInspectReportPathology> pathologyList = examInspectReportPathologyService.getByInspectReportId(InspectReportId);
                    report.setPathologyList(pathologyList);
                    break;
                case "3":
                    // TCT报告
                    List<ExamInspectReportTct> tctList = examInspectReportTctService.getByInspectReportId(InspectReportId);
                    report.setTctList(tctList);
                    break;
                case "4":
                    // 微生物报告
                    List<ExamInspectReportMicroorganism> microorganismList = examInspectReportMicroorganismService.getByInspectReportId(InspectReportId);
                    report.setMicroorganismList(microorganismList);
                    break;
            }
        }
        return report;
    }


    @Override
    public boolean saveInspectReport(ExamInspectReport inspectReport) {
        if(inspectReport == null || StringUtils.isBlank(inspectReport.getREPORTNO())){
            return false;
        }
        ExamInspectReport reportDB = this.getByReportNO(inspectReport.getREPORTNO());
        if(reportDB != null){
            //删除本地数据库保存的(还未完成的) 检查报告 及所有结果，
            String reportNO = reportDB.getREPORTNO();
            if(StringUtils.isNotBlank(reportNO)){
                String reportType = reportNO.substring(0,1);
                switch (reportType){
                    case "1":
                        // 删除临床检验报告
                        examInspectReportClinicService.deleteBatch(reportDB.getClinicList());
                        break;
                    case "2":
                        // 删除病理组织报告
                        examInspectReportPathologyService.deleteBatch(reportDB.getPathologyList());
                        break;
                    case "3":
                        // 删除TCT报告
                        examInspectReportTctService.deleteBatch(reportDB.getTctList());
                        break;
                    case "4":
                        // 删除微生物报告
                        examInspectReportMicroorganismService.deleteBatch(reportDB.getMicroorganismList());
                        break;
                }
                // 删除检查报告
                reportDB.deleteById();
            }
        }

        // 保存检查报告
        boolean insert = inspectReport.insert();
        String inspectReportId = inspectReport.getId();
        String reportNO = inspectReport.getREPORTNO();

        // 根据报告类型保存检查报告的所有项目结果
        if(insert && StringUtils.isNotBlank(reportNO) && StringUtils.isNotBlank(inspectReportId)){
            String reportType = reportNO.substring(0,1);
            switch (reportType){
                case "1":
                    // 临床检验报告
                    List<ExamInspectReportClinic> clinicList = inspectReport.getClinicList();
                    examInspectReportClinicService.saveBatch(inspectReportId, clinicList);
                    break;
                case "2":
                    // 病理组织报告
                    List<ExamInspectReportPathology> pathologyList = inspectReport.getPathologyList();
                    examInspectReportPathologyService.saveBatch(inspectReportId, pathologyList);
                    break;
                case "3":
                    // TCT报告
                    List<ExamInspectReportTct> tctList = inspectReport.getTctList();
                    examInspectReportTctService.saveBatch(inspectReportId, tctList);
                    break;
                case "4":
                    // 微生物报告
                    List<ExamInspectReportMicroorganism> microorganismList = inspectReport.getMicroorganismList();
                    examInspectReportMicroorganismService.saveBatch(inspectReportId, microorganismList);
                    break;
            }
        }
        return true;
    }

    @Override
    public String selectByRno(String reportNO) {
        if(StringUtils.isNotBlank(reportNO)){
          return this.baseMapper.selectByRno(reportNO);
        }
        return null;
    }
}
