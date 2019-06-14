package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamInspectReportMicroorganismDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 检查报告结果4_微生物药敏结果
 * 
 * @author xck
 * @date 2019-05-27 12:59:42
 */
public interface ExamInspectReportMicroorganismDetailMapper extends BaseMapper<ExamInspectReportMicroorganismDetail> {


    /**
     * @Description: 根据微生物报告ID获取所有详细报告
     * @param microorganismId
     * @Author: XCK
     * @Date: 2019/6/13
     * @return 
     */
    List<ExamInspectReportMicroorganismDetail> selectByMicroorganismId(@Param("microorganismId")String microorganismId);

    /**
     * @Description: 分页查询
     * @param params
     * @Author: XCK
     * @Date: 2019/6/13
     * @return 
     */
    IPage<ExamInspectReportMicroorganismDetail> selectDataPage(Page<ExamInspectReportMicroorganismDetail> page, @Param("params")Map<String, Object> params);
}
