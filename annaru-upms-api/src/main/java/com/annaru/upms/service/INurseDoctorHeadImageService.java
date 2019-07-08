package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.vo.NurseDoctorHeadImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 护士医生头像修改
 * @author wh
 * @date 2019-07-05 16:01:30
 */
public interface INurseDoctorHeadImageService extends IService<NurseDoctorHeadImage> {

    //修改护士头像
    Boolean UpdateNurseHeadImage(String nurseNo,String headImage);

    //修改医生头像
    Boolean UpdateDoctorHeadImage(String doctorNo,String headImage);


}

