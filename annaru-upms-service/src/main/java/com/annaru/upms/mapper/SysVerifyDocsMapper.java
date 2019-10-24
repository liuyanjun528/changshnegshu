package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysVerifyDocs;
import com.annaru.upms.entity.vo.SysVerifyDocsVoZ;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 认证资料
 *
 * @author xck
 * @date 2019-06-10 14:59:12
 */
public interface SysVerifyDocsMapper extends BaseMapper<SysVerifyDocs> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<SysVerifyDocs> selectDataPage(Page page, @Param("params") Map<String, Object> params);

    /**
     * 查询护士认证信息
     * @param userId
     * @return
     */
    SysVerifyDocsVoZ selectVerNurse(@Param("userId") String userId);

    /**
     * 查询医生认证信息
     * @param userId
     * @return
     */
    SysVerifyDocsVoZ selectVerDoctor(@Param("userId") String userId);


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
    SysVerifyDocs selectResult(@Param("userId") String userId,@Param("cates") Integer cates);

    /**
     * 根据条件修改条件
     * @author zk
     * @date 2019/10/16
     * @return
     */
    int updateByUserId(@Param("sysVerifyDocs") SysVerifyDocs sysVerifyDocs);

    /**
     * 根据用户编号查询集合
     * @author zk
     * @date 2019/10/16
     * @param userId
     * @return
     */
    List<SysVerifyDocs> getListByUserId(@Param("userId") String userId);

}
