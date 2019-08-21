package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.upms.service.IExamPackageDetailService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 套餐详细
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"套餐详细管理"}, description = "套餐详细管理")
@RestController
@RequestMapping("upms/examPackageDetail")
public class ExamPackageDetailController extends BaseController {
    @Reference
    private IExamPackageDetailService examPackageDetailService;

}
