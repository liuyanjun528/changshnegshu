package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserBasic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 用户基础信息
 * 
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface UserBasicMapper extends BaseMapper<UserBasic> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserBasic> selectDataPage(Page page, @Param("params") Map <String, Object> params);


}
