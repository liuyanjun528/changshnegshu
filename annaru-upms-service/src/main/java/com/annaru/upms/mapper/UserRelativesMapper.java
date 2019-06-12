package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserRelatives;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户亲属信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface UserRelativesMapper extends BaseMapper<UserRelatives> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserRelatives> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
      * @Description: 查询全部亲属
      * @Author: wh
      * @Date: 2019/6/4 9:35
      */
    List<UserRelatives> selectAll(@Param("userId") String userId);

    /**
      * @Description:删除亲属
      * @Author: wh
      * @Date: 2019/6/11 13:37
      */
    int DeleteRelative(@Param("userId")String userId,@Param("relativeId") String relativeId);

}
