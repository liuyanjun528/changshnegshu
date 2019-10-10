package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.MallArticalFansLog;
import java.util.List;
import java.util.Map;

/**
 * 点赞记录
 *
 * @author zk
 * @date 2019-10-10 17:26:24
 */
public interface IMallArticalFansLogService extends IService<MallArticalFansLog> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 通过这个对象的参数得到这个对象
     * @param mallArticalFansLog
     * @return
     * @author zk
     * @date 2019/10/10
     */
    MallArticalFansLog getOneByMallArticalFansLog(MallArticalFansLog mallArticalFansLog);

    /**
     * 取消点赞
     * @author zk
     * @date 2019/10/10
     */
    boolean cancelPraise(MallArticalFansLog mallArticalFansLog);


}

