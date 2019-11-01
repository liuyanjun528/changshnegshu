package com.annaru.upms.service;

import com.annaru.common.result.ResultMap;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysTopupCardCate;
import java.util.List;
import java.util.Map;

/**
 * 充值\套餐卡类别
 *
 * @author jyehui
 * @date 2019-10-10 16:48:08
 */
public interface ISysTopupCardCateService extends IService<SysTopupCardCate> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * 充值卡详情
     * @param sysId
     * @return
     */
    SysTopupCardCate detail(int sysId);


    ResultMap activation(String serialNo, String activepin);
}

