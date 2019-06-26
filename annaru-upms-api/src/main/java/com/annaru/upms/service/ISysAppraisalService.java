package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysAppraisal;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 家庭医生评分
 *
 * @author xck
 * @date 2019-05-22 11:33:58
 */
public interface ISysAppraisalService extends IService<SysAppraisal> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    /**
     * @Description:查询评价星数
     * @param userId 评价人
     * @return:
     * @Author: wh 2019/6/3 16:18
     */
    List<SysAppraisal> selectStart(String userId);

    SysAppraisal selectOne(Map<String, Object> params);

}

