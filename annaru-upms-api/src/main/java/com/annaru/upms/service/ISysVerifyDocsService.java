package com.annaru.upms.service;

import com.annaru.upms.entity.vo.SysVerifyDocsVoZ;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysVerifyDocs;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 认证资料
 *
 * @author zk
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
     * @Author  zk
     * @Date  2019-06-10 11:37
     */
    public boolean saveDocsBasics(SysVerifyDocsVoZ sysVerifyDocsVoZ, List<SysVerifyDocs> sysVerifyDocsList1);

    /**
     * 查询护士、医生认证信息
     * @param userId
     * @param identification 1 护士，2医生
     * @return
     */
    SysVerifyDocsVoZ selectVerNurse(String userId,Integer identification);

    /**
     * @Description:用户实名认证
     * @Author: wh
     * @Date: 2019/8/27 11:49
     */
    SysVerifyDocs saveUserVerify(SysVerifyDocs sysVerifyDocs);
    /**
     * @Description:查询是否审核及审核结果
     * @Author: wh
     * @Date: 2019/9/18 14:41
     */
    SysVerifyDocs selectResult(String userId,Integer cates);

    /**
     * 根据条件修改条件
     * @author zk
     * @date 2019/10/16
     * @return
     */
    boolean updateByUserId(SysVerifyDocs sysVerifyDocs);

    /**
     * 根据用户编号查询集合
     * @author zk
     * @date 2019/10/16
     * @param userId
     * @return
     */
    List<SysVerifyDocs> getListByUserId(String userId);

}

