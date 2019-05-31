package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamPackageAppend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 套餐赠送服务
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface ExamPackageAppendMapper extends BaseMapper<ExamPackageAppend> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamPackageAppend> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 根据套餐ID查询套餐赠送的服务
     * @param package_main_id
     * @return
     */
    List<ExamPackageAppend> selectExamName(@Param("package_main_id") int package_main_id);

}
