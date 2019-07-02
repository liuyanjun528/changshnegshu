package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 首页Banner
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface ISysBannerService extends IService<SysBanner> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /*** 方法描述:查询所有Banner
     * @params: []
     * @return: java.util.List<com.annaru.upms.entity.SysBanner>
     * @Author: jyehui
     * @Date: 2019/7/1 12:07
     */
    List<SysBanner> selectAll();


}

