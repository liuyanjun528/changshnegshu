package com.annaru.upms.service;

import com.annaru.upms.entity.LcdShow;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * 
 *
 * @author wh
 * @date 2019-03-29 11:33:31
 */
public interface ILcdShowService extends IService<LcdShow> {


    //查询主表
    List<LcdShow> getLcdShowListByMysql();

    //查询从表
    List<LcdShow> getLcdShowListBySqlServer();


}

