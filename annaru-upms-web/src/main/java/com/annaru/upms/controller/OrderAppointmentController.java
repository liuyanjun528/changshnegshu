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
    @Reference
    private ISysMessageService sysMessageService;
    @Reference
    private ISysInstitutionService sysInstitutionService;
    @Reference
    private IExamMasterService examMasterService;
    @Reference
    private IExamDetailService examDetailService;
    @Reference
    private ISysAppraisalService sysAppraisalService;
    @Reference
    private ISysGlobalSettingService sysGlobalSettingService;
    @Reference
    private IUserFamilyDoctorService userFamilyDoctorService;

    /**
     * 门诊预约确认
     */
    @ApiOperation(value = "门诊预约确认操作", notes = "门诊预约确认操作")
    @GetMapping("/updateStatus")
    //@RequiresPermissions("upms/orderAppointment/updateStatus")
    public ResultMap updateStatus(@RequestParam Integer sysId) {
        Map<String, Object> params = new HashMap<>();
        SysDoctorOppointment sysDoctorOppointment = sysDoctorOppointmentService.getById(sysId);
        params.put("orderNo",sysDoctorOppointment.getOrderNo());
        UserFamilyDoctor userFamilyDoctor = userFamilyDoctorService.getFamilyDoctor(params);
        userFamilyDoctor.setRestCount(userFamilyDoctor.getRestCount()-1);
        sysDoctorOppointment.setIsConfirmed(1);
        String userId = sysDoctorOppointment.getUserId();
        String doctorNo = sysDoctorOppointment.getDoctorNurseNo();
        String timeFrom = sysDoctorOppointment.getTimeFrom();
        String timeTo = sysDoctorOppointment.getTimeTo();
        Date appointDate = sysDoctorOppointment.getAppointDate();
        params.put("doctorNo",doctorNo);
        params.put("userId",userId);
        params.put("appointDate",appointDate);
        params.put("timeFrom",timeFrom);
        params.put("timeTo",timeTo);
        SysDoctorSchedule schedule = sysDoctorScheduleService.getCount(params);
        if (schedule.getCount()==0){
            return ResultMap.error("预约人次已满");
        }
        int count = schedule.getCount()-1;
        schedule.setState(1);
        if (count==0){
            schedule.setIsActive(1);
        }
        schedule.setCount(count);
        OrderAppointment appointment = new OrderAppointment();
        appointment.setOrderNo(sysDoctorOppointment.getOrderNo());
        appointment.setUserId(userId);
        appointment.setRelatedNo(doctorNo);
        appointment.setTimeFrom(timeFrom);
        appointment.setTimeTo(timeTo);
        appointment.setAppointDate(appointDate);
        appointment.setAppointmentCates(5);
        try {
            userFamilyDoctorService.updateById(userFamilyDoctor);
            sysDoctorScheduleService.updateById(schedule);
            sysDoctorOppointmentService.updateById(sysDoctorOppointment);
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
    //@RequiresPermissions("upms/orderAppointment/selectOutpatientAppointment")
    public ResultMap selectOutpatientAppointment(
            @ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
            @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
            @ApiParam(value = "医生编号")@RequestParam String doctorNo,
            @ApiParam(value = "状态")@RequestParam Integer status
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
    //@RequiresPermissions("upms/orderAppointment/list")
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
        if (userPackage==null){
            return ResultMap.ok().put("data",userPackage);
        }
        params.put("examId",userPackage.getReferenceNo());
        if (orderNo==null){
            params.put("orderNo",userPackage.getOrderNo());
        }
        //建议检查项
        List<OrderExtensionSuggestionVo> orderExtensionSuggestion = orderExtensionSuggestionService.getItems(params);
        //套餐项
        List<ExamChooseVo> examChooseVo = examPackageDetailService.getChoosen(params);
        List<ExamExtensionVo> extensionVos = examPackageDetailService.getEEChoosen(params);
        List<OrderAppointmentBase> orderAppointments = orderAppointmentService.getAppointInfoByOrderNo(params);
        if (orderAppointments.size()==0){
            params.clear();
            params.put("examList",examChooseVo);
            params.put("examExtensionList",extensionVos);
            params.put("userPackage",userPackage);
            params.put("appointed",0);
            return ResultMap.ok().put("data",params);
        }

        if(orderAppointments.get(0).getServiceOption()==1){
            OrderMain orderMain = orderMainService.getInfo(params);
            orderAppointments.get(0).setOrderNo(orderMain.getOrderNo());
            orderAppointments.get(0).setAmount(orderMain.getAmount());
            orderAppointments.get(0).setPayStatus(orderMain.getStatus());
        }

        List<OrderExtensionInfoVo> orderInfoVo = orderMainService.getExtensionInfo(params);

        SysAppraisal sysAppraisal = sysAppraisalService.getAppraised(params);
        params.clear();
        if (sysAppraisal==null){
            params.put("appraised",0);
        }else {
            params.put("appraised",1);
        }
        params.put("appointed",1);
        params.put("extensionSuggestion",orderExtensionSuggestion);
        if (orderInfoVo==null){
            params.put("extensioncheck","");
        }else {
            params.put("extensioncheck",orderInfoVo);
        }
        params.put("userPackage",userPackage);
        params.put("examList",examChooseVo);
        params.put("examExtensionList",extensionVos);
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
    //@RequiresPermissions("upms/orderAppointment/selectListInfo")
    public ResultMap selectListInfo(
            @ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
            @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
            @ApiParam(value = "医生编号")@RequestParam(required = false)String relatedNo,
            @ApiParam(value = "状态")@RequestParam(required = false) int status,
            @ApiParam(value = "查询关键字")@RequestParam(required = false) String name){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("relatedNo", relatedNo);
        params.put("status",status);
        params.put("name",name);
        PageUtils<Map<String, Object>> pageList = orderAppointmentService.selectList(params);
        return ResultMap.ok().put("data",pageList);
    }

    /**
     * 患者的检验报告  --wh
     */
    @ApiOperation(value = "患者的检验报告", notes = "患者的检验报告")
    @GetMapping("/brReport")
    //@RequiresPermissions("upms/orderAppointment/brReport")
    public ResultMap brReport(String userId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId",userId);
        List<ExamReportReviewVo> examReportReviewVos = orderAppointmentService.selectBRReport(params);
        return ResultMap.ok().put("data",examReportReviewVos);
    }


    /**
     * 我的患者详情  --wh
     */
    @ApiOperation(value = "我的患者详情", notes = "我的患者详情")
    @GetMapping("/userInfo")
    //@RequiresPermissions("upms/orderAppointment/userInfo")
    public ResultMap userInfo(String userId){
        DoctorUserInfo doctorUserInfo = orderAppointmentService.selectInfo(userId);
        return ResultMap.ok().put("data",doctorUserInfo);
    }

    /**
     * 护士上门费用信息
     */
    @ApiOperation(value = "护士上门信息",notes = "护士上门配置信息")
    @GetMapping("/getNurPrice")
    @RequiresPermissions("upms/orderAppointment/getNurPrice")
    public ResultMap getPrice(){
        Map<String,Object> params = new HashMap<>();
        params.put("category",101);
        SysGlobalSetting sysGlobalSetting = sysGlobalSettingService.getSetting(params);
        return ResultMap.ok().put("data",sysGlobalSetting.getPrices());
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
        Map<String,Object> params = new HashMap<>();
        OrderAppointment appointment  = new OrderAppointment();
        String userId = orderAppointment.getUserId();
        params.put("userId",userId);
        SysMessage message = new SysMessage();
        OrderExtensionExam orderExtensionExam = new OrderExtensionExam();
        OrderMain orderMain = new OrderMain();
        Double amount,amountAdditional = 0.0;
        OrderDetail orderDetail = new OrderDetail();
        OrderAdditionalInfo orderAdditionalInfo = new OrderAdditionalInfo();
        SysDoctorOppointment sysDoctorOppointment = new SysDoctorOppointment();
        try {
            if((orderAppointment.getAppointmentCates()==1||orderAppointment.getAppointmentCates()==3)
                    &&orderAppointment.getAppointDate()!=null
                    &&orderAppointment.getOrderNo()!=null&&orderAppointment.getOption1()!=null
                    &&orderAppointment.getTimeFrom()!=null){
                params.put("category",101);
                SysGlobalSetting setting = sysGlobalSettingService.getSetting(params);
                amount = setting.getPrices();
                if (UUIDGenerator.differentDays(new Date(),orderAppointment.getAppointDate())<setting.getAppointmentDays().intValue()){
                    return ResultMap.error("请提前"+setting.getAppointmentDays()+"天预约!");
                }
                Integer cates = orderAppointment.getAppointmentCates();
                appointment.setAppointmentCates(cates);
                appointment.setAppointDate(orderAppointment.getAppointDate());
                appointment.setTimeFrom(orderAppointment.getTimeFrom());
                appointment.setUserId(userId);
                appointment.setCreateBy(userId);
                appointment.setCreationTime(new Date());
                String orderNo = orderAppointment.getOrderNo();
                appointment.setOrderNo(orderNo);
                appointment.setServiceOption(orderAppointment.getOption1());
                orderAdditionalInfo.setAppointmentCates(cates);
                orderAdditionalInfo.setCreateBy(userId);
                orderAdditionalInfo.setOption1(orderAppointment.getOption1());
                orderAdditionalInfo.setOrderNo(orderNo);
                if (orderAppointment.getOption1()==1){
                    if (orderAppointment.getAddress()!=null){
                        appointment.setAddress(orderAppointment.getAddress());
                        orderAppointmentService.save(appointment);
                        message.setBusinessCate(3);
                        message.setMsgCate(3);
                        message.setContent("您预约上门服务已被护士接单，请您关注上门时间并且提前做好相应的准备，保持电话畅通。");
                        orderMain.setOrderCates(cates);
                        orderMain.setParentNo(orderNo);
                        String orderNoNew = createOrderNo();
                        orderMain.setOrderNo(orderNoNew);
                        orderMain.setStatus(0);
                        orderMain.setUserId(userId);
                        orderMain.setAmount(amount);
                        orderAdditionalInfo.setAmount(amount);
                        orderAdditionalInfo.setOrderNo(orderNoNew);
                        orderMainService.save(orderMain);
                        orderAdditionalInfoService.save(orderAdditionalInfo);
                        sysMessageService.save(message);
                        return ResultMap.ok().put("data",orderNoNew);
                    }
                }else if (orderAppointment.getOption1()==2){
                    if (orderAppointment.getInstitutionId()!=null){
                        params.put("institutionId",orderAppointment.getInstitutionId());
                        appointment.setInstitutionId(orderAppointment.getInstitutionId());
                        appointment.setStatus(2);
                        orderAppointmentService.save(appointment);
                        message.setBusinessCate(3);
                        message.setMsgCate(2);
                        message.setUserId(userId);
                        message.setOrderNo(orderNo);
                        message.setContent("预约成功！请您准时于"+orderAppointment.getAppointDate().getDate()+
                                "前往"+sysInstitutionService.getInfo(params).getName()+"就诊,迟到将造成无法就诊。");
                        orderAdditionalInfoService.save(orderAdditionalInfo);
                        sysMessageService.save(message);
                        return ResultMap.ok().put("data",orderNo);
                    }
                }else {
                    return ResultMap.error("参数错误");
                }
            }else if (orderAppointment.getAppointmentCates()==2
                    &&orderAppointment.getInstitutionId()!=null
                    &&orderAppointment.getParentNo()!=null
                    &&orderAppointment.getExtensionItems()!=null){
                String orderNo = createOrderNo();
                Integer orderCates = orderAppointment.getAppointmentCates();
                String parentNo = orderAppointment.getParentNo();
                String msg = "";
                params.put("orderNo",parentNo);
                params.put("examId",orderMainService.getReferenceNo(params).getReferenceNo());
                //套餐内项
                List<ExamExtensionVo> extensionVos = examPackageDetailService.getEEChoosen(params);
                boolean exist = false;
                amount = 0.0;
                for(int i = 0;i<orderAppointment.getExtensionItems().size();i++){
                    orderExtensionExam.setCreateBy(userId);
                    Integer detailId = orderAppointment.getExtensionItems().get(i).getExamDetailId();
                    Integer masterId = orderAppointment.getExtensionItems().get(i).getExamMasterId();
                    params.put("detailId",detailId);
                    params.put("masterId",masterId);
                    orderExtensionExam.setExamDetailId(detailId);
                    orderExtensionExam.setExamMasterId(masterId);
                    orderExtensionExam.setOrderNo(orderNo);
                    int sysId = orderExtensionExamService.saveOne(orderExtensionExam);
                    for (int j = 0;j<extensionVos.size();j++){
                        if (extensionVos.get(j).getMasterId().equals(masterId)&&extensionVos.get(j).getDetailId().equals(detailId)){
                            exist = true;
                            break;
                        }
                    }
                    if (!exist){
                        ExamDetail examDetail = examDetailService.getItem(params);
                        ExamMaster examMaster = examMasterService.getItem(params);
                        msg+= examMaster.getName()
                                + examDetail.getItemName();
                        amount+= examDetail.getAmount()==null?0:examDetail.getAmount();
                    }
                    exist = false;
                    appointment.setExtensionItemId(sysId);
                    appointment.setParentNo(parentNo);
                    appointment.setInstitutionId(orderAppointment.getInstitutionId());
                    appointment.setUserId(userId);
                    appointment.setAppointmentCates(orderCates);
                    appointment.setCreateBy(userId);
                    appointment.setOrderNo(orderNo);
                    appointment.setStatus(2);
                    orderAppointmentService.save(appointment);
                }
                if (msg!=""||msg!=null){
                    message.setContent("您已经购买了体检额外项目服务，包含服务项："+msg);
                    message.setMsgCate(1);
                    message.setUserId(userId);
                    message.setOrderNo(orderNo);
                    message.setBusinessCate(2);
                    sysMessageService.save(message);
                }
                orderMain.setUserId(userId);
                orderMain.setParentNo(parentNo);
                orderMain.setOrderNo(orderNo);
                orderMain.setStatus(0);
                orderMain.setAmount(amount);
                orderMain.setOrderCates(orderCates);
                orderMainService.save(orderMain);
                return ResultMap.ok().put("data",orderNo);
            }else if (orderAppointment.getAppointmentCates()==4
                    &&orderAppointment.getInstitutionId()!=null
                    &&orderAppointment.getParentNo()!=null
                    &&orderAppointment.getExtensionItems()!=null
                    &&orderAppointment.getHrOppointmentId()!=null) {
                String orderNo = createOrderNo();
                Integer orderCates = orderAppointment.getAppointmentCates();
                String parentNo = orderAppointment.getParentNo();
                String msg = "";
                params.put("orderNo",parentNo);
                params.put("examId",orderMainService.getReferenceNo(params).getReferenceNo());
                //套餐内项
                List<ExamExtensionVo> extensionVos = examPackageDetailService.getEEChoosen(params);
                boolean exist = false;
                amount = 0.0;
                for(int i = 0;i<orderAppointment.getExtensionItems().size();i++){
                    orderExtensionExam.setCreateBy(userId);
                    Integer detailId = orderAppointment.getExtensionItems().get(i).getExamDetailId();
                    Integer masterId = orderAppointment.getExtensionItems().get(i).getExamMasterId();
                    params.put("detailId",detailId);
                    params.put("masterId",masterId);
                    orderExtensionExam.setExamDetailId(detailId);
                    orderExtensionExam.setExamMasterId(masterId);
                    orderExtensionExam.setOrderNo(orderNo);
                    int sysId = orderExtensionExamService.saveOne(orderExtensionExam);
                    for (int j = 0;j<extensionVos.size();j++){
                        if (extensionVos.get(j).getMasterId().equals(masterId)&&extensionVos.get(j).getDetailId().equals(detailId)){
                            exist = true;
                            break;
                        }
                    }
                    if (!exist){
                        ExamDetail examDetail = examDetailService.getItem(params);
                        ExamMaster examMaster = examMasterService.getItem(params);
                        msg+= examMaster.getName()
                                + examDetail.getItemName();
                        amount+= examDetail.getAmount()==null?0:examDetail.getAmount();
                    }
                    exist = false;
                    appointment.setExtensionItemId(sysId);
                    appointment.setParentNo(parentNo);
                    appointment.setInstitutionId(orderAppointment.getInstitutionId());
                    appointment.setUserId(userId);
                    appointment.setAppointmentCates(orderCates);
                    appointment.setStatus(2);
                    appointment.setCreateBy(userId);
                    appointment.setOrderNo(orderNo);
                    orderAppointmentService.save(appointment);
                }
                if (msg!=""||msg!=null){
                    message.setContent("您已经购买了体检额外项目服务，包含服务项："+msg);
                    message.setMsgCate(1);
                    message.setUserId(userId);
                    message.setOrderNo(orderNo);
                    message.setBusinessCate(2);
                    sysMessageService.save(message);
                }
                orderMain.setUserId(userId);
                orderMain.setParentNo(parentNo);
                orderMain.setHrOppointmentId(orderAppointment.getHrOppointmentId());
                orderMain.setOrderNo(orderNo);
                orderMain.setStatus(0);
                orderMain.setAmount(amount);
                orderMain.setOrderCates(orderCates);
                orderMainService.save(orderMain);
                return ResultMap.ok().put("data",orderNo);
            }else if (orderAppointment.getAppointmentCates()==5
                    &&orderAppointment.getOrderNo()!=null
                    &&orderAppointment.getRelatedNo()!=null
                    &&orderAppointment.getAppointDate()!=null
                    &&orderAppointment.getTimeFrom()!=null
                    &&orderAppointment.getTimeTo()!=null){
                UserFamilyDoctor userFamilyDoctor = userFamilyDoctorService.getUserFD(params);
                if (userFamilyDoctor.getRestCount()==0){
                    return ResultMap.error("家庭医生预约服务次数已用完");
                }
                sysDoctorOppointment.setOrderNo(orderAppointment.getOrderNo());
                sysDoctorOppointment.setAppointmentCates(5);
                sysDoctorOppointment.setUserId(orderAppointment.getUserId());
                sysDoctorOppointment.setUserCate("2");
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
                if (orderAppointment.getTimes()!=0){
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
                    if (orderAppointment.getOption2()==1){
                        //陪诊 增加一条订单
                        orderMain.setOrderCates(6);
                        params.put("category",802);
                        amount = sysGlobalSettingService.getSetting(params).getPrices();
                        String newNo = createOrderNo();
                        orderMain.setOrderNo(newNo);
                        orderMain.setParentNo(orderNo);
                        orderMain.setStatus(0);
                        orderMain.setUserId(userId);
                        orderMain.setAmount(amount); //缺少陪诊金额信息
                        orderMainService.save(orderMain);
                        orderAdditionalInfo.setAmount(amount);  //缺少陪诊金额信息
                        orderAdditionalInfoService.save(orderAdditionalInfo);
                        return ResultMap.ok().put("data",newNo);
                    }
                }else {
                    //如果没有免费次数了，或需要陪诊 要往order_main里插入一条记录
                    String orderNo = createOrderNo();
                    params.put("category",106);
                    amount = sysGlobalSettingService.getSetting(params).getPrices(); //缺少门诊绿通单独购买价格信息
                    params.put("category",802);
                    amountAdditional = sysGlobalSettingService.getSetting(params).getPrices();
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
                    if (orderAppointment.getOption2()==1){
                        amount = amount + amountAdditional; //缺少陪诊价格信息
                    }
                    orderAdditionalInfo.setAmount(amountAdditional);
                    orderAdditionalInfoService.save(orderAdditionalInfo);
                    orderMain.setOrderCates(6);
                    orderMain.setOrderNo(orderNo);
                    orderMain.setStatus(0);
                    orderMain.setUserId(userId);
                    orderMain.setAmount(amount);
                    orderMainService.save(orderMain);
                    return ResultMap.ok().put("data",orderNo);
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
            Map<String,Object> map = new HashMap<>();
            OrderAppointment oa = orderAppointmentService.getById(orderAppointment.getSysId());
            int count = orderAppointmentService.getCount(oa.getOrderNo());
            map.put("category",101);
            if (count>sysGlobalSettingService.getSetting(map).getChangeCounts()){
                return ResultMap.error("修改次数已达最大,无法修改");
            }
            orderAppointment.setIsCancelled(1);
            orderAppointmentService.updateById(orderAppointment);
            OrderAppointment newOA = orderAppointmentService.getById(orderAppointment.getSysId());
            newOA.setIsCancelled(0);
            newOA.setCreationTime(new Date());
            orderAppointmentService.save(newOA);
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


    /**
     * 查看家庭医生服务上门预约信息
     */
    @ApiOperation(value = "查看家庭医生服务上门预约信息", notes = "查看家庭医生服务上门预约信息")
    @GetMapping("/selectUpDoorOppointment")
    @RequiresPermissions("upms/orderAppointment/selectUpDoorOppointment")
    public ResultMap selectUpDoorOppointment(String orderNo){
        OrderOppintmentW a = orderAppointmentService.selectUpDoorOppointment(orderNo);
        return ResultMap.ok().put("data",a);
    }

}
