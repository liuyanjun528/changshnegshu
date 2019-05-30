package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportList;
import com.annaru.upms.mapper.ExamInspectReportListMapper;
import com.annaru.upms.service.IExamInspectReportListService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报告列表
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
@Service
public class ExamInspectReportListServiceImpl extends ServiceImpl<ExamInspectReportListMapper, ExamInspectReportList> implements IExamInspectReportListService {

    @Override
    public PageUtils<ExamInspectReportList> getDataPage(Map<String, Object> params) {
        Page<ExamInspectReportList> page = new PageUtils<ExamInspectReportList>(params).getPage();
        IPage<ExamInspectReportList> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils(iPage);
    }

    @Override
    public List<ExamInspectReportList> getDataList(Map<String, Object> params) {
        if(params == null || StringUtils.isBlank((String)params.get("logID"))){
            return null;
        }
        return this.baseMapper.selectDataList(params);
    }

    @Override
    public boolean saveInspectReportList(ExamInspectReportList inspectReportList) {
        if(inspectReportList == null
                || StringUtils.isBlank(inspectReportList.getREPORTNO())){
            return false;
        }

        // 判断数据库是否存在该检查报告或者检查报告不是最新
        ExamInspectReportList inspectReportListDB = this.getByReportNO(inspectReportList.getREPORTNO());
        if(inspectReportListDB != null){
            if(inspectReportList.equals(inspectReportListDB))
                return true;
            // inspectReportListDB 不为 null、且 inspectReportList 和 inspectReportListDB 不相等
            inspectReportListDB.deleteById();
        }

        // 保存最新的检查报告
        this.baseMapper.insert(inspectReportList);
        return true;
    }

    @Override
    public boolean saveBatchInspectReportList(String logID, List<ExamInspectReportList> inspectReportLists) {
        List<ExamInspectReportList> insertDB = new ArrayList<>();
        List<String> deleteIds = new ArrayList<>();
        if(StringUtils.isBlank(logID) || CollectionUtils.isEmpty(inspectReportLists)){
            return true;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("logID", logID);
        List<ExamInspectReportList> inspectReportListsDB = this.getDataList(params);

        a:for (ExamInspectReportList reportList : inspectReportLists) {
            if(CollectionUtils.isNotEmpty(inspectReportListsDB))
                for (ExamInspectReportList reportListDB : inspectReportListsDB){
                    // reportList 和 reportListDB 相等，不做删除和插入
                    if(reportList.equals(reportListDB))
                        continue a;

                    // reportList 和 reportListDB 唯一识别号reportNO相等，则删除数据库数据
                    if(reportList.getREPORTNO().equals(reportListDB.getREPORTNO())){
                        deleteIds.add(reportListDB.getId());
                        continue ;
                    }
                }
            insertDB.add(reportList);
        }

        // 删除数据库陈旧数据
        if(CollectionUtils.isNotEmpty(deleteIds))
            this.removeByIds(deleteIds);

        // 保存最新的检查报告
        if(CollectionUtils.isNotEmpty(insertDB))
            this.saveBatch(insertDB, insertDB.size());
        return true;
    }

    /**
     * @Description: 根据 reportNO 获取唯一数据
     * @param reportNO 唯一识别号
     * @Author: XCK
     * @Date: 2019/5/27
     * @return com.annaru.upms.entity.ExamInspectReportList
     */
    private ExamInspectReportList getByReportNO(String reportNO) {
        if (StringUtils.isBlank(reportNO)){
            return null;
        }
        return this.baseMapper.selectByReportNO(reportNO);
    }

}
