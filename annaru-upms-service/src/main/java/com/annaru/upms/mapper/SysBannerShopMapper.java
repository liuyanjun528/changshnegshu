package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysBannerShop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 商城banner
 * 
 * @author zk
 * @date 2019-10-10 13:11:54
 */
public interface SysBannerShopMapper extends BaseMapper<SysBannerShop> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysBannerShop> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /*** 查询所有商城Banner
     * @Author: zxk
     * @Date: 2019/10/10
     */
    List<SysBannerShop> selectAll();


}
