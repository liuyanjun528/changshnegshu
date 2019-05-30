package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysLinkageType;
import com.annaru.upms.entity.vo.SysLinkageTypeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
public interface SysLinkageTypeMapper extends BaseMapper<SysLinkageType> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysLinkageType> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    List<SysLinkageTypeVo> getList(@Param("params") Map<String, Object> params);
}
