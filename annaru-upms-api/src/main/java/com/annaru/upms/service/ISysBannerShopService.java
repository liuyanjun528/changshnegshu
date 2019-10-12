package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysBannerShop;
import java.util.List;
import java.util.Map;

/**
 * 商城banner
 *
 * @author zk
 * @date 2019-10-10 13:11:54
 */
public interface ISysBannerShopService extends IService<SysBannerShop> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /*** 查询所有商城Banner
     * @Author: zxk
     * @Date: 2019/10/10
     */
    List<SysBannerShop> selectAll();


}

