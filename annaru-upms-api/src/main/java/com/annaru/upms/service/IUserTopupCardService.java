package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserTopupCard;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xck
 * @date 2019-11-01 16:27:32
 */
public interface IUserTopupCardService extends IService<UserTopupCard> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

