package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserCards;
import com.annaru.upms.entity.vo.UserCardInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户绑卡信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface UserCardsMapper extends BaseMapper<UserCards> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserCards> selectDataPage(Page page, @Param("params") Map<String, Object> params);


    /**
     * 通过已绑卡查询
     *
     * @param userId 用户ID
     * @return
     */
    List<UserCards> selectByStatus(@Param("userId") String userId);


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
    List<UserCardInfoVo> getGreenPassUserInfo(@Param("userId") String userId);

}
