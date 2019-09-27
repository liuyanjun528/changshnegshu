package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysMessageTemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 消息模板
 * @author wh
 * @date 2019-09-25 16:25:15
 */
public interface SysMessageTemplateMapper extends BaseMapper<SysMessageTemplate> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysMessageTemplate> selectDataPage(Page page, @Param("params") Map<String, Object> params);


    /**
      * @Description:一个公共的查询消息方法模板通过消息类型
      * @Author: wh
      * @Date: 2019/9/25 17:21
      */
    SysMessageTemplate selectMessageTemplate(@Param("businessCate") int businessCate);


}
