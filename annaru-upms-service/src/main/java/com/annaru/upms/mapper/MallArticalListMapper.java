package com.annaru.upms.mapper;

import com.annaru.upms.entity.MallArticalList;
import com.annaru.upms.entity.vo.MallArticalFansLogExtends;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 商城文章阅读
 * 
 * @author zk
 * @date 2019-10-10 13:11:23
 */
public interface MallArticalListMapper extends BaseMapper<MallArticalList> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<MallArticalList> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /***
     * 根据条件查询商城文章阅读
     * @Author: zxk
     * @Date: 2019/10/10
     */
    List<MallArticalList> selectAll();

    /***
     * 根据条件查询所有的商城文章详情
     * @Author: zxk
     * @Date: 2019/10/10
     */
    MallArticalFansLogExtends mallArticalDetail(@Param("params") Map<String, Object> params);

    /**
     * 根据条件修改这个对象
     * @return
     * @author zk
     * @date 2019/10/10
     */
    int updateMallArticalByMallArtical(@Param("mallArticalList") MallArticalList mallArticalList);

}
