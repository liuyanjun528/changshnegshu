package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamDetail;
import com.annaru.upms.entity.ExamMaster;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 体检项目
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface IExamDetailService extends IService<ExamDetail> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

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
    List<ExamDetail> selectByType(Integer ecId);

    ExamDetail getItem(Map<String, Object> params);
}

