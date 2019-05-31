package com.annaru.upms.mapper;

import com.annaru.upms.entity.vo.HrEmployeeDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * HR员工详情
 *
 * @author wh
 * @date 2019-05-31 12:06:42
 */
public interface HrEmployeeDetailMapper extends BaseMapper<HrEmployeeDetail> {

    /**
     * 查询HR员工详情
     * @param userId
     * @return
     */
    List<HrEmployeeDetail> selectEmployeeDetail(@Param("userId") String userId, @Param("referenceNo") Integer referenceNo);


}
