package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamHandoverSheet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 交接单
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
public interface ExamHandoverSheetMapper extends BaseMapper<ExamHandoverSheet> {

    /**
    * 多表页面信息查询
    * @param page
    * @param params
    * @return
    */
    IPage<ExamHandoverSheet> selectDataPage(Page page, @Param("params") Map<String, Object> params);


    /**
      * @Description:通过订单编号修改已有 未完成的预约记录
      * @Author: wh
      * @Date: 2019/6/11 16:22
      */
    int updateExamHandoverSheet(ExamHandoverSheet examHandoverSheet);

    /**
      * @Description:上传交接单 通过订单编号 实际为修改操作
      * @Author: wh
      * @Date: 2019/6/12 13:06
      */
    int updateExamHandoverSheetByOrderNo(ExamHandoverSheet examHandoverSheet);

    /**
     * @Description:查看交接单
     * @Author: wh
     * @Date: 2019/6/12 13:06
     */
    List<ExamHandoverSheet> selectExamHandoverSheet(@Param("orderNo") String orderNo);

    /**
     * @Description:删除定单通过 是否交接和订单编号
     * @Author: wh
     * @Date: 2019/6/12 13:06
     */
    int delExamHandoverSheet(@Param("orderNo") String orderNo,@Param("isHandovered") int isHandovered);

}
