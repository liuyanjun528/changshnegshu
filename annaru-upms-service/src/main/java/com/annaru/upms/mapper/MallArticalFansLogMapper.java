package com.annaru.upms.mapper;

import com.annaru.upms.entity.MallArticalFansLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 点赞记录
 * 
 * @author zk
 * @date 2019-10-10 17:26:24
 */
public interface MallArticalFansLogMapper extends BaseMapper<MallArticalFansLog> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<MallArticalFansLog> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 通过这个对象的参数得到这个对象
     * @param mallArticalFansLog
     * @return
     * @author zk
     * @date 2019/10/10
     */
    MallArticalFansLog getOneByMallArticalFansLog(@Param("mallArticalFansLog") MallArticalFansLog mallArticalFansLog);

    /**
     * 取消点赞
     * @author zk
     * @date 2019/10/10
     */
    int cancelPraise(@Param("mallArticalFansLog") MallArticalFansLog mallArticalFansLog);

}
