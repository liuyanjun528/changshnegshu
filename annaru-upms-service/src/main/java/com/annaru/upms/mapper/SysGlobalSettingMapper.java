package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysGlobalSetting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 系统全局参数
 * 
 * @author xck
 * @date 2019-08-21 14:49:41
 */
public interface SysGlobalSettingMapper extends BaseMapper<SysGlobalSetting> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysGlobalSetting> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
