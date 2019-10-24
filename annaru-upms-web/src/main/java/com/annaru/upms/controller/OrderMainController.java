package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.Constant;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.entity.vo.*;
import com.annaru.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


/**
 * 定单主表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"定单主表管理"}, description = "定单主表管理")
@RestController
@RequestMapping("upms/orderMain")
public class OrderMainController extends BaseController {
    @Reference
    private IOrderMainService orderMainService;//订单主表
    @Reference
    private ISysConfigService iSysConfigService; //系统配置表
    @Reference
    private ISysMessageService sysMessageService;// 消息表
    @Reference
    private IExamAppendService examAppendService;
    @Reference
    private ISysMessageTemplateService sysMessageTemplateService;
    @Reference
    private IUserBasicService userBasicService;
    @Reference
    private IExamPackageAppendService examPackageAppendService;
    @Reference
    private IOrderDetailService orderDetailService;


    /**
     * 保存Toc下订单
     */
    @ApiOperation(value = "Toc套餐下订单")
    @PostMapping("/saveOrderMain")
    //@RequiresPermissions("upms/orderMain/saveOrderMain")
    public ResultMap saveOrderMain(@RequestBody OrderMain orderMain,String []RelativeId) {
        int i=0;
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.ORDERNO);
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
            orderMain.setCreationtime(new Date());
            orderMain.setUserChannel("长生树APP");
            orderMain.setStatus(Constant.PaymentState.UNPAID.getValue());
            i = orderMainService.insertOrderMain(orderMain,RelativeId);


            if(i > 0){
                //查询套餐下的赠送服务
                List<ExamAppend> examAppends = examAppendService.selectServiceByMainId(orderMain.getReferenceNo());
                //查询用户名
//                UserBasic userBasic = userBasicService.selectByUid(orderMain.getUserId());
//                String fullName = userBasic.getFullName();
                //查询套餐模板
                SysMessageTemplate sysMessageTemplate = sysMessageTemplateService.selectMessageTemplate(1);

                //套餐购买成功往消息表添加一条数据
                SysMessage sm=new SysMessage();
                sm.setOrderNo(orderMain.getOrderNo());// 订单号
                sm.setMsgCate(1);//1:系统消息
                sm.setBusinessCate(1);//1:购买套餐
                sm.setUserId(orderMain.getUserId());//用户
                sm.setCreationTime(new Date());

                StringBuffer s=new StringBuffer();
                for(ExamAppend exam:examAppends){
                    String serviceName = exam.getServiceName();
                    if(null==serviceName){
                        s.append("null");
                    }else{
                        s.append(serviceName+",");
                    }
                }
                String contentTemplate = sysMessageTemplate.getContentTemplate();
                String message1 = contentTemplate.replace("[pakg_name]", examAppends.get(0).getPackageName());//替换过的消息
                String message2 = message1.replace("[append_service]", s.toString().substring(0,s.length()-1));//替换过的消息
                String message3 = message2.replace("[order_no]", orderMain.getOrderNo());//替换过的消息
                if(StringUtils.equals(s.toString(), "null")){//如果赠送服务为null ,不显示赠送服务包含项
                    String message4 = message3.replace("包含服务：[append_service]，", " ");//替换过的消息
                    sm.setContent(message4);
                    sysMessageService.save(sm);
                }else{
                    sm.setContent(message3);
                    sysMessageService.save(sm);
                }
            }
            if (i > 0) {
                    SysConfigUtil.saveRefNo(sysConfig.getRefNo());
                }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        if (i>0) {
            return ResultMap.ok("添加成功").put("data", orderMain.getOrderNo());
        } else {
            return ResultMap.error("添加失败");
        }
    }

    /**
     * 未开票订单列表
     * @author zk
     * @date 2019/10/11
     */
    @ApiOperation(value = "未开票订单列表")
    @GetMapping("/notReceiptList")
    @RequiresPermissions("upms/orderMain/notReceiptList")
    public ResultMap linotReceiptListst(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                                        @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                                        @ApiParam(value = "用户编号")@RequestParam String userId){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("userId", userId);
        PageUtils<Map<String, Object>> pageList = orderMainService.notReceiptList(params);
        return ResultMap.ok().put("data",pageList);
    }

    /**
     * 开票订单查询（列表）
     * @author zk
     * @date 2019/10/12
     */
    @ApiOperation(value = "开票订单查询（列表）")
    @GetMapping("/receiptOrderSelectList")
    @RequiresPermissions("upms/orderMain/receiptOrderSelectList")
    public ResultMap receiptOrderSelectList(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                                            @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                                            @ApiParam(value = "发票编号")@RequestParam String receiptNo){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("receiptNo", receiptNo);
        PageUtils<Map<String, Object>> pageList = orderMainService.receiptOrderSelectList(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderMain/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderMainService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/orderMain/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderMain orderMain = orderMainService.getById(sysId);
        return ResultMap.ok().put("data",orderMain);
    }


    /**
     * 查询我的的名单里面的订单
     * @author zk
     * @date 2019-05-16 10:58
     */
    @ApiOperation(value = "查询我的订单列表", notes = "查询我的订单列表")
    @GetMapping("/selectOrderPage")
    @RequiresPermissions("upms/orderMain/selectOrderPage")
    public ResultMap selectOrderPage(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                                     @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                                     Integer status, String userId){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("status", status);
        params.put("userId", userId);
        PageUtils<Map<String, Object>> pageList = orderMainService.selectOrderPage(params);
        return ResultMap.ok().put("data",pageList);
    }

    /**
     * 订单各状态的总数
     * @author zk
     * @date 2019-07-01
     */
    @ApiOperation(value = "订单各状态的总数", notes = "订单各状态的总数")
    @GetMapping("/selectSumByStatus")
    @RequiresPermissions("upms/orderMain/selectSumByStatus")
    public ResultMap selectSumByStatus(String userId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        OrderMainVoSumByStatusZ orderMainVoSumByStatusZ = orderMainService.selectSumByStatus(params);
        return ResultMap.ok().put("data",orderMainVoSumByStatusZ);
    }

    /**
     * 查询套餐订单详情
     * @author zk
     * @date 2019-05-16 17:59
     */
    @ApiOperation(value = "查询套餐订单详情", notes = "查询套餐订单详情")
    @GetMapping("/selectPackageOrder")
    @RequiresPermissions("upms/orderMain/selectPackageOrder")
    public ResultMap selectPackageOrder(Integer sysId, String orderNo){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        params.put("orderNo", orderNo);
        OrderMainVoZTC orderMainList = orderMainService.selectPackageOrder(params);
        return ResultMap.ok().put("data",orderMainList);
    }

    /**
     * 查询自费(进阶)订单详情
     * @author zk
     * @date 2019-05-16 17:59
     */
    @ApiOperation(value = "查询自费(进阶)订单详情", notes = "查询自费(进阶)订单详情")
    @GetMapping("/selectPackageAdvance")
    @RequiresPermissions("upms/orderMain/selectPackageAdvance")
    public ResultMap selectPackageAdvance(Integer sysId, String orderNo){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        params.put("orderNo", orderNo);
        OrderMainVoZZF orderMainList = orderMainService.selectPackageAdvance(params);
        return ResultMap.ok().put("data",orderMainList);
    }

    /**
     * 查询门诊绿通订单详情
     * @author zk
     * @date 2019-05-16 17:59
     */
    @ApiOperation(value = "查询门诊绿通订单详情", notes = "查询门诊绿通订单详情")
    @GetMapping("/selectPackageGreen")
    @RequiresPermissions("upms/orderMain/selectPackageGreen")
    public ResultMap selectPackageGreen(Integer sysId, String orderNo){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        params.put("orderNo", orderNo);
        OrderMainVoZMzlt orderMainList = orderMainService.selectPackageGreen(params);
        return ResultMap.ok().put("data",orderMainList);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/orderMain/save")
    public ResultMap save(@Valid @RequestBody OrderMain orderMain) {
        try {
            orderMainService.save(orderMain);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 删除定单
     */
    @ApiOperation(value = "删除定单")
    @PostMapping("/delteOrderMain")
    @RequiresPermissions("upms/orderMain/delteOrderMain")
    public ResultMap delteOrderMain(@RequestParam Integer sysId) {
        try {
            OrderMain orderMain = orderMainService.getById(sysId);
            if (orderMain == null){
                return ResultMap.error("该订单不存在！");
            }
            if (orderMain.getIsDeleted() == 1){
                return ResultMap.error("该订单不存在！");
            }
            orderMain.setIsDeleted(1);
            if (orderMainService.updateById(orderMain)){
                return ResultMap.ok("删除定单成功！");
            }
            return ResultMap.error("运行异常，请联系管理员");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    @RequiresPermissions("upms/orderMain/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderMainService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


    /**
      * @Description:未支付订单 30分钟进行取消
      * @Author: wh
      * @Date: 2019/9/17 16:53
      */
    @ApiOperation(value = "未支付订单进行取消")
    @PostMapping("/updateIsDelate")
    public ResultMap updateIsDelate(String orderNo) {
        try {
            Boolean aBoolean = orderMainService.updateCloseOrder(orderNo);
            if(aBoolean){
                return ResultMap.ok("取消成功！");
            }
            return ResultMap.ok("取消失败！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 查询超过30分钟的未支付订单 wh
     */
    @ApiOperation(value = "查询超过30分钟的未支付订单", notes = "查询超过30分钟的未支付订单")
    @GetMapping("/orderNonPay")
    public ResultMap orderNonPay(){
        List<OrderMain> orderMains = orderMainService.selectOrderNonPayment();
        return ResultMap.ok().put("data",orderMains);
    }

    /**
      * @Description:Hpv下单
      * @Author: wh
      * @Date: 2019/10/10 15:52
      */
    @ApiOperation(value = "Hpv下单")
    @PostMapping("/saveHpvOrder")
    @RequiresPermissions("upms/orderMain/saveHpvOrder")
    public ResultMap saveHpvOrder(@Valid @RequestBody OrderMain orderMain) {
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.ORDERNO);
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
            orderMain.setOrderCates(7);
            orderMain.setUserChannel("长生树APP");
            orderMain.setOrderTime(new Date());
            orderMain.setCreationtime(orderMain.getOrderTime());
            boolean save = orderMainService.save(orderMain);

            //根据套餐编号查询 如果有赠送服务
            List<AppendOrderMain> appendOrderMains = orderMainService.selectAppendByOrderNo(orderMain.getOrderNo());
            if (save && null!=appendOrderMains ) {
                List<ExamPackageAppend> examPackageAppends = examPackageAppendService.selectExamName(Integer.parseInt(orderMain.getReferenceNo()));
                OrderDetail detail = new OrderDetail();
                detail.setCreationtime(orderMain.getCreationtime());
                for (ExamPackageAppend exam : examPackageAppends) {
                    detail.setAppendId(exam.getAppendId());
                    detail.setTotalCount(exam.getPeriods());
                    detail.setRestCount(exam.getPeriods());
                    detail.setCreationtime(orderMain.getOrderTime());
                    detail.setOrderNo(orderMain.getOrderNo());
                    orderDetailService.insertOrderDetail(detail);//添订单详情表
                }
            }

            if (save) {
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
            }
            return ResultMap.ok("Hpv下单成功").put("data", orderMain.getOrderNo());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
      * @Description:Hpv疫苗预约
      * @Author: wh
      * @Date: 2019/10/11 11:39
      */
    @ApiOperation(value = "Hpv疫苗预约")
    @PostMapping("/saveHpvAppointMent")
    @RequiresPermissions("upms/orderMain/saveHpvAppointMent")
    public ResultMap saveHpvAppointMent(@Valid @RequestBody OrderMain orderMain) {
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.ORDERNO);
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
            int i = orderMainService.insertHpvAppointment(orderMain);
            if (i>0) {
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
                return ResultMap.ok("Hpv疫苗预约成功").put("data", orderMain.getOrderNo());
            }
            return ResultMap.error("运行异常，请联系管理员");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


}
