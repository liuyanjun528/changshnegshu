package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.vo.UserCardVo;
import com.annaru.upms.entity.vo.UserExamMainDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface IUserBasicService extends IService<UserBasic> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 根据条件查询某个用户
     * @param params
     * @return
     */
    UserBasic selectByData(Map<String, Object> params);

    /**
     * 根据条件修改某个用户
     * zk
     * @param params
     * @return
     */
    boolean updateBySysId(Map<String, Object> params);

    /**
     * 根据条件查询某个用户信息与医生信息
     * @author zk
     * @param params
     * @return
     */
    UserBasic selectDoctorByData(Map<String, Object> params);

    /**
     * 根据条件查询某个用户信息与护士信息
     * @author zk
     * @param params
     * @return
     */
    UserBasic selectNurseByData(Map<String, Object> params);

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
     * @return
     */
    int updateOldPwd(@Param("password") String password, @Param("userId") String userId);
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
    boolean selectEntityHealthy(String userId);

    /**
     * @Description: 通过sysId修改最后登录时间
     * @Author: zk
     * @Date: 2019/6/24
     */
    boolean updateLastTimeBySysId(UserBasic userBasic);

    /**
     * 企业用户的购买的服务的 描述 开始时间 结束时间
     * @uthor zk
     * @date 2019-07-29
     */
    List<UserExamMainDetail> getUserExamMainDetail(Map<String, Object> params);

    /**
     * 上传授权图片的url
     * @uthor zk
     * @date 2019-08-16
     */
    boolean uploadAuthorizationUrl(Integer sysId, String authorizationUrl);

    /**
     * 通过用户编号修改身份证和性别
     * @uthor zk
     * @date 2019-9-26
     */
    boolean updateUserBascByParams(Map<String, Object> params);

    /**
     * 查询支付密码状态
     * @param userId
     * @return
     */
    ResultMap  paymentPinnoStatus(String userId);

    /**
     * 设置支付密码
     * @param userId
     * @param paymentPinno
     * @return
     */
    ResultMap initPaymentPinno(String userId, String paymentPinno);

    ResultMap verificationPaymentPinno(String sysId, String paymentPinno);

    ResultMap validated(String userId, String cellphoneNo);
}

