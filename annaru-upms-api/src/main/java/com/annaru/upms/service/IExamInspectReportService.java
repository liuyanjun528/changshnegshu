package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReport;
import java.util.List;
import java.util.Map;

/**
 * 检查报告
 *
 * @author xck
 * @date 2019-05-22 14:28:40
 */
public interface IExamInspectReportService extends IService<ExamInspectReport> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils<Map<String, String>> getDataPage(Map<String, Object> params);

    /**
     * 列表查询
     * @param params
     * @return
     */
    List<Map<String, String>> getDataList(Map<String, Object> params);

    /**
     * @Description:根据报告编号获取报告信息
     *
     * 1、logID 和 ReportNO 不能同时为空，
     * 2、如果是用户查看详情时，logID 、ReportNO必须同时上传
     * 3、服务自己调用接口，可以不用传 ReportNO
     *
     * @param logID 用户用于登陆的机构代码 （可以为 null）
     * @param ReportNO 报告编号 （不能为空）
     * @Author: XCK
     * @Date: 2019/5/22
     * @return 
     */
    ExamInspectReport getByReportNO(String logID,String ReportNO);

    /**
     * @Description: 保存检查报告及结果
     * @param  inspectReport 检查报告集合
     * @Author: XCK
     * @Date: 2019/5/22
     * @return
     */
    boolean saveInspectReport(ExamInspectReport inspectReport);

    /**
     * @Description: 批量保存检查报告及结果
     * @param  inspectReportList 检查报告集合
     * @Author: XCK
     * @Date: 2019/5/22
     * @return 
     */
    void saveBatchByDownLoadResult(List<ExamInspectReport> inspectReportList);


}

