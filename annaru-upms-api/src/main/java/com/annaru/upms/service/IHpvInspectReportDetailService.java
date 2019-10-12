package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.HpvInspectReportDetail;
import java.util.List;
import java.util.Map;

/**
 * HPV检查报告明细表
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
public interface IHpvInspectReportDetailService extends IService<HpvInspectReportDetail> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

