package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserRelatives;
import com.annaru.upms.entity.vo.UserRelativesDetailVoZ;
import com.annaru.upms.entity.vo.UserRelativesVoZ;
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

    /**
     * 亲属管理列表
     * @author zk
     * @date 2019-07-02
     */
    UserRelativesVoZ managerUserRelativesVoZ(String userId);

    /**
     * 亲属列表
     * @author zk
     * @date 2019-07-02
     */
    List<UserRelatives> getUserRelativesList(String userId);

    /**
     * @Description:删除亲属
     * @Author: wh
     * @Date: 2019/6/11 13:37
     */
    int DeleteRelative(String userId,String relativeId);

    /**
     * 修改亲属基本信息
     * @author zk
     * @date 2019-07-02
     */
    boolean updateUserRelatives(UserRelatives userRelatives1, UserRelativesDetailVoZ userRelativesDetailVoZ);

    /**
     * 添加亲属基本信息
     * @author zk
     * @date 2019-07-02
     */
    boolean saveUserRelatives(UserRelativesDetailVoZ userRelativesDetailVoZ, String relativeId, String userId);

    /**
     * 删除亲属基本信息
     * @author zk
     * @date 2019-07-02
     */
    boolean deleteUserRelatives(UserRelatives userRelatives1, UserRelativesDetailVoZ userRelativesDetailVoZ);

}

