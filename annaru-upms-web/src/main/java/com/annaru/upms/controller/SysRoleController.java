package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.common.result.SelectTreeNode;
import com.annaru.common.util.Constant;
import com.annaru.common.validator.ValidatorUtils;
import com.annaru.upms.entity.SysRole;
import com.annaru.upms.service.ISysRoleResourceService;
import com.annaru.upms.service.ISysRoleService;
import com.annaru.upms.shiro.ShiroKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 角色管理
 * @Author TuMinglong
 * @Date 2018/12/13 15:12
 */
@Api(tags = "角色管理", description = "角色管理")
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController {

    @Reference
    private ISysRoleService sysRoleService;
    @Reference
    private ISysRoleResourceService sysRoleResourceService;

    /**
     * 角色列表
     */
    @ApiOperation(value = "角色列表分页")
    @GetMapping("/list")
    @RequiresPermissions("sys/role/list")
    public ResultMap list(@RequestParam Map<String, Object> params){
        //如果不是超级管理员，则只查询自己创建的角色列表
        if(!ShiroKit.getUser().getId().equals(Constant.SUPER_ADMIN)){
            params.put("createUserId", ShiroKit.getUser().getId());
        }
        PageUtils page = sysRoleService.selectDataGrid(params);
        return ResultMap.ok().put("data", page);
    }

    /**
     * 角色列表
     */
    @ApiOperation(value = "角色列表全部")
    @GetMapping("/select")
    @RequiresPermissions("sys/role/select")
    public ResultMap select(){
        Map<String, Object> map = new HashMap<>();
        //如果不是超级管理员，则只查询自己所拥有的角色列表
        if(!ShiroKit.getUser().getId().equals(Constant.SUPER_ADMIN)){
            map.put("createUserId", ShiroKit.getUser().getId());
        }
        List<SysRole> list = sysRoleService.selectSysRoleList(map);

        return ResultMap.ok().put("data", list);
    }

    /**
     * 角色信息
     */
    @ApiOperation(value = "详情")
    @GetMapping("/info/{roleId}")
    @RequiresPermissions("sys/role/info")
    public ResultMap info(@PathVariable("roleId") String roleId){
        SysRole role = sysRoleService.getById(roleId);
        //查询角色对应的菜单
        List<String> resourceIdList=sysRoleResourceService.selectResourceIdListByRoleId(roleId);
        role.setResourceIdList(resourceIdList);
        List<SelectTreeNode> resourceNodeList = sysRoleResourceService.selectResourceNodeListByRoleId(roleId);
        role.setResourceNodeList(resourceNodeList);
        return ResultMap.ok().put("data", role);
    }

    /**
     * 保存角色
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("sys/role/save")
    public ResultMap save(@RequestBody SysRole role){
        ValidatorUtils.validateEntity(role);
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        role.setCreateUserId(ShiroKit.getUser().getId());
        sysRoleService.saveByVo(role);

        return ResultMap.ok();
    }

    /**
     * 修改角色
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("sys/role/update")
    public ResultMap update(@RequestBody SysRole role){
        ValidatorUtils.validateEntity(role);
        role.setUpdateTime(new Date());
        role.setCreateUserId(ShiroKit.getUser().getId());
        sysRoleService.updateByVo(role);

        return ResultMap.ok();
    }

    /**
     * 删除角色
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    @RequiresPermissions("sys/role/delete")
    public ResultMap delete(@RequestBody String[] roleIds){
        sysRoleService.deleteBatch(roleIds);
        return ResultMap.ok();
    }

}
