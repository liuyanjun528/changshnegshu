package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbYlMzMedicalRecord;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordDetailVo;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordListVo;
import com.annaru.upms.mapper.TbYlMzMedicalRecordMapper;
import com.annaru.upms.service.ITbYlMzMedicalRecordService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * tb_yl_mz_medical_record(门诊就诊记录表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbYlMzMedicalRecordServiceImpl extends ServiceImpl<TbYlMzMedicalRecordMapper, TbYlMzMedicalRecord> implements ITbYlMzMedicalRecordService {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param jzlsh	 门诊就诊流水号
     * @return
     */
    @Override
    @DS("oracle")
    public TbYlMzMedicalRecord getYlMzMedicalRecord(String yljgdm, String jzlsh) {
        return this.baseMapper.getYlMzMedicalRecord(yljgdm, jzlsh);
    }

    /**
     * 根据卡号查询就诊记录
     * @param kh 卡号
     * @return
     */
    @Override
    @DS("oracle")
    public List<TbYlMzMedicalRecordListVo> getJzjl(String kh) {
        return this.baseMapper.getJzjl(kh);
    }

    /**
     * 根据就诊流水号查询就诊记录
     * @param jzlsh 就诊流水号
     * @return
     */
    @Override
    @DS("oracle")
    public TbYlMzMedicalRecord getJzjlByJzlsh(String jzlsh) {
        return this.baseMapper.getJzjlByJzlsh(jzlsh);
    }

    /**
     * 根据就诊记录id查询对应的就诊记录
     * @param csid 就诊记录id
     * @return
     */
    @Override
    @DS("oracle")
    public TbYlMzMedicalRecordDetailVo getJzjlById(String csid) {
        return this.baseMapper.getJzjlById(csid);
    }
}
