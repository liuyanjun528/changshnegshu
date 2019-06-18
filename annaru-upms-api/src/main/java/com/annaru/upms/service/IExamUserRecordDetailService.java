package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamUserRecordDetail;
import java.util.List;
import java.util.Map;

/**
 * 数据登记详细
 *
 * @author xck
 * @date 2019-06-17 13:19:24
 */
public interface IExamUserRecordDetailService extends IService<ExamUserRecordDetail> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 检测数据登记保存
     * @param orderNo 订单编号
     * @param userId  用户编号
     * @param userRecordDetailList 数据登记详细表
     * @return
     */
    boolean recordDetailSave(String orderNo, String userId, List<ExamUserRecordDetail> userRecordDetailList);

    /**
     * 根据实体类得到这条数据
     * @return
     * @author zk
     * @date 2019-6-17
     */
    List<ExamUserRecordDetail> getOneByExamUserRecordDetail(ExamUserRecordDetail examUserRecordDetail);


}

