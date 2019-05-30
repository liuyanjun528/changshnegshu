package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.EntityHealthyAppointment;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.service.IEntityHealthyAppointmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



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

    /**
     * 通过用户查询亲属
     */
    /**
     * 信息
     */
    @ApiOperation(value = "通过用户查询亲属", notes = "通过用户查询亲属")
    @GetMapping("/selectUserAndRelative/{userId}")
   // @RequiresPermissions("upms/entityHealthyAppointment/info")
    public ResultMap selectUserAndRelative(@PathVariable("userId") String userId){
        List<UserBasic> userBasics = entityHealthyAppointmentService.selectUserAndRelative(userId);
        return ResultMap.ok().put("data",userBasics);
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
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/entityHealthyAppointment/save")
    public ResultMap save(@Valid @RequestBody EntityHealthyAppointment entityHealthyAppointment) {
        try {
            entityHealthyAppointmentService.save(entityHealthyAppointment);
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
