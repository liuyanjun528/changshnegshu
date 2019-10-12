package com.annaru.upms.mapper;

import com.annaru.upms.entity.HpvInspectReportDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * HPV检查报告明细表
 * 
 * @author wh
 * @date 2019-10-11 09:35:39
 */
public interface HpvInspectReportDetailMapper extends BaseMapper<HpvInspectReportDetail> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<HpvInspectReportDetail> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
