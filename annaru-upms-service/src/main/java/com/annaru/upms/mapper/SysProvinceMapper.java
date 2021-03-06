package com.annaru.upms.mapper;

import com.annaru.upms.entity.SysProvince;
import com.annaru.upms.entity.vo.SysProvinceVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 省份信息表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
public interface SysProvinceMapper extends BaseMapper<SysProvince> {

    /**
     * 多表页面信息查询
     * @param page
     * @param params
     * @return
     */
    IPage<SysProvince> selectDataPage(Page page, @Param("params") Map <String, Object> params);

    List<SysProvinceVo> getlistAll();

}
