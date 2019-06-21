package com.annaru.upms.mapper;

import com.annaru.upms.entity.medical.TbYlZyMedicalRecord;
import com.annaru.upms.entity.medical.vo.TbYlZyMedicalRecordListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * tb_yl_zy_medical_record(住院就诊记录表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbYlZyMedicalRecordMapper extends BaseMapper<TbYlZyMedicalRecord> {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param jzlsh	 门诊就诊流水号
     * @return
     */
    TbYlZyMedicalRecord getYlZyMedicalRecord(@Param("yljgdm") String yljgdm, @Param("jzlsh") String jzlsh);

    /**
     * 根据卡号查询住院就诊记录
     * @param kh 卡号
     * @return
     */
    List<TbYlZyMedicalRecordListVo> getJyjl(@Param("kh") String kh);
}
