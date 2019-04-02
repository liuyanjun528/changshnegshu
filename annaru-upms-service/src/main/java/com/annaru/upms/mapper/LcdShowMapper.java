package com.annaru.upms.mapper;

import com.annaru.upms.entity.LcdShow;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wh
 * @date 2019-03-29 11:33:31
 */
public interface LcdShowMapper extends BaseMapper<LcdShow> {

    /**
     * @Description: 根据IP查询最新叫号数据
     * @param
     * @Author: wh
     * @Date: 2019/4/2
     * @return
     */
    LcdShow selectByXpdz(@Param("xpdz") String xpdz);

    /**
     * @Description: 查询当天叫号数据
     * @param
     * @Author: wh
     * @Date: 2019/3/28
     * @return
     */
    List<LcdShow> selectLcdShowByMysql();


    /**
     * @Description: 获取外部叫号数据
     * @param
     * @Author: wh
     * @Date: 2019/3/28
     * @return
     */
    @DS("sqlserver")
    List<LcdShow> selectLcdShowBySqlServer();

    /**
     * 根据xpdz更新数据
     * @param lcdShow
     */
    void updateByXpdz(LcdShow lcdShow);
}
