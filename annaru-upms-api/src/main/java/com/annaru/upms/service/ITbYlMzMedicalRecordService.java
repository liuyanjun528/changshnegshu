package com.annaru.upms.service;

import com.annaru.upms.entity.medical.TbYlMzMedicalRecord;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordDetailVo;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordListVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * tb_yl_mz_medical_record(门诊就诊记录表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface ITbYlMzMedicalRecordService extends IService<TbYlMzMedicalRecord> {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param jzlsh	 门诊就诊流水号
     * @return
     */
    TbYlMzMedicalRecord getYlMzMedicalRecord(String yljgdm, String jzlsh);

    /**
     * 根据卡号查询就诊记录
     * @param kh 卡号
     * @return
     */
    List<TbYlMzMedicalRecordListVo> getJzjl(String kh);

    /**
     * 根据就诊流水号查询就诊记录
     * @param jzlsh 就诊流水号
     * @return
     */
    TbYlMzMedicalRecord getJzjlByJzlsh(String jzlsh);

    /**
     * 根据就诊记录id查询对应的就诊记录
     * @param csid 就诊记录id
     * @return
     */
    TbYlMzMedicalRecordDetailVo getJzjlById(String csid);
}

