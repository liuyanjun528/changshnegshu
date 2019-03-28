package com.annaru.upms.service;

import com.annaru.upms.entity.Call;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * @author wh
 * @date 2019-03-26 09:58:57
 */
public interface ICallService extends IService<Call> {

    //查询主表
    List<Call> findAll();

    //查询从表
    List<Call> selectAll();


}

