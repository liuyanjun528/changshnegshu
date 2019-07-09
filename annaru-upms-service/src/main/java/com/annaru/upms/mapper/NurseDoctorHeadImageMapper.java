package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.vo.NurseDoctorHeadImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 护士医生头像修改
 * @author wh
 * @date 2019-07-05 16:01:30
 */
public interface NurseDoctorHeadImageMapper extends BaseMapper<NurseDoctorHeadImage> {

   //修改护士头像
    Boolean UpdateNurseHeadImage(@Param("nurseNo")String nurseNo,@Param("headImage")String headImage);

    //修改医生头像
    Boolean UpdateDoctorHeadImage(@Param("doctorNo")String doctorNo,@Param("headImage")String headImage);

}
