package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.entity.vo.UserCardInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

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
     * 添加绑卡操作
     * @param cards
     * @return
     */
    int insertCardAndBaseAndInstitution(UserCards cards);

    /**
     * 查询企业门诊绿通预约人信息
     * @param userId 用户ID
     * @return
     */
    List<UserCardInfoVo> getGreenPassUserInfo(String userId);

}

