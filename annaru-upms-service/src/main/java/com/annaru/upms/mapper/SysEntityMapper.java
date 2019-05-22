package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 分布式体检客户机构
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface SysEntityMapper extends BaseMapper<SysEntity> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysEntity> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
