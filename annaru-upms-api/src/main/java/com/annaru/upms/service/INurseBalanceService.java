package com.annaru.upms.service;

import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.ExamCates;
import com.annaru.upms.entity.vo.NurseBalance;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * @Description:护士完成的累计收入
     * @Author: wh
     * @Date: 2019/7/11 10:25
     */
    Double selectTotalMoney(String nurseNo);


}

