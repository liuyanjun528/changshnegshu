package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysMessage;
import com.baomidou.mybatisplus.extension.service.IService;
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
    PageUtils getDataPage(Map<String, Object> params);
    /**
     * @Author：wh
     * @Description：修改消息为已读
     * @Date:2019/10/21 13:37
     */
    int updateSysMessageIsRead(int sysId);

    /**
     * @Author：wh
     * @Description：清空消息 把消息假删
     * @Date:2019/10/21 13:37
     */
    int updateSysMessageIsDeleted(String userId);


}

