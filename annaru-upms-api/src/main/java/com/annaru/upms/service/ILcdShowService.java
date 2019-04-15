package com.annaru.upms.service;

import com.annaru.upms.entity.LcdShow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wh
 * @date 2019-03-29 11:33:31
 */
public interface ILcdShowService extends IService<LcdShow> {

    /**
     * 查询主表
     */
    List<LcdShow> getLcdShowListByMysql();

    /**
     * 查询从表
     */
    List<LcdShow> getLcdShowListBySqlServer();

    /**
     *根据IP查询 更新叫号数据
     */
    void updateByXpdz(LcdShow lcdShow);

    /**
     * 根据IP查询 叫号数据
     */
    LcdShow getByXpdz(String xpdz);

    /**
     * 清空数据库所有数据
     */
    void clearEmpty();

    /**
     * 获取当前小屏连接设备信息
     */
    List<Map<String, String>> getLcdSmallList();

    /**
     * 获取当前大屏连接设备信息
     */
    List<Map<String, String>> getLcdBigList();
}

