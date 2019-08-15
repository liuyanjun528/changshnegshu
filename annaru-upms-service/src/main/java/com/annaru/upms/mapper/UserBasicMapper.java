package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.vo.UserCardVo;
import com.annaru.upms.entity.vo.UserExamMainDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface UserBasicMapper extends BaseMapper<UserBasic> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserBasic> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    UserBasic selectByData(@Param("params") Map<String, Object> params);
    /**
     * 根据条件修改某个用户
     * zk
     * @param params
     * @return
     */
    int updateBySysId(@Param("params") Map<String, Object> params);

    UserBasic selectDoctorByData(@Param("params") Map<String, Object> params);

    UserBasic selectNurseByData(@Param("params") Map<String, Object> params);


    /**
     * 通过手机验证码 修改密码
     * @param password
     * @return
     */
    int setPwd(@Param("password") String password,@Param("cellphoneNo")String cellphoneNo);

    /**
     * 通过旧密码修改密码
     * @param password
     * @param userId
     * wh
     */
    int updatePwd(@Param("password") String password, @Param("userId") String userId);
    UserBasic selectByUid(@Param("userId") String userId);


    /**
     * @Description: 通过用户编号修改个人信息和医保卡号
     * @Author: wh
     * @Date: 2019/6/11 11:00
     */
    int updateCardAndBasics(UserCardVo userCardVo);

    /**
     * 查询用户是否拥有健康服务
     * @param userId
     * @return
     */
    int selectEntityHealthy(@Param("userId") String userId);

    /**
     * @Description: 通过sysId修改最后登录时间
     * @Author: zk
     * @Date: 2019/6/24
     */
    int updateLastTimeBySysId(@Param("userBasic") UserBasic userBasic);

    /**
     * 企业用户的购买的服务的 描述 开始时间 结束时间
     * @uthor zk
     * @date 2019-07-29
     */
    List<UserExamMainDetail> getUserExamMainDetail(@Param("params") Map<String, Object> params);

}
