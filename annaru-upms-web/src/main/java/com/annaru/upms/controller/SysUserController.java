package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.common.util.Constant;
import com.annaru.common.validator.Assert;
import com.annaru.upms.entity.SysUser;
import com.annaru.upms.entity.vo.UserVo;
import com.annaru.upms.service.ISysUserRoleService;
import com.annaru.upms.service.ISysUserService;
import com.annaru.upms.shiro.ShiroKit;
import com.annaru.upms.shiro.form.PasswordForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description com.annaru.upms.controller
 * @Author TuMinglong
 * @Date 2018/12/13 11:42
 */
@Api(tags = "系统用户管理", description = "系统用户管理")
@RestController
@RequestMapping("sys/user")
public class SysUserController extends BaseController {

    @Reference
    private ISysUserService sysUserService;
    @Reference
    private ISysUserRoleService sysUserRoleService;


    /**
     * 所有用户列表
     */
    @ApiOperation(value = "用户列表分页")
    @GetMapping("/list")
    @RequiresPermissions("sys/user/list")
    public ResultMap list(@RequestParam Map<String, Object> params){
        //只有超级管理员，才能查看所有管理员列表
        if(!ShiroKit.getUser().getId().equals(Constant.SUPER_ADMIN)){
            params.put("userId", ShiroKit.getUser().getId());
        }
        PageUtils page = sysUserService.selectDataGrid(params);

        return ResultMap.ok().put("data", page);
    }

    /**
     * 获取登录的用户信息
     */
    @ApiOperation(value = "获取当前登录的用户信息")
    @GetMapping("/info")
    public ResultMap infoLogin(){
        return ResultMap.ok().put("user", ShiroKit.getUser());
    }

    /**
     * 修改登录用户密码
     */
    @ApiOperation(value = "修改密码")
    @PostMapping("/password")
    public ResultMap password(@RequestBody PasswordForm form){
        Assert.isBlank(form.getNewPassword(), "新密码不为能空");

        SysUser user=sysUserService.getById(ShiroKit.getUser().getId());
        String password= ShiroKit.md5(form.getPassword(), user.getLoginName() + user.getSalt());
        if(!user.getPassword().equals(password)){
            return ResultMap.error("原密码不正确");
        }
        String newPassword= ShiroKit.md5(form.getNewPassword(), user.getLoginName() + user.getSalt());
        user.setPassword(newPassword);
        user.setUpdateTime(new Date());
        sysUserService.updateById(user);
        return ResultMap.ok("密码修改成功");
    }

    /**
     * 用户信息
     */
    @ApiOperation(value = "详情")
    @GetMapping("/info/{userId}")
    @RequiresPermissions("sys/user/info")
    public ResultMap info(@PathVariable("userId") String userId){
        SysUser user = sysUserService.getById(userId);
        List<String> roleIdList = sysUserRoleService.selectRoleIdListByUserId(userId);
        user.setRoleIdList(roleIdList);
        return ResultMap.ok().put("data", user);

    }

    /**
     * 保存用户
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("sys/user/save")
    public ResultMap save(@Valid @RequestBody SysUser user){
        try {
            UserVo u = sysUserService.selectByLoginName(user.getLoginName());
            if (u != null) {
                return ResultMap.error("登录名已存在");
            }
            String salt = ShiroKit.getRandomSalt(16);
            user.setSalt(salt);
            String pwd = ShiroKit.md5(user.getPassword(), user.getLoginName() + salt);
            user.setPassword(pwd);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            user.setCreateUserId(ShiroKit.getUser().getId());
            sysUserService.saveByVo(user);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            e.getStackTrace();
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 修改用户
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("sys/user/update")
    public ResultMap update(@Valid @RequestBody SysUser user){
        try {
            if (StringUtils.isNotBlank(user.getPassword())) {
                String salt = ShiroKit.getRandomSalt(16);
                user.setSalt(salt);
                String pwd = ShiroKit.md5(user.getPassword(), user.getLoginName() + salt);
                user.setPassword(pwd);
            }
            user.setUpdateTime(new Date());
            user.setCreateUserId(ShiroKit.getUser().getId());
            sysUserService.updateByVo(user);
            return ResultMap.ok("修改成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 删除用户
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    @RequiresPermissions("sys/user/delete")
    public ResultMap delete(@RequestBody String[] userIds){
        if(ArrayUtils.contains(userIds, Constant.SUPER_ADMIN)){
            return ResultMap.error("系统管理员不能删除");
        }
        if(ArrayUtils.contains(userIds, ShiroKit.getUser().getId())){
            return ResultMap.error("当前用户不能删除");
        }
        sysUserService.deleteBatch(userIds);
        return ResultMap.ok();
    }
}
