package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysMessage;
import java.util.List;
import java.util.Map;

/**
 * 消息列表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface ISysMessageService extends IService<SysMessage> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map <String, Object> params);


}

