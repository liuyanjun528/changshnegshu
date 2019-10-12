package com.annaru.upms.mapper;

import com.annaru.upms.entity.MallExamPackageRecommend;
import com.annaru.upms.entity.vo.MallExamPackageRecommendExtends;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 商城推荐产品
 * 
 * @author zk
 * @date 2019-10-10 13:11:23
 */
public interface MallExamPackageRecommendMapper extends BaseMapper<MallExamPackageRecommend> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<MallExamPackageRecommend> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /***
     * @Author: zxk
     * @Date: 2019/10/10
     */
    List<MallExamPackageRecommendExtends> selectAll();

}
