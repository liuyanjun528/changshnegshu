package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysAppraisal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 家庭医生评分
 *
 * @author xck
 * @date 2019-05-22 11:33:58
 */
public interface SysAppraisalMapper extends BaseMapper<SysAppraisal> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysAppraisal> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
      * @Description:查询评价星数
      * @param userId 评价人
      * @return:
      * @Author: wh 2019/6/3 16:18
      */
    List<SysAppraisal> selectStart(@Param("userId") String userId);

    SysAppraisal getOne(@Param("params") Map<String, Object> params);
}
