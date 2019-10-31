package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.SysNurse;
import com.annaru.upms.entity.vo.SysNurseVoZ;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 护士
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
public interface ISysNurseService extends IService<SysNurse> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    SysNurse getOne(Map <String, Object> params);

    /**
     * 得到一个护士对象
     * @author zk
     * @date 2019-07-01
     * @param params
     * @return
     */
    SysNurseVoZ getOneNurse(Map <String, Object> params);


    /**
     * @Author：wh
     * @Description：查询所有护士
     * @Date:2019/10/31 11:15
     */
    List<SysNurse> selectAllNurse();
}

