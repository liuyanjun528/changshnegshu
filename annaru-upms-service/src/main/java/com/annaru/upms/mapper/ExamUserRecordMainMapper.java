package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamUserRecordMain;
import com.annaru.upms.entity.vo.ExamUserRecordMainVoZ;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 数据登记主表
 * 
 * @author xck
 * @date 2019-06-17 13:19:24
 */
public interface ExamUserRecordMainMapper extends BaseMapper<ExamUserRecordMain> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamUserRecordMain> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 根据实体类得到这条数据
     * @return
     * @author zk
     * @date 2019-6-17
     */
    ExamUserRecordMain getOneByExamUserRecordMain(@Param("examUserRecordMain") ExamUserRecordMain examUserRecordMain);

    /**
     * 根据userId查询 数据登记主表 和 详情表
     * @param userId
     * @author zk
     * @date 2019-6-21
     */
    List<ExamUserRecordMainVoZ> selectMainDetailByUserId(@Param("userId") String userId);


}
