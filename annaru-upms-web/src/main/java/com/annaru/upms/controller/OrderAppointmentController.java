package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.UUIDGenerator;
import com.annaru.upms.entity.*;
import com.annaru.upms.entity.vo.*;
import com.annaru.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


/**
 * 预约
 *
 * @author xck
 * @date 2019-05-13 00:50:41
 */
@Api(tags = {"预约管理"}, description = "预约管理")
@RestController
@RequestMapping("upms/orderAppointment")
public class OrderAppointmentController extends BaseController {

    @Reference
    private IOrderAppointmentService orderAppointmentService;
    @Reference
    private IOrderExtensionExamService orderExtensionExamService;
    @Reference
    private IOrderDetailService orderDetailService;
    @Reference
    private IOrderAdditionalInfoService orderAdditionalInfoService;
    @Reference
    private ISysConfigService sysConfigService;
    @Reference
    private IOrderMainService orderMainService;
    @Reference
    private ISysDoctorOppointmentService sysDoctorOppointmentService;
    @Reference
    private IExamPackageDetailService examPackageDetailService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderAppointment/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderAppointmentService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }

    @ApiOperation(value = "toB基础预约信息")
    @GetMapping("/toBInfo")
    @RequiresPermissions("upms/orderAppointment/toBInfo")
    public ResultMap toCInfo(@ApiParam(value = "用户ID")@RequestParam String userId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId",userId);
        List<OrderInfoVo> orderInfoVo = orderMainService.getToB(params);
        params.clear();
        for(int i = 0;i<orderInfoVo.size();i++){
            params.put("examId",Integer.valueOf(orderInfoVo.get(i).getReferenceNo()));
            List<ExamChooseVo> examChooseVo = examPackageDetailService.getChoosen(params);
            orderInfoVo.get(i).setExamChooseList(examChooseVo);
            params.clear();
        }
        params.put("orderInfoVo",orderInfoVo);
        return ResultMap.ok().put("data",params);
    }


    @ApiOperation(value = "进阶体检预约信息")
    @GetMapping("/extensionInfo")
    @RequiresPermissions("upms/orderAppointment/extensionInfo")
    public ResultMap extensionInfo(@ApiParam(value = "用户ID")@RequestParam String userId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId",userId);
        List<OrderExtensionInfoVo> orderInfoVo = orderMainService.getExtensionInfo(params);
        params.clear();
        for(int i = 0;i<orderInfoVo.size();i++){
            params.put("parentNo",orderInfoVo.get(i).getParentNo());
            OrderInfoVo infoVo = orderMainService.getBase(params);
            params.clear();
            params.put("examId",Integer.valueOf(infoVo.getReferenceNo()));
            List<ExamChooseVo> examChooseVo = examPackageDetailService.getChoosen(params);
            infoVo.setExamChooseList(examChooseVo);
            params.clear();
            orderInfoVo.get(i).setOrderInfoVo(infoVo);
        }
        return ResultMap.ok().put("data",orderInfoVo);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看lcd详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/orderAppointment/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderAppointment orderAppointment = orderAppointmentService.getById(sysId);
        return ResultMap.ok().put("data",orderAppointment);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/orderAppointment/save")
    public ResultMap save(@Valid @RequestBody OrderAppointmentVo orderAppointment) {
        OrderAppointment appointment  = new OrderAppointment();
        OrderExtensionExam orderExtensionExam = new OrderExtensionExam();
        OrderMain orderMain = new OrderMain();
        OrderDetail orderDetail = new OrderDetail();
        OrderAdditionalInfo orderAdditionalInfo = new OrderAdditionalInfo();
        SysDoctorOppointment sysDoctorOppointment = new SysDoctorOppointment();
        try {
            if(orderAppointment.getAppointmentCates()==1
                    &&orderAppointment.getAppointDate()!=null
            &&orderAppointment.getOrderNo()!=null&&orderAppointment.getOption1()!=null
            &&orderAppointment.getTimeFrom()!=null){
                appointment.setAppointmentCates(1);
                appointment.setAppointDate(orderAppointment.getAppointDate());
                appointment.setTimeFrom(orderAppointment.getTimeFrom());
                //appointment.setTimeTo(orderAppointment.getTimeTo());
                appointment.setUserId(orderAppointment.getUserId());
                appointment.setCreateBy(orderAppointment.getUserId());
                appointment.setCreationTime(new Date());
               // Map<String,Object> params = new HashMap<>();
               // params.put("referenceNo",orderAppointment.getReferenceNo());
               // String orderNo = orderMainService.getOrderNo(params).getOrderNo();
                String orderNo = orderAppointment.getOrderNo();
                appointment.setOrderNo(orderNo);
                //appointment.setRelatedNo(orderAppointment.getReferenceNo());
                orderAdditionalInfo.setAppointmentCates(1);
                orderAdditionalInfo.setCreateBy(orderAppointment.getUserId());
                orderAdditionalInfo.setOption1(orderAppointment.getOption1());
                orderAdditionalInfo.setOrderNo(orderNo);
                orderAdditionalInfoService.save(orderAdditionalInfo);
                    if (orderAppointment.getOption1()==1){
                        if (orderAppointment.getAddress()!=null){
                            appointment.setAddress(orderAppointment.getAddress());
                            orderAppointmentService.save(appointment);
                        }
                }else if (orderAppointment.getOption1()==2){
                        if (orderAppointment.getInstitutionId()!=null){
                            appointment.setInstitutionId(orderAppointment.getInstitutionId());
                            orderAppointmentService.save(appointment);
                        }
                    }
            }else if (orderAppointment.getAppointmentCates()==2||orderAppointment.getAppointmentCates()==4
                    &&orderAppointment.getInstitutionId()!=null
                    &&orderAppointment.getParentNo()!=null){
                String orderNo = createOrderNo();
                Integer orderCates = orderAppointment.getAppointmentCates();
                String userId = orderAppointment.getUserId();
                String parentNo = orderAppointment.getParentNo();
                appointment.setRelatedNo(parentNo);
                appointment.setInstitutionId(orderAppointment.getInstitutionId());
                appointment.setUserId(userId);
                appointment.setAppointmentCates(orderCates);
                appointment.setCreateBy(userId);
                appointment.setOrderNo(orderNo);
                orderAppointmentService.save(appointment);
                orderExtensionExam.setCreateBy(userId);
                orderExtensionExam.setExamDetailId(orderAppointment.getExamDetailId());
                orderExtensionExam.setExamMasterId(orderAppointment.getExamMasterId());
                orderExtensionExam.setOrderNo(orderNo);
                orderExtensionExamService.save(orderExtensionExam);
                orderMain.setUserId(userId);
                orderMain.setParentNo(parentNo);
                orderMain.setOrderNo(orderNo);
                orderMain.setStatus(0);
                orderMain.setOrderCates(orderCates);
                orderMainService.save(orderMain);
            }else if (orderAppointment.getAppointmentCates()==5
                    &&orderAppointment.getRelatedNo()!=null
                    &&orderAppointment.getAppointDate()!=null
                    &&orderAppointment.getTimeFrom()!=null
                    &&orderAppointment.getTimeTo()!=null){
                sysDoctorOppointment.setAppointmentCates(5);
                sysDoctorOppointment.setUserId(orderAppointment.getUserId());
                sysDoctorOppointment.setDoctorNurseNo(orderAppointment.getRelatedNo());
                sysDoctorOppointment.setAppointDate(orderAppointment.getAppointDate());
                sysDoctorOppointment.setTimeFrom(orderAppointment.getTimeFrom());
                sysDoctorOppointment.setTimeTo(orderAppointment.getTimeTo());
                sysDoctorOppointmentService.save(sysDoctorOppointment);
            }else if (orderAppointment.getAppointmentCates()==6
                    &&orderAppointment.getInstitutionId()!=null
            &&orderAppointment.getDepartmentId()!=null
            &&orderAppointment.getOption1()!=null
            &&orderAppointment.getOption2()!=null
            &&orderAppointment.getTimes()!=null){
                String userId = orderAppointment.getUserId();
                if (orderAppointment.getTimes()!=0){
                    Map<String,Object> params = new HashMap<>();
                    params.put("userId",userId);
                    orderDetail = orderDetailService.hasRestTimes(params);
                    String orderNo = orderDetail.getOrderNo();
                    Integer restTime = orderDetail.getRestCount();
                    orderDetail.setRestCount(restTime-1);
                    orderDetailService.updateById(orderDetail);
                    appointment.setDepartmentId(orderAppointment.getDepartmentId());
                    appointment.setInstitutionId(orderAppointment.getInstitutionId());
                    appointment.setOrderNo(orderNo);
                    appointment.setUserId(userId);
                    appointment.setAppointmentCates(6);
                    appointment.setCreateBy(userId);
                    orderAppointmentService.save(appointment);
                    orderAdditionalInfo.setOrderNo(orderNo);
                    orderAdditionalInfo.setOption1(orderAppointment.getOption1());
                    orderAdditionalInfo.setOption2(orderAppointment.getOption2());
                    orderAdditionalInfo.setAppointmentCates(6);
                    if (orderAppointment.getSituations()!=null){
                        orderAdditionalInfo.setSituations(orderAppointment.getSituations());
                    }
                    orderAdditionalInfo.setAmount(orderAppointment.getAmount());
                    orderAdditionalInfoService.save(orderAdditionalInfo);
                }else {
                    //如果没有免费次数了，或需要陪诊 要往order_main里插入一条记录
                    String orderNo = createOrderNo();
                    appointment.setDepartmentId(orderAppointment.getDepartmentId());
                    appointment.setInstitutionId(orderAppointment.getInstitutionId());
                    appointment.setOrderNo(orderNo);
                    appointment.setUserId(userId);
                    appointment.setAppointmentCates(6);
                    appointment.setCreateBy(userId);
                    orderAppointmentService.save(appointment);
                    orderAdditionalInfo.setOrderNo(orderNo);
                    orderAdditionalInfo.setOption1(orderAppointment.getOption1());
                    orderAdditionalInfo.setOption2(orderAppointment.getOption2());
                    orderAdditionalInfo.setAppointmentCates(6);
                    if (orderAppointment.getSituations()!=null){
                        orderAdditionalInfo.setSituations(orderAppointment.getSituations());
                    }
                    orderAdditionalInfo.setAmount(orderAppointment.getAmount());
                    orderAdditionalInfoService.save(orderAdditionalInfo);
                    if (orderAppointment.getAmount()!=null&&orderAppointment.getAmount()!=0){
                        orderMain.setOrderCates(6);
                        orderMain.setOrderNo(orderNo);
                        orderMain.setStatus(0);
                        orderMain.setUserId(userId);
                        orderMain.setAmount(orderAppointment.getAmount());
                        orderMainService.save(orderMain);
                    }
                }
            }else {
                return ResultMap.error("运行异常，请联系管理员");
            }
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    public String createOrderNo(){
        SysConfig sysConfig  = sysConfigService.getODR();
        String orderNo = sysConfig.getCodeValue()+sysConfig.getAppendCode()
                + UUIDGenerator.autoGenericCode(sysConfig.getRefNo(),sysConfig.getLength());
        sysConfig.setRefNo(String.valueOf(Integer.parseInt(sysConfig.getRefNo())+1));
        sysConfigService.updateById(sysConfig);
        return orderNo;
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("upms/orderAppointment/update")
    public ResultMap update(@Valid @RequestBody OrderAppointment orderAppointment) {
        try {
            orderAppointmentService.updateById(orderAppointment);
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
    @RequiresPermissions("upms/orderAppointment/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderAppointmentService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


    /**
     * 护士订单列表
     * status ; 0 待服务 1 待提交 2 已取消 3 已完成
     *when 0 week 1 month 2 today 不传 所有
     */
    @ApiOperation(value = "护士订单列表")
    @GetMapping("/nurseOrderList")
    @RequiresPermissions("upms/orderAppointment/nurseOrderList")
    public ResultMap nurseOrderList(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                                    @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                                    @ApiParam(value = "护士编号")@RequestParam String nurseNo,
                                    @ApiParam(value = "订单状态")@RequestParam Integer status,
                                    @ApiParam(value = "时间区间")@RequestParam(required = false)Integer when){
        Map<String, Object> params = new HashMap<>();
        params.put("nurseNo",nurseNo);
        params.put("status",status);
        params.put("when",when);
        params.put("page",page);
        params.put("limit", limit);
        PageUtils<Map<String, Object>> nurseOrderLists = orderAppointmentService.getNurseOrderList(params);
        return ResultMap.ok().put("data",nurseOrderLists);
    }

}
