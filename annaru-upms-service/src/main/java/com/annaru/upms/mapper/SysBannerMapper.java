package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysBanner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 首页Banner
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface SysBannerMapper extends BaseMapper<SysBanner> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysBanner> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /*** 方法描述:查询所有Banner
    * @params: []
    * @return: java.util.List<com.annaru.upms.entity.SysBanner>
    * @Author: jyehui
    * @Date: 2019/7/1 12:07
    */
    List<SysBanner> selectAll();


}
