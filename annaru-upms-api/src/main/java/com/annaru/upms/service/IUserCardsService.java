package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.INTERFACE_AUTHORIZATION;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.entity.vo.UserCardInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 用户绑卡信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface IUserCardsService extends IService<UserCards> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 通过用户ID查询
     *
     * @param userId 用户ID
     * @return
     */
    List<UserCards> selectByStatus(String userId);


    /**
     * 查询企业门诊绿通预约人信息
     * @param userId 用户ID
     * @return
     */
    UserCardInfoVo getGreenPassUserInfoByUserId(String userId);
    UserCardInfoVo getGreenPassUserInfoByRelativeId(String relativeId);


    /**
     * @Description: 通过用户编号修改个人信息和医保卡号
     * @Author: wh
     * @Date: 2019/6/11 11:00
     */
    int updateCardAndBasic(String userId,String cardNo);

    List<INTERFACE_AUTHORIZATION> selectByUserId(String userId);
}

