package com.annaru.upms.service;

import com.annaru.upms.entity.ExamPackageDetail;
import com.annaru.upms.entity.vo.ExamChooseVo;
import com.annaru.upms.entity.vo.ExamExtensionVo;
import com.annaru.upms.entity.vo.ExamPackageDetailVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 套餐详细
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface IExamPackageDetailService extends IService<ExamPackageDetail> {

    List<ExamChooseVo> getChoosen(Map<String, Object> params);

    List<ExamExtensionVo> getEEChoosen(Map<String,Object> params);

    List<ExamPackageDetailVo> getMasterList(Integer examMainId);
}

