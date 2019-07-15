package com.annaru.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserWallet;
import java.util.List;
import java.util.Map;

/**
 * 用户钱包
 *
 * @author wh
 * @date 2019-07-12 18:04:35
 */
public interface IUserWalletService extends IService<UserWallet> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);


}

