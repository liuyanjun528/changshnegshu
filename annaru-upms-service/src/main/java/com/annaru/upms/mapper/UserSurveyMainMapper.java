package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserSurveyMain;
import com.annaru.upms.entity.vo.SysLinkageTypeVo;
import com.annaru.upms.entity.vo.UserSurveyMainVo;
import com.annaru.upms.entity.vo.UserSurveyVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.models.auth.In;
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

    UserSurveyVo getByUserId(@Param("params") Map<String, Object> params);

    /**
     * 数据登记主表
     * @author zk
     * @date 2019-06-121
     */
    UserSurveyMain getTimeByUserIdZ(@Param("params") Map<String, Object> params);

    /**
      * @Description:通过userId查询是否存在问卷记录
      * @Author: wh
      * @Date: 2019/7/5 10:51
      */
    int selectCount(@Param("userId")String userId);

}
