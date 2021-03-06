package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.entity.vo.SysDoctorVo;
import com.annaru.upms.entity.vo.UserBasicVo;
import com.annaru.upms.entity.vo.UserEntityMappingVo;
import com.annaru.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 企业服务预约记录
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
@Api(tags = {"企业服务预约记录管理"}, description = "企业服务预约记录管理")
@RestController
@RequestMapping("upms/entityHealthyAppointment")
public class EntityHealthyAppointmentController extends BaseController {
    @Reference
    private IEntityHealthyAppointmentService entityHealthyAppointmentService;

    @Reference
    private IEntityPurchseMainService entityPurchseMainService;

    @Reference
    private ISysInstitutionService sysInstitutionService;

    @Reference
    private IOrderMainService orderMainService;

    @Reference
    private IOrderAppointmentService orderAppointmentService;

    @Reference
    private ISysConfigService sysConfigService; //系统配置表

    @Reference
    private IUserSurveyMainService userSurveyMainService; //问卷调查表
    @Reference
    private IUserEntityMappingService userEntityMappingService;

    @Reference
    private ISysMessageService sysMessageService;// 消息表
    @Reference
    private ISysGlobalSettingService sysGlobalSettingService;//系统全局参数管理
    @Reference
    private ISysMessageTemplateService sysMessageTemplateService;
    @Reference
    private IUserBasicService userBasicService;
    @Reference
    private ISysDoctorService sysDoctor;

