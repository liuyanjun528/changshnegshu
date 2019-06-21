package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.exception.GlobalException;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.im.rong.models.Result;
import com.annaru.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
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
    private IOrderDetailService orderDetailService;//订单详情表

    @Reference
    private IOrderCustomerService orderCustomerService;//订单客户表

    @Reference
    private ISysConfigService iSysConfigService; //系统配置表

    @Reference
    private IExamPackageAppendService examPackageAppendService;

    @Reference
    private IUserFamilyDoctorService userFamilyDoctorService;//家庭医生

    @Reference
    private IUserRelativesService userRelativesService;//亲属表


    /**
     * 保存家庭医生订单
     */

    @ApiOperation(value = "家庭医生下订单")
    @PostMapping("/saveFamilyDoctor")
    @RequiresPermissions("upms/orderMain/saveFamilyDoctor")
    public ResultMap saveFamilyDoctor(@RequestBody OrderMain orderMain) {
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService , SysConfigUtil.ORDERNO);
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
            boolean save = orderMainService.save(orderMain);
            if(save=true){
                orderMain.getUserFamilyDoctor().setOrderNo(SysConfigUtil.getNoBySysConfig());
                userFamilyDoctorService.save(orderMain.getUserFamilyDoctor());
            }
            if(save=true){
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
            }
            return ResultMap.ok("家庭医生订单成功").put("data",orderMain.getOrderNo());
        }catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    /**
     * 保存Toc下订单
     */
    @ApiOperation(value = "Toc套餐下订单")
    @PostMapping("/saveOrderMain")
    @RequiresPermissions("upms/orderMain/saveOrderMain")
    public ResultMap saveOrderMain(@RequestBody OrderMain orderMain) {
        int i=0;
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.ORDERNO);
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
            i = orderMainService.insertOrderMain(orderMain);

            if (i > 0) {
                    SysConfigUtil.saveRefNo(sysConfig.getRefNo());
                }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        if (i>0) {
            return ResultMap.ok("添加成功").put("data", orderMain.getOrderNo());
        } else {
            return ResultMap.error("没有相关亲属，请先添加亲属");
        }
    }


