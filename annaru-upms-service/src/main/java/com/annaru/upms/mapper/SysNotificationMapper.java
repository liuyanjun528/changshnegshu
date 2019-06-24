package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysNotification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 公告表
 * 
 * @author jyh
 * @date 2019-06-21 10:38:39
 */
public interface SysNotificationMapper extends BaseMapper<SysNotification> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysNotification> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 查询所有公告
     * @return
     */
    List<SysNotification> selectAll();


}
