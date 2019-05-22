package com.annaru.upms.mapper;


import com.annaru.upms.entity.OrderExtensionExam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 进阶体检项目
 * 
 * @author xck
 * @date 2019-05-20 16:18:23
 */
public interface OrderExtensionExamMapper extends BaseMapper<OrderExtensionExam> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderExtensionExam> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
