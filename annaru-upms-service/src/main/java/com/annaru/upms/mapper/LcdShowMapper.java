package com.annaru.upms.mapper;

import com.annaru.upms.entity.LcdShow;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * @author wh
 * @date 2019-03-29 11:33:31
 */
public interface LcdShowMapper extends BaseMapper<LcdShow> {

    /**
     * @Description: 查询当天叫号数据
     * @param
     * @Author: XCK
     * @Date: 2019/3/28
     * @return
     */
    List<LcdShow> selectLcdShowByMysql();


    /**
     * @Description: 获取外部叫号数据
     * @param
     * @Author: XCK
     * @Date: 2019/3/28
     * @return
     */
    @DS("sqlserver")
    List<LcdShow> selectLcdShowBySqlServer();



}
