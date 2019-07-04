package com.annaru.upms.service;

import com.annaru.upms.entity.vo.SysDoctorVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysDoctor;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface ISysDoctorService extends IService<SysDoctor> {

    /**
     * 多表页面信息查询
     * @param params
     * @return
     */
    PageUtils getDataPage(Map <String, Object> params);


    SysDoctorVo getOne(Map <String, Object> params);

    /**
     * @author zk
     */
    SysDoctor getDoctor(Map<String,Object> params);

    /**
      * @Description:家庭医生详情
      * @Author: wh
      * @Date: 2019/6/26 15:52
      */
    SysDoctor selectByDoctorNoAndUserId(String doctorNo,String userId);

    /**
     * @Description 根据userId或doctorNo得到医生详情
     * @Author zk
     * @Date: 2019-07-04
     */
    SysDoctor getDoctorByUdD0(String doctorNo, String userId);

}

