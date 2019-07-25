package com.annaru.upms.mapper;

import com.annaru.upms.entity.OrderExtensionSuggestion;
import com.annaru.upms.entity.vo.OrderExtensionSuggestionVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 进阶体检项目建议
 * 
 * @author xck
 * @date 2019-05-22 17:42:35
 */
public interface OrderExtensionSuggestionMapper extends BaseMapper<OrderExtensionSuggestion> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<OrderExtensionSuggestion> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    List<OrderExtensionSuggestionVo> getItems(@Param("params") Map<String, Object> params);

}
