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
import jodd.util.ObjectUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Reference
    private IOrderExtensionSuggestionService orderExtensionSuggestionService;
    @Reference
    private ISysDoctorScheduleService sysDoctorScheduleService;

    /**
     * 门诊预约确认
     */
    @ApiOperation(value = "门诊预约确认操作", notes = "门诊预约确认操作")
    @GetMapping("/updateStatus")
    @RequiresPermissions("upms/orderAppointment/updateStatus")
    public ResultMap updateStatus(@RequestParam String userId,
                                  @RequestParam String doctorNo,
                                  @RequestParam Date appointDate,
                                  @RequestParam String timeFrom,
                                  @RequestParam String timeTo) {
        Map<String, Object> params = new HashMap<>();
        params.put("doctorNo",doctorNo);
        params.put("userId",userId);
        params.put("appointDate",appointDate);
        params.put("timeFrom",timeFrom);
        params.put("timeTo",timeTo);
        OrderAppointment appointment = new OrderAppointment();
        appointment.setUserId(userId);
        appointment.setRelatedNo(doctorNo);
        appointment.setTimeFrom(timeFrom);
        appointment.setAppointDate(appointDate);
        appointment.setAppointmentCates(5);
        try {
            sysDoctorScheduleService.updateSceduleStatus(params);
            sysDoctorOppointmentService.updateSceduleStatus(params);
            orderAppointmentService.save(appointment);
            return ResultMap.ok("修改成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }




    /**
     * 待确认预约列表
     */
    @ApiOperation(value = "待确认预约列表", notes = "待确认预约列表")
    @GetMapping("/selectOutpatientAppointment")
    @RequiresPermissions("upms/orderAppointment/selectOutpatientAppointment")
    public ResultMap selectOutpatientAppointment(
            @ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
            @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
            @ApiParam(value = "医生编号")@RequestParam(required = false)String doctorNo,
            @ApiParam(value = "状态")@RequestParam(required = false) int status
            ){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("doctorNo", doctorNo);
        params.put("status",status);
        PageUtils<Map<String, Object>> pageList = sysDoctorOppointmentService.getAppointmentList(params);
        return ResultMap.ok().put("data",pageList);
    }






    /**
     * 个人用户患者信息分页查询
     */
    @ApiOperation(value = "个人用户患者信息分页查询")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderAppointment/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "医生编号")@RequestParam(required = false)String relatedNo){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("relatedNo", relatedNo);
        PageUtils<Map<String, Object>> pageList = orderAppointmentService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }

    @ApiOperation(value = "用户套餐对应预约信息")
    @GetMapping("/toBPackages")
    @RequiresPermissions("upms/orderAppointment/toBPackages")
    public ResultMap toBPackages(@ApiParam(value = "用户ID")@RequestParam String userId,
    @ApiParam(value = "订单编号")@RequestParam(required = false) String orderNo){
        Map<String, Object> params = new HashMap<>();
        params.put("userId",userId);
        params.put("orderNo",orderNo);
        //套餐信息 订单号
        UserPackagesVo userPackage = orderMainService.getToBPackages(params);
        params.put("examId",userPackage.getReferenceNo());
        if (orderNo==null){
            params.put("orderNo",userPackage.getOrderNo());
        }
        //建议检查项
        List<OrderExtensionSuggestion> orderExtensionSuggestion = orderExtensionSuggestionService.getItems(params);
        //套餐项
        List<ExamChooseVo> examChooseVo = examPackageDetailService.getChoosen(params);
        List<OrderAppointment> orderAppointments = orderAppointmentService.getAppointInfoByOrderNo(params);
        if (orderAppointments.size()==0){
            params.clear();
            params.put("examList",examChooseVo);
            params.put("packageName",userPackage.getPackageName());
            params.put("appointed",0);
            return ResultMap.ok().put("data",params);
        }

        List<OrderExtensionInfoVo> orderInfoVo = orderMainService.getExtensionInfo(params);

        params.clear();
        params.put("appointed",1);
        if (null==orderExtensionSuggestion||orderExtensionSuggestion.size()==0){
            params.put("extensionSuggestion","");
        }else {
            params.put("extensionSuggestion",orderExtensionSuggestion);
        }
        if (orderInfoVo==null){
            params.put("extensioncheck","");
        }else {
            params.put("extensioncheck",orderInfoVo);
        }
        params.put("packageName",userPackage.getPackageName());
        params.put("examList",examChooseVo);
        params.put("commoncheck",orderAppointments.get(0));
        return ResultMap.ok().put("data",params);
    }

    @ApiOperation(value = "用户套餐订单列表")
    @GetMapping("/packages")
    @RequiresPermissions("upms/orderAppointment/packages")
    public ResultMap packages(@ApiParam(value = "用户ID")@RequestParam String userId){
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);
        List<UserPackagesVo> userPackagesVos = orderMainService.getPackages(params);
        return ResultMap.ok().put("data",userPackagesVos);
    }

    @ApiOperation(value = "用户预约信息")
    @GetMapping("/toBInfo")
    @RequiresPermissions("upms/orderAppointment/toBInfo")
    public ResultMap toCInfo(@ApiParam(value = "用户ID")@RequestParam String orderNo){
        Map<String, Object> params = new HashMap<>();
        params.put("orderNo",orderNo);
        OrderInfoVo orderInfoVo = orderMainService.getToB(params);
        params.put("examId",Integer.valueOf(orderInfoVo.getReferenceNo()));
        List<ExamChooseVo> examChooseVo = examPackageDetailService.getChoosen(params);
        orderInfoVo.setExamChooseList(examChooseVo);
        params.clear();
        params.put("orderInfoVo",orderInfoVo);
        return ResultMap.ok().put("data",params);
    }

    /**
     * 待确认患者列表
     */
    @ApiOperation(value = "待确认患者列表", notes = "待确认患者列表")
    @GetMapping("/selectListInfo")
    @RequiresPermissions("upms/orderAppointment/selectListInfo")
    public ResultMap selectListInfo(
            @ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
            @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
            @ApiParam(value = "医生编号")@RequestParam(required = false)String relatedNo,
            @ApiParam(value = "状态")@RequestParam(required = false) int status){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("relatedNo", relatedNo);
        params.put("status",status);
        PageUtils<Map<String, Object>> pageList = orderAppointmentService.selectList(params);
        return ResultMap.ok().put("data",pageList);
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
                appointment.setUserId(orderAppointment.getUserId());
                appointment.setCreateBy(orderAppointment.getUserId());
                appointment.setCreationTime(new Date());
                String orderNo = orderAppointment.getOrderNo();
                appointment.setOrderNo(orderNo);
                appointment.setServiceOption(orderAppointment.getOption1());
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
            }else if (orderAppointment.getAppointmentCates()==2
                    &&orderAppointment.getInstitutionId()!=null
                    &&orderAppointment.getParentNo()!=null
                    &&orderAppointment.getExtensionItems()!=null){
                String orderNo = createOrderNo();
                Integer orderCates = orderAppointment.getAppointmentCates();
                String userId = orderAppointment.getUserId();
                String parentNo = orderAppointment.getParentNo();
                for(int i = 0;i<orderAppointment.getExtensionItems().size();i++){
                    orderExtensionExam.setCreateBy(userId);
                    orderExtensionExam.setExamDetailId(orderAppointment.getExtensionItems().get(i).getExamDetailId());
                    orderExtensionExam.setExamMasterId(orderAppointment.getExtensionItems().get(i).getExamMasterId());
                    orderExtensionExam.setOrderNo(orderNo);
                   // orderExtensionExamService.save(orderExtensionExam);
                    int sysId = orderExtensionExamService.saveOne(orderExtensionExam);
                    appointment.setExtensionItemId(sysId);
                    appointment.setParentNo(parentNo);
                    appointment.setInstitutionId(orderAppointment.getInstitutionId());
                    appointment.setUserId(userId);
                    appointment.setAppointmentCates(orderCates);
                    appointment.setCreateBy(userId);
                    appointment.setOrderNo(orderNo);
                    orderAppointmentService.save(appointment);
                }
                orderMain.setUserId(userId);
                orderMain.setParentNo(parentNo);
                orderMain.setOrderNo(orderNo);
                orderMain.setStatus(0);
                orderMain.setOrderCates(orderCates);
                orderMainService.save(orderMain);
            }else if (orderAppointment.getAppointmentCates()==4
                    &&orderAppointment.getInstitutionId()!=null
                    &&orderAppointment.getParentNo()!=null
                    &&orderAppointment.getExtensionItems()!=null
            &&orderAppointment.getHrOppointmentId()!=null) {
                String orderNo = createOrderNo();
                Integer orderCates = orderAppointment.getAppointmentCates();
                String userId = orderAppointment.getUserId();
                String parentNo = orderAppointment.getParentNo();
                for(int i = 0;i<orderAppointment.getExtensionItems().size();i++){
                    orderExtensionExam.setCreateBy(userId);
                    orderExtensionExam.setExamDetailId(orderAppointment.getExtensionItems().get(i).getExamDetailId());
                    orderExtensionExam.setExamMasterId(orderAppointment.getExtensionItems().get(i).getExamMasterId());
                    orderExtensionExam.setOrderNo(orderNo);
                    int sysId = orderExtensionExamService.saveOne(orderExtensionExam);
                    appointment.setExtensionItemId(sysId);
                    appointment.setParentNo(parentNo);
                    appointment.setInstitutionId(orderAppointment.getInstitutionId());
                    appointment.setUserId(userId);
                    appointment.setAppointmentCates(orderCates);
                    appointment.setCreateBy(userId);
                    appointment.setOrderNo(orderNo);
                    orderAppointmentService.save(appointment);
                }
                orderMain.setUserId(userId);
                orderMain.setParentNo(parentNo);
                orderMain.setHrOppointmentId(orderAppointment.getHrOppointmentId());
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
//                Map<String, Object> params = new HashMap<>();
//                params.put("appointDate",orderAppointment.getAppointDate());
//                params.put("timeFrom",orderAppointment.getTimeFrom());
//                params.put("timeTo",orderAppointment.getTimeTo());
//                sysDoctorScheduleService.updateActive(params);
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
                    if (orderAppointment.getAmount()!=null&&orderAppointment.getAmount()!=0){
                        orderMain.setOrderCates(6);
                        orderMain.setOrderNo(orderNo);
                        orderMain.setStatus(0);
                        orderMain.setUserId(userId);
                        orderMain.setAmount(orderAppointment.getAmount());
                        orderMainService.save(orderMain);
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
     * @Description toB分布式体检预约取消
     * @Author zk
     * @Date 2019/6/20
     */
    @ApiOperation(value = "toB分布式体检预约取消")
    @PostMapping("/updateCancelledByOrderNo")
    @RequiresPermissions("upms/orderAppointment/updateCancelledByOrderNo")
    public ResultMap updateCancelledByOrderNo(@RequestParam("orderNo") String orderNo) {
        try {
            OrderAppointment orderAppointment = new OrderAppointment();
            orderAppointment.setOrderNo(orderNo);
            orderAppointment.setAppointmentCates(3);
            OrderAppointment orderAppointment1 = orderAppointmentService.getOrderAppointment(orderAppointment);
            if (orderAppointment1 == null){
                return ResultMap.error("该toB分布式体检预约不存在！");
            }
            if (orderAppointment1.getIsCancelled() == 1){
                return ResultMap.ok("取消预约成功！");
            }
            if (orderAppointmentService.updateIsCancelled(1, orderNo)){
                return ResultMap.ok("取消预约成功！");
            }
            return ResultMap.error("运行异常，请联系管理员！");
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
