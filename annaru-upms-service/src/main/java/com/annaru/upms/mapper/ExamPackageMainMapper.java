package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamPackageMain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 套餐
 * 
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface ExamPackageMainMapper extends BaseMapper<ExamPackageMain> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamPackageMain> selectDataPage(Page page, @Param("params") Map <String, Object> params);


}