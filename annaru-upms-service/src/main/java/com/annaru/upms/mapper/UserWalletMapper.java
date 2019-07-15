package com.annaru.upms.mapper;

import com.annaru.upms.entity.UserWallet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 用户钱包
 * 
 * @author wh
 * @date 2019-07-12 18:04:35
 */
public interface UserWalletMapper extends BaseMapper<UserWallet> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<UserWallet> selectDataPage(Page page, @Param("params") Map<String, Object> params);


}
