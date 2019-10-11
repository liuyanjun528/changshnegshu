package com.annaru.upms.service;

import com.annaru.upms.entity.vo.MallArticalFansLogExtends;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.MallArticalList;
import java.util.List;
import java.util.Map;

/**
 * 商城文章阅读
 *
 * @author zk
 * @date 2019-10-10 13:11:23
 */
public interface IMallArticalListService extends IService<MallArticalList> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

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
    MallArticalFansLogExtends mallArticalDetail(Map<String, Object> params);

    /**
     * 根据条件修改这个对象
     * @return
     * @author zk
     * @date 2019/10/10
     */
    boolean updateMallArticalByMallArtical(MallArticalList mallArticalList);

}

