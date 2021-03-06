package com.annaru.upms.service;

import com.annaru.upms.entity.vo.OrderExtensionSuggestionVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderExtensionSuggestion;
import java.util.List;
import java.util.Map;

/**
 * 进阶体检项目建议
 *
 * @author xck
 * @date 2019-05-22 17:42:35
 */
public interface IOrderExtensionSuggestionService extends IService<OrderExtensionSuggestion> {

    /**
    * 多表页面信息查询
    * @param params
    * @return
    */
    PageUtils getDataPage(Map<String, Object> params);

    List<OrderExtensionSuggestionVo> getItems(Map<String,Object> params);

    /**
     *  添加建议进阶项目
     * @param reportNo
     * @param masterIds
     * @param itemNames
     * @param sysIds
     * @param doctorNo
     * @return
     */
    boolean savaOE(String reportNo,String[] masterIds,String[] itemNames,String[] sysIds,String doctorNo, String[] suggestTimes, int dayNumbers, String ReportNo);

    public OrderExtensionSuggestion isExists (String orderNo);

}

