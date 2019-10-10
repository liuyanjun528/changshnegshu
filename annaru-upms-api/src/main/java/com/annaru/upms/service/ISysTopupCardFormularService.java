package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysTopupCardFormular;
import java.util.List;
import java.util.Map;

/**
 * 卡规则
 *
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
public interface ISysTopupCardFormularService extends IService<SysTopupCardFormular> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

