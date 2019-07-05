package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.vo.UserSurveyMainVo;
import com.annaru.upms.entity.vo.UserSurveyVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.upms.entity.UserSurveyMain;
import java.util.List;
import java.util.Map;

/**
 * 用户问券调查
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
public interface IUserSurveyMainService extends IService<UserSurveyMain> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    int saveOne(UserSurveyMain userSurveyMain);

    UserSurveyVo getByUserId(Map<String,Object> params);

    /**
     * 根据用户编号和开始时间查询这条记录
     * @author zk
     * @date 2019-06-21
     */
    UserSurveyMain getTimeByUserIdZ(Map<String,Object> params);



    /**
     * @Description:通过userId查询是否存在问卷记录
     * @Author: wh
     * @Date: 2019/7/5 10:51
     */
    int selectCount(String userId);
}

