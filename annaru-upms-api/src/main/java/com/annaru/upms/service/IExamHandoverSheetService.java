package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamHandoverSheet;
import java.util.List;
import java.util.Map;

/**
 * 交接单
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
public interface IExamHandoverSheetService extends IService<ExamHandoverSheet> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * @Description:通过订单编号修改已有 未完成的预约记录
     * @Author: wh
     * @Date: 2019/6/11 16:22
     */
    int updateExamHandoverSheet(ExamHandoverSheet examHandoverSheet);

}

