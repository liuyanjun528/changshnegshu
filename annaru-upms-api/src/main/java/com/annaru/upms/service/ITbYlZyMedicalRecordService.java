package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.medical.TbYlZyMedicalRecord;
import com.annaru.upms.entity.medical.vo.TbYlZyMedicalRecordListVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * tb_yl_zy_medical_record(住院就诊记录表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbYlZyMedicalRecordService extends IService<TbYlZyMedicalRecord> {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param jzlsh	 门诊就诊流水号
     * @return
     */
    TbYlZyMedicalRecord getYlZyMedicalRecord(String yljgdm, String jzlsh);

    /**
     * 根据卡号分页查询住院记录
     * @param params
     * @return
     */
    PageUtils getJyjlPage(Map<String, Object> params);

    /**
     * 根据卡号查询住院住院记录
     * @param kh 卡号
     * @return
     */
    List<TbYlZyMedicalRecordListVo> getJyjl(String kh);

    /**
     * 根据卡号查询近一年的住院记录
     * @param kh 卡号
     * @return
     */
    List<TbYlZyMedicalRecordListVo> getJyjlCs(String kh);

}

