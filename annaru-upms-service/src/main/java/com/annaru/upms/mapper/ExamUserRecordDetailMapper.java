package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamUserRecordDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 数据登记详细
 * 
 * @author xck
 * @date 2019-06-17 13:19:24
 */
public interface ExamUserRecordDetailMapper extends BaseMapper<ExamUserRecordDetail> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamUserRecordDetail> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 根据实体类得到这条数据
     * @return
     * @author zk
     * @date 2019-6-17
     */
    List<ExamUserRecordDetail> getOneByExamUserRecordDetail(@Param("examUserRecordDetail") ExamUserRecordDetail examUserRecordDetail);

}
