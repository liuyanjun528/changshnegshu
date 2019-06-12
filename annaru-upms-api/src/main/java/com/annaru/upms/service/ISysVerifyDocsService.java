package com.annaru.upms.service;

import com.annaru.upms.entity.vo.SysVerifyDocsVoZ;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysVerifyDocs;
import java.util.List;
import java.util.Map;

/**
 * 认证资料
 *
 * @author xck
 * @date 2019-06-10 14:59:12
 */
public interface ISysVerifyDocsService extends IService<SysVerifyDocs> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * @Description 选择职业：医生、护士认证
     * @Param   SysVerifyDocsVoZ
     * @Author  wh
     * @Date  2019/6/4 11:37
     */
    public boolean saveDocsBasics(SysVerifyDocsVoZ sysVerifyDocsVoZ);


}

