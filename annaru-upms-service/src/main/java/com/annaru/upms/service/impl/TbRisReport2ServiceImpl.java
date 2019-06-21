package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.medical.TbRisReport2;
import com.annaru.upms.entity.medical.vo.TbRisReport2ListVo;
import com.annaru.upms.mapper.TbRisReport2Mapper;
import com.annaru.upms.service.ITbRisReport2Service;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * tb_ris_report2(影像检查报告表—通用格式)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Service
public class TbRisReport2ServiceImpl extends ServiceImpl<TbRisReport2Mapper, TbRisReport2> implements ITbRisReport2Service {

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param studyuid	检查号
     * @param instanceuid 报告流水号
     * @return
     */
    @Override
    @DS("oracle")
    public TbRisReport2 getRisReport2(String yljgdm, String studyuid, String instanceuid) {
        return  this.baseMapper.getRisReport2(yljgdm, studyuid, instanceuid);
    }

    /**
     * 根据卡号查询影像报告
     * @param kh 卡号
     * @return
     */
    @Override
    @DS("oracle")
    public List<TbRisReport2> getYxbg(String kh) {
        return this.baseMapper.getYxbg(kh);
    }

    /**
     * 根据就诊流水号查询影像报告
     * @param jzlsh 就诊流水号
     * @return
     */
    @Override
    @DS("oracle")
    public List<TbRisReport2ListVo> getYxbgByJzlsh(String jzlsh) {
        return this.baseMapper.getYxbgByJzlsh(jzlsh);
    }
}
