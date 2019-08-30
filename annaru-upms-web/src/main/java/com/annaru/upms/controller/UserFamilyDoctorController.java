package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.UUIDGenerator;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.SysAppraisal;
import com.annaru.upms.entity.SysConfig;
import com.annaru.upms.entity.UserFamilyDoctor;
import com.annaru.upms.entity.vo.UserFamilyDoctorVo;
import com.annaru.upms.service.IOrderMainService;
import com.annaru.upms.service.ISysAppraisalService;
import com.annaru.upms.service.ISysConfigService;
import com.annaru.upms.service.IUserFamilyDoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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

    /**
     * 保存家庭医生订单
     */

    @ApiOperation(value = "家庭医生下订单")
    @PostMapping("/saveFamilyDoctor")
    // @RequiresPermissions("upms/orderMain/saveFamilyDoctor")
    public ResultMap saveFamilyDoctor(@RequestBody OrderMain orderMain) {
        try {
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService , SysConfigUtil.ORDERNO);
            orderMain.setOrderNo(SysConfigUtil.getNoBySysConfig());

            Boolean aBoolean = userFamilyDoctorService.saveFamilyDoctor(orderMain);
            if(!aBoolean){
                return ResultMap.error("运行异常，请联系管理员");
            }
            SysConfigUtil.saveRefNo(sysConfig.getRefNo());

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
    @ApiOperation(value = "查看详情", notes = "查看家庭医生详情")
    @GetMapping("/info/{userId}")
    @RequiresPermissions("upms/userFamilyDoctor/info")
    public ResultMap info(@PathVariable("userId") String userId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId",userId);
        UserFamilyDoctorVo userFamilyDoctor = userFamilyDoctorService.getUserFDInfo(params);
        if (userFamilyDoctor!=null){
            userFamilyDoctor.setRestDays(UUIDGenerator.differentDays(new Date(),userFamilyDoctor.getEffectTo()));
            params.put("docNo",userFamilyDoctor.getDoctorNo());
            SysAppraisal appraisal = sysAppraisalService.selectOne(params);
            if (appraisal==null){
                userFamilyDoctor.setAppraisalStatus(0);
            }else {
                userFamilyDoctor.setAppraisalStatus(1);
            }
            return ResultMap.ok().put("data",userFamilyDoctor);
        }else {
            return ResultMap.ok().put("data","尚未绑定家庭医生");
        }
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
