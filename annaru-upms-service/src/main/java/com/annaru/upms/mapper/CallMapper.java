package com.annaru.upms.mapper;

import com.annaru.upms.entity.Call;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author wh
 * @date 2019-03-26 09:58:57
 */
public interface CallMapper extends BaseMapper<Call> {
    
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
