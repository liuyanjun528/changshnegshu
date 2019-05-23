package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.upms.entity.UserSurveyItems;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
public interface IUserSurveyItemsService extends IService<UserSurveyItems> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

