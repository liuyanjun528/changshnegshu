package com.annaru.upms.mapper;

import com.annaru.upms.entity.Call;
import com.annaru.upms.entity.LcdShow;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
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
    List<Call> selectCallByMysql();


    /**
     * @Description: 获取外部叫号数据
     * @param
     * @Author: XCK
     * @Date: 2019/3/28
     * @return
     */
    @DS("oracle")
    List<Call> selectCallByOracle();



}
