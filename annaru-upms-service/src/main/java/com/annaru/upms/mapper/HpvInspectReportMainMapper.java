package com.annaru.upms.mapper;

import com.annaru.upms.entity.HpvInspectReportMain;
import com.annaru.upms.entity.vo.HpvReportMainAndDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * HPV检查报告主表
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
public interface HpvInspectReportMainMapper extends BaseMapper<HpvInspectReportMain> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<HpvInspectReportMain> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
      * @Description:通过订单号查询Hpv检查报告
      * @Author: wh
      * @Date: 2019/10/11 13:35
      */
    HpvReportMainAndDetail selectByOrderNo(@Param("orderNo") String orderNo);



}
