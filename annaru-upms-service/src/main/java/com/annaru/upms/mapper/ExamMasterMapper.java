package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamMaster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 体检项目主表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
public interface ExamMasterMapper extends BaseMapper<ExamMaster> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamMaster> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    ExamMaster getItem(@Param("params") Map<String, Object> params);
}
