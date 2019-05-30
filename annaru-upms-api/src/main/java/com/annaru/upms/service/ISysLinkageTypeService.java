package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.vo.SysLinkageTypeVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.upms.entity.SysLinkageType;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
public interface ISysLinkageTypeService extends IService<SysLinkageType> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    List<SysLinkageTypeVo> getList(Map<String, Object> params);
}