//            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.ORDERNO);
//            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
//            int i = orderMainService.insertOrderMain(orderMain);
//
//            //如果如果i>0 并且 所选套餐编号大于3执行下面的添加方法
//            if (i > 0 && Integer.parseInt(orderMain.getReferenceNo()) > 3) {
//                List<ExamPackageAppend> examPackageAppends = examPackageAppendService.selectExamName(Integer.parseInt(orderMain.getReferenceNo()));
//                OrderDetail detail = new OrderDetail();
//                detail.setRestCount(orderMain.getOrderDetail().getRestCount());
//                detail.setTotalCount(orderMain.getOrderDetail().getTotalCount());
//                detail.setEffectFrom(orderMain.getOrderDetail().getEffectFrom());
//                detail.setEffectTo(orderMain.getOrderDetail().getEffectTo());
//                for (ExamPackageAppend exam : examPackageAppends) {
//                    detail.setAppendId(exam.getAppendId());
//                    //添加订单详情
//                    detail.setOrderNo(SysConfigUtil.getNoBySysConfig());
//                    orderDetailService.insertOrderDetail(detail);
//                }
//            }
//
//            //如果i>0 执行下面的方法
//            if (i > 0) {
//                //如果套餐个数大于1执行下面的添加方法
//                if (orderMain.getTotalQty() > 1) {
//                    // 通过当前userId 添加  如果要往orderCustomer添加亲属ID， 亲属id如果在relavite表已经存在 添加成功 否则不让插入
//                    //判断当前用户Id的 亲属Id 是否存在
//                    List<UserRelatives> list = userRelativesService.selectAll(orderMain.getUserId());
//                    Boolean result=false;
//                    for (UserRelatives relative : list) {
//                        if (relative.getRelativeId().equals(orderMain.getOrderCustomer().getRelativeId())) {
//                            result=true;
//                            break;
//                        }
//                    }
//                    if(result==false){
//                        throw new GlobalException("没有相关亲属");
//                    }
//                    if (result) {
//                        //添加客户表
//                        orderMain.getOrderCustomer().setOrderNo(SysConfigUtil.getNoBySysConfig());
//                        orderCustomerService.insertOrderCustomer(orderMain.getOrderCustomer());
//                    }
//                }
//                if (i > 0) {
//                    SysConfigUtil.saveRefNo(sysConfig.getRefNo());
//                }
//                return ResultMap.ok("添加成功").put("data", orderMain.getOrderNo());
//            }
//            return ResultMap.error("订单主表添加失败");
//
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//
//            return ResultMap.error("运行异常，请联系管理员");
//
//        }
    //}

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
                                     Integer status){
//        OrderMain orderMain = orderMainService.getById();
//        return ResultMap.ok().put("orderMain",orderMain);
        /*
        如果 appointmentCates 等于 1 ，则为套餐订单
        如果 appointmentCates 等于 3 ，并且 option_1 不等于 1 ，则为套餐订单
        如果 appointmentCates 等于 3 ，并且 option_1 等于 1 ，则为护士上门
        如果 appointmentCates 等于 2 或者 等于 4 ，并且 parentNo 不等于空 ，则为进阶体检
        如果 appointmentCates 等于 6 ，则为门诊绿通陪诊服务
        如果 status 等于 0 ，则为未支付 ，
        若status 等于 1 ，并且 opOderNo 不等于空 ，则为已支付
        若status 等于 2 ，并且 opOderNo 不等于空 ，则为完成
        */
        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("status", status);
        PageUtils<Map<String, Object>> pageList = orderMainService.selectOrderPage(params);
        return ResultMap.ok().put("data",pageList);
    }

    /**
     * 查询套餐订单详情
     * @author zk
     * @date 2019-05-16 17:59
     */
    @ApiOperation(value = "查询套餐订单详情", notes = "查询套餐订单详情")
    @GetMapping("/selectPackageOrder/{sysId}")
    @RequiresPermissions("upms/orderMain/selectPackageOrder")
    public ResultMap selectPackageOrder(@PathVariable("sysId") Integer sysId){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        List<OrderMain> orderMainList = orderMainService.selectPackageOrder(params);
        return ResultMap.ok().put("data",orderMainList);
    }

    /**
     * 查询自费(进阶)订单详情
     * @author zk
     * @date 2019-05-16 17:59
     */
    @ApiOperation(value = "查询自费(进阶)订单详情", notes = "查询自费(进阶)订单详情")
    @GetMapping("/selectPackageAdvance/{sysId}")
    @RequiresPermissions("upms/orderMain/selectPackageAdvance")
    public ResultMap selectPackageAdvance(@PathVariable("sysId") Integer sysId){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        List<OrderMain> orderMainList = orderMainService.selectPackageAdvance(params);
        return ResultMap.ok().put("data",orderMainList);
    }

    /**
     * 查询门诊绿通订单详情
     * @author zk
     * @date 2019-05-16 17:59
     */
    @ApiOperation(value = "查询门诊绿通订单详情", notes = "查询门诊绿通订单详情")
    @GetMapping("/selectPackageGreen/{sysId}")
    @RequiresPermissions("upms/orderMain/selectPackageGreen")
    public ResultMap selectPackageGreen(@PathVariable("sysId") Integer sysId){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        List<OrderMain> orderMainList = orderMainService.selectPackageGreen(params);
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
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("upms/orderMain/update")
    public ResultMap update(@Valid @RequestBody OrderMain orderMain) {
        try {
//            orderMain.setUpdateTime(new Date());
            orderMainService.updateById(orderMain);
            return ResultMap.ok("修改成功");
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

}
