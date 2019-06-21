package com.annaru.upms.controller;

import java.util.*;

import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.EntityHealthyAppointment;
import com.annaru.upms.entity.UserSurveyMain;
import com.annaru.upms.entity.vo.EntityPurchseMainVo;
import com.annaru.upms.service.IEntityHealthyAppointmentService;
import com.annaru.upms.service.IExamUserHealthyAppraisalService;
import com.annaru.upms.service.IUserSurveyMainService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.EntityPurchseMain;
import com.annaru.upms.service.IEntityPurchseMainService;
import javax.validation.Valid;



/**
 * 企业健康服务客户购买记录主表
 *
 * @author xck
 * @date 2019-05-30 13:28:08
 */
@Api(tags = {"企业健康服务客户购买记录主表管理"}, description = "企业健康服务客户购买记录主表管理")
@RestController
@RequestMapping("upms/entityPurchseMain")
public class EntityPurchseMainController extends BaseController {

    @Reference
    private IEntityPurchseMainService entityPurchseMainService; //开启健康服务
    @Reference
    private IEntityHealthyAppointmentService entityHealthyAppointmentService; //预约
    @Reference
    private IExamUserHealthyAppraisalService examUserHealthyAppraisalService; //健康评估
    @Reference
    private IUserSurveyMainService userSurveyMainService; //问券调查

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/entityPurchseMain/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = entityPurchseMainService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 企业健康服务首页的健康日志按月筛选
     * @author zk
     * @date 2019-06-21
     */
    @ApiOperation(value = "企业健康服务首页的健康日志按月筛选", notes = "企业健康服务首页的健康日志按月筛选")
    @GetMapping("/selectUserOrRelativeInfo/getTimeByUserIdZ")
    public ResultMap getTimeByUserIdZ(@RequestParam("userId") String userId, @RequestParam("startDate") String startDate) {
        try {
            List<String> list = new ArrayList<>();
            EntityPurchseMain entityPurchseMain = entityPurchseMainService.getTimeByUserIdZ(userId, startDate);
            if (entityPurchseMain != null){
                list.add(DateUtil.format(entityPurchseMain.getTerminatedDate()));
                UserSurveyMain userSurveyMain = userSurveyMainService.getTimeByUserIdZ(userId, startDate);
                if (userSurveyMain != null){
                    list.add(DateUtil.format(userSurveyMain.getSurveyTime()));
                    EntityHealthyAppointment entityHealthyAppointment = entityHealthyAppointmentService.getTimeByUserIdZ(userId, startDate);
                }
            }
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 查询购买企业套餐的用户或其亲属列表
     */
    @ApiOperation(value = "查询购买企业套餐的用户或其亲属列表", notes = "查询购买企业套餐的用户或其亲属列表")
    @GetMapping("/selectUserOrRelativeInfo/{userId}")
    public ResultMap selectUserOrRelativeInfo(@PathVariable("userId") String userId) {
        try {
            List<EntityPurchseMainVo> entityPurchseMainVoList = entityPurchseMainService.selectEntityPurchseMainListByUserId(userId);
            return ResultMap.ok().put("data", entityPurchseMainVoList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 通过订单号查询企业健康服务客户购买记录信息
     */
    /*@ApiOperation(value = "通过订单号查询企业健康服务客户购买记录信息", notes = "通过订单号查询企业健康服务客户购买记录信息")
    @GetMapping("/getEntityPurchseMainByOrderNo/{OrderNo}")
    @RequiresPermissions("upms/entityPurchseMain/getEntityPurchseMainByOrderNo")
    public ResultMap getEntityPurchseMainByOrderNo(@PathVariable("OrderNo") String OrderNo){
        try {
            EntityPurchseMainVo entityPurchseMainVo = entityPurchseMainService.getEntityPurchseMainByOrderNo(OrderNo);
            return ResultMap.ok().put("data",entityPurchseMainVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }*/

    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/entityPurchseMain/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            EntityPurchseMain entityPurchseMain = entityPurchseMainService.getById(sysId);
            return ResultMap.ok().put("entityPurchseMain",entityPurchseMain);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/entityPurchseMain/save")
    public ResultMap save(@Valid @RequestBody EntityPurchseMain entityPurchseMain) {
        try {
            entityPurchseMainService.save(entityPurchseMain);
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
    @RequiresPermissions("upms/entityPurchseMain/update")
    public ResultMap update(@Valid @RequestBody EntityPurchseMain entityPurchseMain) {
        try {
            entityPurchseMainService.updateById(entityPurchseMain);
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
    @RequiresPermissions("upms/entityPurchseMain/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            entityPurchseMainService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
