package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysMessageTemplate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 消息模板
 *
 * @author wh
 * @date 2019-09-25 16:25:15
 */
public interface ISysMessageTemplateService extends IService<SysMessageTemplate> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * @Description:一个公共的查询消息方法模板通过消息类型
     * @Author: wh
     * @Date: 2019/9/25 17:21
     */
    SysMessageTemplate selectMessageTemplate(int businessCate);

}

