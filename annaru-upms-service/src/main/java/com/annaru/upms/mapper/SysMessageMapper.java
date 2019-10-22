package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 消息列表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface SysMessageMapper extends BaseMapper<SysMessage> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysMessage> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * @Author：wh
     * @Description：修改消息为已读
     * @Date:2019/10/21 13:37
     */
    int updateSysMessageIsRead(@Param("sysId") int sysId);

    /**
     * @Author：wh
     * @Description：清空消息 把消息假删
     * @Date:2019/10/21 13:37
     */
    int updateSysMessageIsDeleted(@Param("userId") String userId);

    /**
     * @Author：wh
     * @Description：未读条数
     * @Date:2019/10/22 15:39
     */
    int selectNotRead(@Param("userId") String userId);
}
