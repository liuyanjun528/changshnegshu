package com.annaru.upms.service;

import com.annaru.upms.entity.vo.MallExamPackageRecommendExtends;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.MallExamPackageRecommend;
import java.util.List;
import java.util.Map;

/**
 * 商城推荐产品
 *
 * @author zk
 * @date 2019-10-10 13:11:23
 */
public interface IMallExamPackageRecommendService extends IService<MallExamPackageRecommend> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /***
     * @Author: zxk
     * @Date: 2019/10/10
     */
    List<MallExamPackageRecommendExtends> selectAll();


}

