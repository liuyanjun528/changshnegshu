package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamHpvAgreement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * HPV条款
 * 
 * @author wh
 * @date 2019-10-11 09:35:38
 */
public interface ExamHpvAgreementMapper extends BaseMapper<ExamHpvAgreement> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamHpvAgreement> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
