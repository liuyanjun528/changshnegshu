package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysNurse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 护士
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface SysNurseMapper extends BaseMapper<SysNurse> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysNurse> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    SysNurse getOne(@Param("params") Map <String, Object> params);

}
