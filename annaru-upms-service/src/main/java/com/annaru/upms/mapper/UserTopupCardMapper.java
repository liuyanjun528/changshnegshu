package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserTopupCard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xck
 * @date 2019-11-01 16:27:32
 */
public interface UserTopupCardMapper extends BaseMapper<UserTopupCard> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserTopupCard> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
