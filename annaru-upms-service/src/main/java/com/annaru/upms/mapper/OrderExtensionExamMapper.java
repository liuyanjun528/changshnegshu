package com.annaru.upms.mapper;


import com.annaru.upms.entity.OrderExtensionExam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 进阶体检项目
 * 
 * @author xck
 * @date 2019-05-20 16:18:23
 */
public interface OrderExtensionExamMapper extends BaseMapper<OrderExtensionExam> {

    /**
     * @Description:获取订单的建议进阶项目
     * @param orderNo 订单编号
     * @Author: XCK
     * @Date: 2019/8/19
     * @return 
     */
    List<OrderExtensionExam> selectListByOrderNo(String orderNo);
}
