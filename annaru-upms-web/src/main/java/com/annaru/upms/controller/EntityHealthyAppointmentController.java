package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.service.*;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    private IOrderAppointmentService orderAppointmentService;

    @Reference
    private ISysConfigService iSysConfigService; //系统配置表

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
    public ResultMap selectUpDoorList(Integer status, String relatedNo, Integer isSubmitted){
        if(status==null){
            status=100;
        }
        if(isSubmitted==null){
            isSubmitted=100;
        }
        List<EntityHealthyAppointmentVo> entityHealthyAppointmentVos = entityHealthyAppointmentService.selectUpDoorServer(status, relatedNo, isSubmitted);
        return ResultMap.ok().put("data",entityHealthyAppointmentVos);
    }




    /**
     * 医生接收患者 修改status状态
     */
    @ApiOperation(value = "医生接收患者")
    @PostMapping("/updateStatus")
    @RequiresPermissions("upms/entityHealthyAppointment/updateStatus")
    public ResultMap updateStatus(String orderNo) {
        try {
            //修改健康预约表状态
            entityHealthyAppointmentService.updateStatusByOrderNo(1,orderNo);
            //修改订单预约表状态
            orderAppointmentService.updateStatus(1,orderNo);
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
    @GetMapping("/selectUserAndRelativeList/{userId}")
    public ResultMap selectUserAndRelativeList(@PathVariable("userId") String userId){
        List<EntityHealthyAppointmentVo> entityHealthyAppointmentVo = entityHealthyAppointmentService.selectUserAndRelative(userId);
        return ResultMap.ok().put("data",entityHealthyAppointmentVo);
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
    @RequiresPermissions("upms/entityHealthyAppointment/list")
    public ResultMap list(@ApiParam(value = "当前页", defaultValue="1")@RequestParam(required = false) long page,
                       @ApiParam(value = "每页数量", defaultValue = "10")@RequestParam(required = false) long limit,
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
    @RequiresPermissions("upms/entityHealthyAppointment/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        EntityHealthyAppointment entityHealthyAppointment = entityHealthyAppointmentService.getById(sysId);
        return ResultMap.ok().put("data",entityHealthyAppointment);
    }

    /**
     * 添加企业门诊绿通预约
     */
    @ApiOperation(value = "添加企业家庭医生上门预约")
    @PostMapping("/save")
    @RequiresPermissions("upms/entityHealthyAppointment/save")
    public ResultMap save(@RequestBody EntityHealthyAppointment entityHealthyAppointment) {
        OrderMain orderMain = new OrderMain();
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService , SysConfigUtil.ORDERNO);
            //添加订单主表
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());
            orderMain.setCreationtime(new Date());
            orderMain.setOrderCates(5);
            boolean save = orderMainService.save(orderMain);

            if(save=true){
                //添加entityHealthyAppointment 表
                entityHealthyAppointment.setOrderNo(SysConfigUtil.getNoBySysConfig());
                entityHealthyAppointmentService.save(entityHealthyAppointment);
            }
            if(save=true){
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
