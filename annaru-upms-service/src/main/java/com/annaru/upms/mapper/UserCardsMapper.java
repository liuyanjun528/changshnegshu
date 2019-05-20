package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserCards;
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
     * @param status 是否绑卡
     * @param card_cates 绑卡类型
     * @return
     */
    List<UserCards> selectByStatus(@Param("status") int status, @Param("card_cates") int card_cates);


    /**
     * 添加绑卡操作
     * @param cards
     * @return
     */
    int insertCardAndBaseAndInstitution(UserCards cards);
}
