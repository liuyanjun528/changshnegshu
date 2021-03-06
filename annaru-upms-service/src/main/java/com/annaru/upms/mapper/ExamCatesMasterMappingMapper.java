package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamCatesMasterMapping;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 体检类别与主检项目关联表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
public interface ExamCatesMasterMappingMapper extends BaseMapper<ExamCatesMasterMapping> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamCatesMasterMapping> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
