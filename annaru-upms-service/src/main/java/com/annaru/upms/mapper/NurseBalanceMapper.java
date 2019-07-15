package com.annaru.upms.mapper;

import com.annaru.upms.entity.ExamAppend;
import com.annaru.upms.entity.UserWallet;
import com.annaru.upms.entity.vo.NurseBalance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
  * @Description:护士收入信息
  * @Author: wh
  * @Date: 2019/7/11 10:24
  */
public interface NurseBalanceMapper extends BaseMapper<NurseBalance> {


    /**
      * @Description:护士完成的累计单数
      * @Author: wh
      * @Date: 2019/7/11 10:25
      */
    int selectSingular(@Param("nurseNo") String nurseNo);


    /**
     * @Description:护士应收入
     * @Author: wh
     * @Date: 2019/7/11 10:25
     */
    Double selectTotalMoney(@Param("nurseNo") String nurseNo);
    /**
      * @Description:护士-我的余额   到账金额-提现金额 =余额
      * @Author: wh
      * @Date: 2019/7/12 15:54
      */
    Double selectBalance1(@Param("userId") String userId);
    Double selectBalance2(@Param("userId") String userId);


    /**
      * @Description:护士收入明细
      * @Author: wh
      * @Date: 2019/7/12 17:54
      */
      List<UserWallet> selectMoneyInfoList(@Param("params") Map<String, Object> params);


}
