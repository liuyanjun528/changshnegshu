package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamPackageDetail;
import com.annaru.upms.entity.vo.ExamChooseVo;
import com.annaru.upms.entity.vo.ExamExtensionVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 套餐详细
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface ExamPackageDetailMapper extends BaseMapper<ExamPackageDetail> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamPackageDetail> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    List<ExamChooseVo> getChoosen(@Param("params") Map<String, Object> params);

    List<ExamExtensionVo> getEEChoosen(@Param("params") Map<String, Object> params);
}
