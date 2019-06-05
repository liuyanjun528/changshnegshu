package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.entity.vo.EntityPurchseMainVo;
import com.annaru.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private ISysConfigService iSysConfigService; //系统配置表

    /**
     * 通过用户查询亲属列表
     */
    @ApiOperation(value = "通过用户查询亲属列表", notes = "通过用户查询亲属列表")
    @GetMapping("/selectUserAndRelativeList/{userId}")
   // @RequiresPermissions("upms/entityHealthyAppointment/selectUserAndRelativeList")
    public ResultMap selectUserAndRelativeList(@PathVariable("userId") String userId){
        List<EntityHealthyAppointmentVo> entityHealthyAppointmentVo = entityHealthyAppointmentService.selectUserAndRelative(userId);
        return ResultMap.ok().put("data",entityHealthyAppointmentVo);
    }

    /**
     * 查询用户或亲属信息
     */
    @ApiOperation(value = "查询用户或亲属信息列表", notes = "查询用户或亲属信息列表")
    @GetMapping("/selectUserOrRelativeInfo/{userId}/{userCate}")
    public ResultMap selectUserOrRelativeInfo(@RequestParam("userId") String userId, @RequestParam("userCate") Integer userCate){
        EntityHealthyAppointmentVo entityHealthyAppointmentVo = entityHealthyAppointmentService.selectUserOrRelativeInfo(userId, userCate);
        return ResultMap.ok().put("data",entityHealthyAppointmentVo);
    }

    /**
     * 企业查询服务预约
     */
    @ApiOperation(value = "企业查询服务预约", notes = "企业查询服务预约")
    @GetMapping("/selectServiceAppointment/{orderNo}")
    public ResultMap selectServiceAppointment(@PathVariable("orderNo") String orderNo){
        List<EntityHealthyAppointmentVo> entityHealthyAppointmentVo = entityHealthyAppointmentService.selectServiceAppointment(orderNo);
        return ResultMap.ok().put("data",entityHealthyAppointmentVo);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/entityHealthyAppointment/list")
    public ResultMap list(@ApiParam(value = "当前页", defaultValue="1")@RequestParam(required = false) long page,
                       @ApiParam(value = "每页数量", defaultValue = "10")@RequestParam(required = false) long limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = entityHealthyAppointmentService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/entityHealthyAppointment/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        EntityHealthyAppointment entityHealthyAppointment = entityHealthyAppointmentService.getById(sysId);
        return ResultMap.ok().put("data",entityHealthyAppointment);
    }

    /**
     * 添加企业门诊绿通预约
     */
    @ApiOperation(value = "添加企业门诊绿通预约")
    @PostMapping("/save")
    @RequiresPermissions("upms/entityHealthyAppointment/save")
    public ResultMap save(@Valid @RequestBody EntityHealthyAppointment entityHealthyAppointment) {
        try {
            EntityPurchseMainVo entityPurchseMainVo = entityPurchseMainService.getEntityPurchseMainByOrderNo(entityHealthyAppointment.getOrderNo());
            entityHealthyAppointment.setEntityNo(entityPurchseMainVo.getEntityNo());
            entityHealthyAppointment.setPkgMainId(entityPurchseMainVo.getPkgMainId());
            entityHealthyAppointment.setPkgDetailId(entityPurchseMainVo.getPkgDetailId());
            entityHealthyAppointment.setUserCate(entityPurchseMainVo.getUserCate());
            Map<String, Object> params = new HashMap<>();
            params.put("institutionId",entityHealthyAppointment.getInstitutionId());
            SysInstitution sysInstitution = sysInstitutionService.getInfo(params);
            entityHealthyAppointment.setAddress(sysInstitution.getAddress());
            entityHealthyAppointment.setCreationTime(new Date());

            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService , SysConfigUtil.ORDERNO);
            String orderNo = SysConfigUtil.getNoBySysConfig();
            entityHealthyAppointment.setOrderNo(orderNo);

            //保存信息到ordermain表中
            OrderMain orderMain = new OrderMain();
            orderMain.setOrderNo(orderNo);
            orderMain.setReferenceNo(Integer.toString(entityPurchseMainVo.getPkgMainId()));
            orderMain.setUserId(entityHealthyAppointment.getUserId());
            orderMain.setOrderTime(new Date());
            orderMainService.save(orderMain);
            boolean bl = entityHealthyAppointmentService.save(entityHealthyAppointment);
            if(bl == true){
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
            }
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
    @RequiresPermissions("upms/entityHealthyAppointment/update")
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
    @RequiresPermissions("upms/entityHealthyAppointment/delete")
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
