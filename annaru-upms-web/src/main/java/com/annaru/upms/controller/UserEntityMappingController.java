package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.entity.EntityPurchseMain;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.entity.vo.EntityPurchseMainVoZ;
import com.annaru.upms.entity.vo.UserEntityMappingVo;
import com.annaru.upms.service.IEntityPurchseMainService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.shiro.ShiroKit;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.UserEntityMapping;
import com.annaru.upms.service.IUserEntityMappingService;
import javax.validation.Valid;



/**
 * 
 *
 * @author xck
 * @date 2019-06-03 12:21:40
 */
@Api(tags = {"用户企业管理"}, description = "用户企业管理")
@RestController
@RequestMapping("upms/userEntityMapping")
public class UserEntityMappingController extends BaseController {

    @Reference
    private IUserEntityMappingService userEntityMappingService;
    @Reference
    private IEntityPurchseMainService entityPurchseMainService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/userEntityMapping/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = userEntityMappingService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 选择预约人时查询企业用户及亲属列表
     */
    @ApiOperation(value = "选择预约人时查询企业用户及亲属列表", notes = "选择预约人时查询企业用户及亲属列表")
    @GetMapping("/selectUserAndRelativeList/{userId}")
    public ResultMap selectUserAndRelativeInfoByUserId(@PathVariable("userId") String userId){
        List<UserEntityMappingVo> UserEntityMappingVo = userEntityMappingService.selectUserAndRelativeInfoByUserId(userId);
        return ResultMap.ok().put("data",UserEntityMappingVo);
    }

    /**
     * @description 企业健康管理首次登陆
     * @author zk
     * @date 2019-07-02
     * @return
     */
    @ApiOperation(value = "企业健康管理首次登陆", notes = "企业健康管理首次登陆")
    @GetMapping("/getEntityPurchseMainVoZ")
    @RequiresPermissions("upms/userEntityMapping/getEntityPurchseMainVoZ")
    public ResultMap getEntityPurchseMainVoZ(@RequestParam String userId){
        try {
            EntityPurchseMainVoZ entityPurchseMainVoZ = userEntityMappingService.getEntityPurchseMainVoZ(userId);
            return ResultMap.ok().put("data",entityPurchseMainVoZ);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 企业健康管理首次登陆激活
     */
    @ApiOperation(value = "企业健康管理首次登陆激活")
    @PostMapping("/getEntityPurchseMainVoZUpdate")
    @RequiresPermissions("upms/userEntityMapping/getEntityPurchseMainVoZUpdate")
    public ResultMap getEntityPurchseMainVoZUpdate(@RequestParam Integer sysId) {
        try {
            EntityPurchseMain entityPurchseMain = entityPurchseMainService.getById(sysId);
            if (entityPurchseMain == null){
                return ResultMap.error("该企业健康服务不存在！");
            }
            if (entityPurchseMain.getIsActive() == 1){
                return ResultMap.ok("该企业健康管理激活成功！");
            }
            entityPurchseMain.setIsActive(1);
            if (entityPurchseMainService.updateById(entityPurchseMain)){
                return ResultMap.ok("该企业健康管理激活成功！");
            }
            return ResultMap.error("运行异常，请联系管理员");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/userEntityMapping/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            UserEntityMapping userEntityMapping = userEntityMappingService.getById(sysId);
            return ResultMap.ok().put("userEntityMapping",userEntityMapping);
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
    @RequiresPermissions("upms/userEntityMapping/save")
    public ResultMap save(@Valid @RequestBody UserEntityMapping userEntityMapping) {
        try {

            userEntityMappingService.save(userEntityMapping);
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
    @RequiresPermissions("upms/userEntityMapping/update")
    public ResultMap update(@Valid @RequestBody UserEntityMapping userEntityMapping) {
        try {
            userEntityMappingService.updateById(userEntityMapping);
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
    @RequiresPermissions("upms/userEntityMapping/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            userEntityMappingService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
