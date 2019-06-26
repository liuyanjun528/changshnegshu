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
     * 通过当前用户的消息类型查看消息
     * @param msgCate 消息类型
     * @return
     */
    IPage<SysMessage> selectMsgByMsgCate(Page page, @Param("params") Map<String, Object> params);
   // List<SysMessage> selectMsgByMsgCate(@Param("msgCate") int msgCate,@Param("userId") String userId);





}
