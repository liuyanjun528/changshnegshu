package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReportPathologyDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果2_病理项目明细结果
 * 
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface ExamInspectReportPathologyDetailMapper extends BaseMapper<ExamInspectReportPathologyDetail> {

    /**
     * @Description: 根据 病理报告ID 获取所有 检查报告结果2_病理项目明细结果
     * @param  pathologyId 病理报告ID
     * @Author: XCK
     * @Date: 2019/5/27
     * @return
     */
    List<ExamInspectReportPathologyDetail> selectByPathologyId(@Param("pathologyId") String pathologyId);
}
