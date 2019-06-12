package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysVerifyDocs;
import java.util.List;
import java.util.Map;

/**
 * 认证资料
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
public interface ISysVerifyDocsService extends IService<SysVerifyDocs> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

