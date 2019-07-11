package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderAdditionalInfo;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.entity.vo.UserCardVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import java.util.Map;

/**
 * 预约其他信息
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
public interface OrderAdditionalInfoMapper extends BaseMapper<OrderAdditionalInfo> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderAdditionalInfo> selectDataPage(Page page, @Param("params") Map<String, Object> params);


    /**
      * @Description:体检人信息查询 用于企业门诊绿通
      * @Author: wh
      * @Date: 2019/7/9 9:18
      */
    UserCards selectUserOrRelativeInfo(@Param("userId") String userId,@Param("relativeId") String relativeId);


}
