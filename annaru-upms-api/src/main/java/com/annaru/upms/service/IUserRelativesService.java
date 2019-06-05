package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserRelatives;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 用户亲属信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface IUserRelativesService extends IService<UserRelatives> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * @Description: 查询全部亲属
     * @Author: wh
     * @Date: 2019/6/4 9:35
     */
    List<UserRelatives> selectAll(String userId);

}

