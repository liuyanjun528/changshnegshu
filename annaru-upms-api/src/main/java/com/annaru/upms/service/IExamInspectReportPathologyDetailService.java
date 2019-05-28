package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamInspectReportPathologyDetail;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果2_病理项目明细结果
 *
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface IExamInspectReportPathologyDetailService extends IService<ExamInspectReportPathologyDetail> {

    /**
     * @Description: 根据 病理报告ID 获取所有 检查报告结果2_病理项目明细结果
     * @param  pathologyId 病理报告ID
     * @Author: XCK
     * @Date: 2019/5/27
     * @return
     */
    List<ExamInspectReportPathologyDetail> getByPathologyId(String pathologyId);
}

