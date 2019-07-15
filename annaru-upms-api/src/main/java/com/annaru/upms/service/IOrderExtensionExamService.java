package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderExtensionExam;
import com.annaru.upms.entity.vo.ExamChooseVo;
import com.annaru.upms.entity.vo.OrderExtensionChooseVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 进阶体检项目
 *
 * @author xck
 * @date 2019-05-20 16:18:23
 */
public interface IOrderExtensionExamService extends IService<OrderExtensionExam> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    int saveOne(OrderExtensionExam orderExtensionExam);


}

