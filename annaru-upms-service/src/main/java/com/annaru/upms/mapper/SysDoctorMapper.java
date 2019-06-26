package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysDoctor;
import com.annaru.upms.entity.vo.SysDoctorVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 家庭医生
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface SysDoctorMapper extends BaseMapper<SysDoctor> {

    /**
     * 多表页面信息查询
     * @param page
     * @param params
     * @return
     */
    IPage<SysDoctor> selectDataPage(Page page, @Param("params") Map <String, Object> params);

    SysDoctorVo getOne(@Param("params") Map <String, Object> params);

    /**
     * @author zk
     */
    SysDoctor getDoctor(@Param("params") Map <String, Object> params);

    /**
      * @Description:家庭医生详情
      * @Author: wh
      * @Date: 2019/6/26 15:41
      */
    SysDoctor selectByDoctorNoAndUserId(@Param("doctorNo") String doctorNo,@Param("userId")String userId);
}
