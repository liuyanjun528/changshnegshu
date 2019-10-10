package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysTopupCardFormular;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 卡规则
 * 
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
public interface SysTopupCardFormularMapper extends BaseMapper<SysTopupCardFormular> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysTopupCardFormular> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
