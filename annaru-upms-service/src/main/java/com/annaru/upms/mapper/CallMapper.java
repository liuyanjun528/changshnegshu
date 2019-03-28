package com.annaru.upms.mapper;

import com.annaru.upms.entity.Call;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author wh
 * @date 2019-03-26 09:58:57
 */
public interface CallMapper extends BaseMapper<Call> {

    //查询主表
    List<Call> findAll();




}
