package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.UserWallet;
import com.annaru.upms.entity.vo.NurseBalance;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @Description:护士收入信息
 * @Author: wh
 * @Date: 2019/7/11 10:24
 */
public interface INurseBalanceService extends IService<NurseBalance> {

    /**
     * @Description:护士完成的累计单数
     * @Author: wh
     * @Date: 2019/7/11 10:25
     */
    int selectSingular(String nurseNo);

    /**
     * @Description:护士应收入
     * @Author: wh
     * @Date: 2019/7/11 10:25
     */
    Double selectTotalMoney(String nurseNo);
    /**
     * @Description:护士本周累计收入
     * @Author: wh
     * @Date: 2019/9/26 15:26
     */
    Double selectTotalMoneyByWeek( String nurseNo);

    /**
     * @Description:护士-我的余额   到账金额-提现金额 =余额
     * @Author: wh
     * @Date: 2019/7/12 15:54
     */
    Double selectBalance( String userId);


    /**
     * @Description:护士收入明细
     * @Author: wh
     * @Date: 2019/7/12 17:54
     */
    List<UserWallet> selectMoneyInfoList(Map<String, Object> params);

}

