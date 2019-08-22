package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.UserFamilyDoctor;
import com.annaru.upms.entity.vo.UserFamilyDoctorVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 客户家庭医生
 *
 * @author xck
 * @date 2019-05-22 10:07:32
 */
public interface IUserFamilyDoctorService extends IService<UserFamilyDoctor> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    UserFamilyDoctorVo getUserFDInfo(Map<String, Object> params);

    UserFamilyDoctor getUserFD(Map<String,Object> params);


    /**
     * @Description:家庭医生购买
     * @Author: wh
     * @Date: 2019/8/22 9:57
     */
    Boolean saveFamilyDoctor(OrderMain orderMain);




}