    /**
     * 删除订单
     */
    @ApiOperation(value = "待上门服务列表（删除订单）", notes = "待上门服务列表（删除订单）")
    @PostMapping("/deleteAI")
    @ApiImplicitParam(name = "orderNo",value = "订单号",dataType = "spring",paramType = "query")
    public ResultMap refresh(String orderNo) {
        try {
            Integer b = entityHealthyAppointmentService.updateByOderNo(orderNo);
            if(0 < b){
                return ResultMap.ok("删除成功!");
            }else {
                return ResultMap.error("删除失败!");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 待上门服务列表
     */
    @ApiOperation(value = "待上门服务列表", notes = "待上门服务列表")
    @GetMapping("/selectUpDoorList")
    public ResultMap selectUpDoorList(
            @ApiParam(value = "当前页", defaultValue="1")@RequestParam(required = false) int page,
            @ApiParam(value = "每页数量", defaultValue = "10")@RequestParam(required = false) int limit,
            @ApiParam(value = "医生编号")@RequestParam(required = false)String relatedNo,
            @ApiParam(value = "待服务1/已完成3")@RequestParam(required = false)Integer status,
            @ApiParam(value = "待评估")@RequestParam(required = false)Integer isSubmitted,
            @ApiParam(value = "时间区间")@RequestParam(required = false)Integer when){
        if(status==null){
            status=100;
        }
        if(isSubmitted==null){
            isSubmitted=100;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("relatedNo", relatedNo);
        params.put("status", status);
        params.put("isSubmitted", isSubmitted);
        params.put("when",when);
        PageUtils<Map<String, Object>> pageList = entityHealthyAppointmentService.selectUpDoorServer(params);
        return ResultMap.ok().put("data",pageList);
    }




    /**
     * 医生接收患者 修改status状态
     */
    @ApiOperation(value = "医生接收患者")
    @PostMapping("/updateStatus")
    //@RequiresPermissions("upms/entityHealthyAppointment/updateStatus")
    public ResultMap updateStatus(String orderNo) {
        try {
            //修改企业健康预约表状态
            entityHealthyAppointmentService.updateStatusByOrderNo(orderNo);
            //修改user_family_doctor表状态
            orderAppointmentService.updateStatus(orderNo);
            return ResultMap.ok("修改成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }



    /**
     * 通过用户查询亲属列表
     */
    @ApiOperation(value = "通过用户查询亲属列表", notes = "通过用户查询亲属列表")
    @GetMapping("/selectUserAndRelativeList")
    public ResultMap selectUserAndRelativeList(String userId){

        List<UserBasicVo> userBasicVo = userEntityMappingService.selectUserAndRelativeInfoByUserId(userId);

        int i = userSurveyMainService.selectCount(userId);
        if(i>0){
            userBasicVo.get(0).setIsFillIn(1);
        }else {
            userBasicVo.get(0).setIsFillIn(0);
        }
        return ResultMap.ok().put("data",userBasicVo);
    }

    /**
      * @Description:查询用户是否填写调查问卷
      * @Author: wh
      * @Date: 2019/8/20 8:54
      */
    @ApiOperation(value = "查询用户是否填写调查问卷", notes = "查询用户是否填写调查问卷")
    @GetMapping("/selectUserSurvey")
    public ResultMap selectUserSurvey(String userId){
        int i = userSurveyMainService.selectCount(userId);
        return ResultMap.ok().put("data",i);
    }




    /**
     * 企业查询服务预约
     */
    @ApiOperation(value = "企业家庭医生查询服务预约", notes = "企业家庭医生查询服务预约")
    @GetMapping("/selectServiceAppointment/{orderNo}")
    public ResultMap selectServiceAppointment(@PathVariable("orderNo") String orderNo){
        List<EntityHealthyAppointmentVo> entityHealthyAppointmentVo = entityHealthyAppointmentService.selectServiceAppointment(orderNo);
        return ResultMap.ok().put("data",entityHealthyAppointmentVo);
    }

    /**
     * 企业用户患者信息查询分页
     */
    @ApiOperation(value = "企业用户患者信息分页查询")
    @GetMapping("/list")
    //@RequiresPermissions("upms/entityHealthyAppointment/list")
    public ResultMap list(@ApiParam(value = "当前页", defaultValue="1")@RequestParam(required = false) int page,
                       @ApiParam(value = "每页数量", defaultValue = "10")@RequestParam(required = false) int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String relatedNo){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("relatedNo", relatedNo);
        PageUtils<Map<String, Object>> pageList = entityHealthyAppointmentService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    //@RequiresPermissions("upms/entityHealthyAppointment/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        EntityHealthyAppointment entityHealthyAppointment = entityHealthyAppointmentService.getById(sysId);
        return ResultMap.ok().put("data",entityHealthyAppointment);
    }

    /**
      * @Description:添加前之前要查询剩余的次数
      * @Author: wh
      * @Date: 2019/8/22 11:02
      */
    @ApiOperation(value = "查询企业健康服务医生剩余的服务次数", notes = "查询企业健康服务医生剩余的服务次数")
    @GetMapping("/selectEntityServiceCount")
    public ResultMap selectEntityServiceCount(String userId){

        //查询sys_global_setting 获取家庭医生的总次数
        Map<String, Object> params = new HashMap<>();
        params.put("category",801);
        SysGlobalSetting setting = sysGlobalSettingService.getSetting(params);
        Integer counts = setting.getCounts();

        //用户已经使用的次数
        int i = entityHealthyAppointmentService.selectEntityServiceCount(userId);

        //总次数-使用次数=剩余次数
        int restCount=counts-i;
        if(restCount<0){
            restCount=0;
        }

        return ResultMap.ok().put("data",restCount);
    }


    /**
     * 添加企业家庭医生上门预约
     */
    @ApiOperation(value = "添加企业家庭医生上门预约")
    @PostMapping("/save")
    //@RequiresPermissions("upms/entityHealthyAppointment/save")
    public ResultMap save(@RequestBody EntityHealthyAppointment entityHealthyAppointment,String [] RelativeId) {

        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(sysConfigService , SysConfigUtil.ORDERNO);
            entityHealthyAppointment.getOrderMain().setOrderNo(SysConfigUtil.getNoBySysConfig());
            //添加entityHealthyAppointment 表
            entityHealthyAppointment.setOrderNo(entityHealthyAppointment.getOrderMain().getOrderNo());
            entityHealthyAppointment.setUserId(entityHealthyAppointment.getOrderMain().getUserId());
            entityHealthyAppointment.setCreationTime(new Date());
            int i = entityHealthyAppointmentService.insertEntityDoctorAppointment(entityHealthyAppointment, RelativeId);

            if(i > 0){
                //查询用户名
                UserBasic userBasic = userBasicService.selectByUid(entityHealthyAppointment.getOrderMain().getUserId());
                String fullName = userBasic.getFullName();
                //查询套餐模板
                SysMessageTemplate sysMessageTemplate = sysMessageTemplateService.selectMessageTemplate(21);
                String contentTemplate = sysMessageTemplate.getContentTemplate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String startTime = sdf.format(entityHealthyAppointment.getAppointDate());//转换时间
                String message = contentTemplate.replace("[appoint_date]", startTime);//替换过的消息
                String message1 = message.replace("[address]", entityHealthyAppointment.getAddress());//替换过的消息
                //企业家庭医生预约成功往消息表添加一条数据
                SysMessage sm=new SysMessage();
                sm.setOrderNo(entityHealthyAppointment.getOrderMain().getOrderNo());// 订单号
                sm.setMsgCate(2);//2:通知消息
                sm.setBusinessCate(3);//3:分布体检预约信息
                sm.setUserId(entityHealthyAppointment.getOrderMain().getUserId());//用户
                sm.setCreationTime(new Date());
                sm.setContent(message1);//内容
                sysMessageService.save(sm);
                // -------------------------给医生一条消息-----------------------------------
                //通过userId查询出 这个用户的医生
                EntityHealthyAppointment eha = entityHealthyAppointmentService.selectDoctorByUserId(entityHealthyAppointment.getOrderMain().getUserId());
                //拿到医生编号 查询医生的userId
                Map<String, Object> params = new HashMap<>();
                params.put("doctorNo",eha.getRelatedNo());
                SysDoctorVo one = sysDoctor.getOne(params);
                //查询消息模板
                SysMessageTemplate smt = sysMessageTemplateService.selectMessageTemplate(40);
                String ct = smt.getContentTemplate();
                String ms = ct.replace("[full_name]", fullName);//替换过的消息
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                String startTime1 = sdf1.format(entityHealthyAppointment.getAppointDate());//转换时间
                String ms1 = ms.replace("[appoint_date]", startTime1);//替换过的消息
                String ms2 = ms1.replace("[address]", entityHealthyAppointment.getAddress());//替换过的消息
                SysMessage sms=new SysMessage();
                sms.setOrderNo(entityHealthyAppointment.getOrderMain().getOrderNo());// 订单号
                sms.setMsgCate(2);//2:通知消息
                sms.setBusinessCate(3);//3:分布体检预约信息
                sms.setUserId(one.getUserId());//医生编号
                sms.setCreationTime(new Date());
                sms.setContent(ms2);//内容
                sysMessageService.save(sms);
            }

            if(i>0){
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
            }
            if(0==i){
                return ResultMap.error("运行异常，请联系管理员");
            }

            return ResultMap.ok("添加成功").put("data", entityHealthyAppointment.getOrderMain().getOrderNo());
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
    //@RequiresPermissions("upms/entityHealthyAppointment/update")
    public ResultMap update(@Valid @RequestBody EntityHealthyAppointment entityHealthyAppointment) {
        try {
            entityHealthyAppointmentService.updateById(entityHealthyAppointment);
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
    //@RequiresPermissions("upms/entityHealthyAppointment/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            entityHealthyAppointmentService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
