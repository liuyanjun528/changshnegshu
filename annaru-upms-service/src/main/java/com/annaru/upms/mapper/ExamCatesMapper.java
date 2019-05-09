package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamCates;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 体检总分类
 * 
 * @author zk
 * @date 2019-05-09 11:14:30
 */
public interface ExamCatesMapper extends BaseMapper<ExamCates> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamCates> selectDataPage(Page page, @Param("params") Map <String, Object> params);


}
