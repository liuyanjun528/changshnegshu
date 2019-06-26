package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserAddress;
import com.annaru.upms.entity.medical.TbYlMzMedicalRecord;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordDetailVo;
import com.annaru.upms.entity.medical.vo.TbYlMzMedicalRecordListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * tb_yl_mz_medical_record(门诊就诊记录表)
 * @author lft
 * @date 2019-05-09 11:14:28
 */
public interface TbYlMzMedicalRecordMapper extends BaseMapper<TbYlMzMedicalRecord> {

    /**
     * 根据卡号分页查询就诊记录
     * @param params
     * @return
     */
    IPage<TbYlMzMedicalRecordListVo> getJzjlPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 根据原主键获取对象
     * @param yljgdm 医疗机构代码
     * @param jzlsh	 门诊就诊流水号
     * @return
     */
    TbYlMzMedicalRecord getYlMzMedicalRecord(@Param("yljgdm") String yljgdm, @Param("jzlsh") String jzlsh);

    /**
     * 根据卡号查询就诊记录
     * @param kh
     * @return
     */
    List<TbYlMzMedicalRecordListVo> getJzjl(@Param("kh") String kh);

    /**
     * 根据就诊流水号查询就诊记录
     * @param jzlsh
     * @return
     */
    TbYlMzMedicalRecord getJzjlByJzlsh(@Param("jzlsh") String jzlsh);

    /**
     * 根据就诊记录id查询对应的就诊记录
     * @param csid
     * @return
     */
    TbYlMzMedicalRecordDetailVo getJzjlById(@Param("csid") String csid);
}
