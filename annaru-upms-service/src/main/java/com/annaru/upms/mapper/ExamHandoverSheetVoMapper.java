package com.annaru.upms.mapper;

import com.annaru.upms.entity.vo.ExamHandoverSheetVo;
import com.annaru.upms.entity.vo.examHandoverSheetVoWh;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 查询长生树护士端服务订单详情
 *
 * @author wh
 * @date 2019-06-10 14:47:53
 */
public interface ExamHandoverSheetVoMapper extends BaseMapper<ExamHandoverSheetVo> {

/**
  * @Description:
  * @Param: orderNo订单编号
  * @Author: wh
  * @Date: 2019/6/10 16:52
  */
    ExamHandoverSheetVo selectNurseOrderInfo(@Param("orderNo") String orderNo);


    /**
      * @Description:二维码内的信息
      * @Author: wh
      * @Date: 2019/7/10 12:26
      */
    examHandoverSheetVoWh selectUserInfo(@Param("orderNo") String orderNo);

}
