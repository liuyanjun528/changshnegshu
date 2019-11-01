package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.UUIDGenerator;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.entity.vo.UserFamilyDoctorVo;
import com.annaru.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 客户家庭医生
 *
 * @author xck
 * @date 2019-05-22 10:07:32
 */
@Api(tags = {"客户家庭医生管理"}, description = "客户家庭医生管理")
@RestController
@RequestMapping("upms/userFamilyDoctor")
public class UserFamilyDoctorController extends BaseController {
    @Reference
    private IUserFamilyDoctorService userFamilyDoctorService;
    @Reference
    private ISysAppraisalService sysAppraisalService;
    @Reference
    private ISysConfigService iSysConfigService; //系统编号配置表
    @Reference
    private IOrderMainService orderMainService; //订单表
    @Reference
    private ISysMessageTemplateService sysMessageTemplateService;
    @Reference
    private ISysMessageService sysMessageService;// 消息表

    /**
     * 保存家庭医生订单
     */

    @ApiOperation(value = "家庭医生下订单")
    @PostMapping("/saveFamilyDoctor")
    // @RequiresPermissions("upms/orderMain/saveFamilyDoctor")
    public ResultMap saveFamilyDoctor(@RequestBody OrderMain orderMain) {
        int i=0;
        try {
            //添加前的判断
            //该用户的家庭医生已存在 不允许再购买/已有数据 但是过期了 可以继续购买
            Map<String, Object> params = new HashMap<>();
            params.put("userId",orderMain.getUserId());
            UserFamilyDoctorVo userFamilyDoctor = userFamilyDoctorService.getUserFDInfo(params);//查询表中是否存在数据
            if(null!=userFamilyDoctor){
                i=UUIDGenerator.differentDays(new Date(),userFamilyDoctor.getEffectTo());//剩余天数
            }
            //有医生并且有剩余天数
            if(userFamilyDoctor!=null&&i>0){
                return ResultMap.error("该用户已有家庭医生，不可以再购买");
            } else{ //有医生并且剩余天数<=0||没有医生进行添加家庭医生 都是这个执行这个⬇
                SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService , SysConfigUtil.ORDERNO);
                orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
                orderMain.setOrderTime(new Date());
                Calendar cal = Calendar.getInstance();
                cal.setTime(orderMain.getOrderTime());//设置起时间
                cal.add(Calendar.YEAR, 1);//增加一年
                orderMain.getUserFamilyDoctor().setEffectTo(cal.getTime());

                Boolean aBoolean = userFamilyDoctorService.saveFamilyDoctor(orderMain);

                //查询套餐模板
                SysMessageTemplate sysMessageTemplate = sysMessageTemplateService.selectMessageTemplate(46);
                //套餐购买成功往消息表添加一条数据
                SysMessage sm=new SysMessage();
                sm.setOrderNo(orderMain.getOrderNo());// 订单号
                sm.setMsgCate(2);//1:系统消息
                sm.setBusinessCate(1);//1:购买套餐
                sm.setUserId(orderMain.getUserId());//用户
                sm.setCreationTime(new Date());
                String contentTemplate = sysMessageTemplate.getContentTemplate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String startTime = sdf.format(orderMain.getUserFamilyDoctor().getEffectTo());
                System.out.println("cessss:"+startTime);
                String message = contentTemplate.replace("[effect_to]",startTime);//替换过的消息
                sm.setContent(message);
                sysMessageService.save(sm);

                if(!aBoolean){
                    return ResultMap.error("运行异常，请联系管理员");
                }
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
            }
            return ResultMap.ok("家庭医生订单成功").put("data",orderMain.getOrderNo());
        }catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/userFamilyDoctor/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = userFamilyDoctorService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }

    /**
     * 信息
     */
    @ApiOperation(value = "查看家庭医生详情", notes = "查看家庭医生详情")
    @GetMapping("/info/{userId}")
    @RequiresPermissions("upms/userFamilyDoctor/info")
    public ResultMap info(@PathVariable("userId") String userId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId",userId);
        UserFamilyDoctorVo userFamilyDoctor = userFamilyDoctorService.getUserFDInfo(params);
        if (null!=userFamilyDoctor){
            userFamilyDoctor.setRestDay(UUIDGenerator.differentDays(new Date(),userFamilyDoctor.getEffectTo()));
            params.put("docNo",userFamilyDoctor.getDoctorNo());
            SysAppraisal appraisal = sysAppraisalService.selectOne(params);
            //如果剩余天数<0 设为中止
            if(userFamilyDoctor.getRestDay()<0){
                userFamilyDoctor.setRestDay(0);
                userFamilyDoctor.setIsTerminated(1);
                userFamilyDoctor.setTerminatedTime(new Date());
            }

            if (appraisal==null){
                userFamilyDoctor.setAppraisalStatus(0);
            }else {
                userFamilyDoctor.setAppraisalStatus(1);
                userFamilyDoctor.setUserStarCount(appraisal.getStarCount());
                userFamilyDoctor.setUserScore(appraisal.getScores());
            }
        }
        return ResultMap.ok().put("data",userFamilyDoctor);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/userFamilyDoctor/save")
    public ResultMap save(@Valid @RequestBody UserFamilyDoctor userFamilyDoctor) {
        try {
            userFamilyDoctorService.save(userFamilyDoctor);
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
    @RequiresPermissions("upms/userFamilyDoctor/update")
    public ResultMap update(@Valid @RequestBody UserFamilyDoctor userFamilyDoctor) {
        try {
            userFamilyDoctorService.updateById(userFamilyDoctor);
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
    @RequiresPermissions("upms/userFamilyDoctor/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            userFamilyDoctorService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
