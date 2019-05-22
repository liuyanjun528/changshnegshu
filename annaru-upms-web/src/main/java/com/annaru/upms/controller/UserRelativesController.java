package com.annaru.upms.controller;

import java.util.*;

import jodd.util.StringUtil;
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

import com.annaru.upms.entity.UserRelatives;
import com.annaru.upms.service.IUserRelativesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 用户亲属信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"用户亲属信息管理"}, description = "用户亲属信息管理")
@RestController
@RequestMapping("upms/userRelatives")
public class UserRelativesController extends BaseController {
    @Reference
    private IUserRelativesService userRelativesService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/userRelatives/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String user_id){

        if (StringUtil.isBlank(user_id)){
            return ResultMap.error("用户编号不能为空！");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("userId", user_id);
        PageUtils<Map<String, Object>> pageList = userRelativesService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/userRelatives/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        UserRelatives userRelatives = userRelativesService.getById(sysId);
        return ResultMap.ok().put("userRelatives",userRelatives);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/userRelatives/save")
    public ResultMap save(@Valid @RequestBody UserRelatives userRelatives) {
        try {

//            userRelatives.setCreateUser(ShiroKit.getUser().getId());
//            userRelatives.setCreateTime(new Date());
//            userRelatives.setUpdateTime(new Date());
            userRelativesService.save(userRelatives);
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
    @RequiresPermissions("upms/userRelatives/update")
    public ResultMap update(@Valid @RequestBody UserRelatives userRelatives) {
        try {
//            userRelatives.setUpdateTime(new Date());
            userRelativesService.updateById(userRelatives);
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
    @RequiresPermissions("upms/userRelatives/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            userRelativesService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
