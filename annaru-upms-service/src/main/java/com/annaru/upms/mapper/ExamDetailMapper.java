package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamDetail;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 体检项目
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface ExamDetailMapper extends BaseMapper<ExamDetail> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamDetail> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /*** 方法描述:查询所有进阶项目类别
    * @params: []
    * @return: java.util.List<com.annaru.upms.entity.ExamDetail>
    * @Author: jyehui
    * @Date: 2019/7/1 13:34
    */
    List<ExamDetail> selectType();

    /*** 方法描述:根据进阶项目类别查询项目
    * @params: [ecId]
    * @return: java.util.List<com.annaru.upms.entity.ExamDetail>
    * @Author: jyehui
    * @Date: 2019/7/1 13:49
    */
    List<ExamDetail> selectByType(@Param("ecId") Integer ecId);

    ExamDetail getItem(@Param("params") Map<String, Object> params);
}
