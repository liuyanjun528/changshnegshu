package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamAppend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 赠送服务
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface ExamAppendMapper extends BaseMapper<ExamAppend> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamAppend> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * @Description:通过套餐查看套餐下的赠送服务
     * @Author: wh
     * @Date: 2019/8/1 9:32
     */
    List<ExamAppend> selectServiceByMainId(@Param("mainId") String mainId);

}
