package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamPackageAppend;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 套餐赠送服务
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface IExamPackageAppendService extends IService<ExamPackageAppend> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


    /**
     * 根据套餐ID查询套餐赠送的服务
     * @param pack_main_id
     * @return
     */
    List<ExamPackageAppend> selectExamName(@Param("package_main_id") int pack_main_id);


}

