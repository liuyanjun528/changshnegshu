package com.annaru.upms.service;

import com.annaru.upms.entity.vo.HpvReportMainAndDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.HpvInspectReportMain;
import java.util.List;
import java.util.Map;

/**
 * HPV检查报告主表
 *
 * @author wh
 * @date 2019-10-11 09:35:39
 */
public interface IHpvInspectReportMainService extends IService<HpvInspectReportMain> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * @Description:通过订单号查询Hpv检查报告
     * @Author: wh
     * @Date: 2019/10/11 13:35
     */
    HpvReportMainAndDetail selectByOrderNo(String orderNo);

}

