package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.*;
import com.annaru.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


/**
 * 企业绿通行
 *
 * @author xck
 * @date 2019-05-20 16:18:39
 */
@Api(tags = {"企业绿通行"}, description = "企业绿通行")
@RestController
@RequestMapping("lcd/orderAdditionalInfo")
public class OrderAdditionalInfoController extends BaseController {
    @Reference
    private IOrderAdditionalInfoService orderAdditionalInfoService;

    @Reference
    private IEntityHealthyAppointmentService entityHealthyAppointmentService;

    @Reference
    private ISysConfigService sysConfigService; //系统配置表

    @Reference
    private IOrderMainService orderMainService;

    @Reference
    private ISysMessageService sysMessageService;// 消息表
    @Reference
    private ISysGlobalSettingService sysGlobalSettingService;//系统全局参数管理
    @Reference
    private ISysMessageTemplateService sysMessageTemplateService;
    @Reference
    private IUserBasicService userBasicService;

    /**
     * 体检人信息 wh
     */
    @ApiOperation(value = "体检人信息", notes = "体检人信息")
    @GetMapping("userOrRelativeInfo")
    //@RequiresPermissions("lcd/orderAdditionalInfo/userOrRelativeInfo")
    public ResultMap userOrRelativeInfo(String userId, String relativeId){
        List<UserCards> cards = orderAdditionalInfoService.selectUserOrRelativeInfo(userId, relativeId);
        return ResultMap.ok().put("data",cards);
    }




    /**
     * 添加企业绿通行
     */
    @ApiOperation(value = "添加企业绿通行")
    @PostMapping("/saveGreenPassage")
    public ResultMap saveGreenPassage(@RequestBody OrderAdditionalInfo orderAdditionalInfo, String[] RelativeId) {

        try {
            //查询sys_global_setting 获取陪诊的金额
            Map<String, Object> params = new HashMap<>();
            params.put("category",802);
            SysGlobalSetting setting = sysGlobalSettingService.getSetting(params);

            SysConfig sysConfig = SysConfigUtil.getSysConfig(sysConfigService , SysConfigUtil.ORDERNO);
            orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().setOrderNo(SysConfigUtil.getNoBySysConfig());
            //添加orderAdditionalInfo 表
            orderAdditionalInfo.setOrderNo(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderNo());
            if(orderAdditionalInfo.getOption2()==1){
                orderAdditionalInfo.setAmount(setting.getPrices());
            }
            orderAdditionalInfo.setAppointmentCates(6);
            orderAdditionalInfo.setCreationTime(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getCreationtime());
            int i = orderAdditionalInfoService.insertGreenPassage(orderAdditionalInfo, RelativeId);

            if(i > 0){
                //查询用户名
                UserBasic userBasic = userBasicService.selectByUid(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getUserId());
                String fullName = userBasic.getFullName();
                //查询套餐模板
                SysMessageTemplate sysMessageTemplate = sysMessageTemplateService.selectMessageTemplate(7);
                String contentTemplate = sysMessageTemplate.getContentTemplate();
                String message = contentTemplate.replace("[full_name]", fullName);//替换过的消息
                //企业家庭医生预约成功往消息表添加一条数据
                SysMessage sm=new SysMessage();
                sm.setOrderNo(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderNo());// 订单号
                sm.setMsgCate(2);//2:通知消息
                sm.setBusinessCate(3);//3:分布体检预约信息
                sm.setUserId(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getUserId());//用户
                sm.setCreationTime(new Date());
                sm.setContent(message);//内容
                sysMessageService.save(sm);
            }


            if(i>0){
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
            }
            if (0==i){
                return ResultMap.error("运行异常，请联系管理员");
            }
            return ResultMap.ok("添加成功").put("data",orderAdditionalInfo.getOrderNo());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }





    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    //@RequiresPermissions("lcd/orderAdditionalInfo/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = orderAdditionalInfoService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看lcd详情")
    @GetMapping("/info/{sysId}")
    //@RequiresPermissions("lcd/orderAdditionalInfo/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        OrderAdditionalInfo orderAdditionalInfo = orderAdditionalInfoService.getById(sysId);
        return ResultMap.ok().put("data",orderAdditionalInfo);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
   // @RequiresPermissions("lcd/orderAdditionalInfo/save")
    public ResultMap save(@Valid @RequestBody OrderAdditionalInfo orderAdditionalInfo) {
        try {
            orderAdditionalInfoService.save(orderAdditionalInfo);

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
    //@RequiresPermissions("lcd/orderAdditionalInfo/update")
    public ResultMap update(@Valid @RequestBody OrderAdditionalInfo orderAdditionalInfo) {
        try {
            orderAdditionalInfoService.updateById(orderAdditionalInfo);
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
    //@RequiresPermissions("lcd/orderAdditionalInfo/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderAdditionalInfoService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
