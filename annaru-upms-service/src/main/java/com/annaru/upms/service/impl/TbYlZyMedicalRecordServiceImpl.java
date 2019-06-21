package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbYlZyMedicalRecord;
import com.annaru.upms.entity.medical.vo.TbYlZyMedicalRecordListVo;
import com.annaru.upms.mapper.TbYlZyMedicalRecordMapper;
import com.annaru.upms.service.ITbYlZyMedicalRecordService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * tb_yl_mz_medical_record(门诊就诊记录表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbYlZyMedicalRecordServiceImpl extends ServiceImpl<TbYlZyMedicalRecordMapper, TbYlZyMedicalRecord> implements ITbYlZyMedicalRecordService {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param jzlsh	 门诊就诊流水号
     * @return
     */
    @Override
    @DS("oracle")
    public TbYlZyMedicalRecord getYlZyMedicalRecord(String yljgdm, String jzlsh) {
        return this.baseMapper.getYlZyMedicalRecord(yljgdm, jzlsh);
    }

    /**
     * 根据卡号查询住院就诊记录
     * @param kh 卡号
     * @return
     */
    @Override
    @DS("oracle")
    public List<TbYlZyMedicalRecordListVo> getJyjl(String kh) {
        return this.baseMapper.getJyjl(kh);
    }


}
