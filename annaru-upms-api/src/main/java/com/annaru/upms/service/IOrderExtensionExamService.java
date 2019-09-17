package com.annaru.upms.service;

import com.annaru.upms.entity.OrderExtensionExam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 进阶体检项目
 *
 * @author xck
 * @date 2019-05-20 16:18:23
 */
public interface IOrderExtensionExamService extends IService<OrderExtensionExam> {

    int saveOne(OrderExtensionExam orderExtensionExam);

    List<OrderExtensionExam> getListByOrderNo(String orderNo);
}

