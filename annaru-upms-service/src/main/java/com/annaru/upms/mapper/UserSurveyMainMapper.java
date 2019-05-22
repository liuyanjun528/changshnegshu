package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserSurveyMain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 用户问券调查
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
public interface UserSurveyMainMapper extends BaseMapper<UserSurveyMain> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserSurveyMain> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
