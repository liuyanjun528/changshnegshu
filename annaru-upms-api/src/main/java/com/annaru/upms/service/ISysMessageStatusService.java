package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysMessageStatus;
import java.util.List;
import java.util.Map;

/**
 * 系统消息已读标记
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface ISysMessageStatusService extends IService<SysMessageStatus> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map <String, Object> params);


}

