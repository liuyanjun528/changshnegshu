package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.SysConfig;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.vo.UserRelativesDetailVoZ;
import com.annaru.upms.entity.vo.UserRelativesVoZ;
import com.annaru.upms.service.ISysConfigService;
import com.annaru.upms.service.IUserBasicService;
import jodd.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.UserRelatives;
import com.annaru.upms.service.IUserRelativesService;

import javax.annotation.Resource;
import javax.validation.Valid;
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
    @Reference
    private ISysConfigService iSysConfigService; //系统配置表
    @Reference
    private IUserBasicService userBasicService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/userRelatives/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String userId){

        if (StringUtil.isBlank(userId)){
            return ResultMap.error("用户编号不能为空！");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("userId", userId);
        PageUtils<Map<String, Object>> pageList = userRelativesService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 亲属管理列表
     * @author zk
     * @date 2019-07-02
     */
    @ApiOperation(value = "亲属管理列表", notes = "亲属管理列表")
    @GetMapping("/managerUserRelativesVoZ")
    @RequiresPermissions("upms/userRelatives/managerUserRelativesVoZ")
    public ResultMap managerUserRelativesVoZ(@RequestParam String userId){
        UserRelativesVoZ userRelativesVoZ = userRelativesService.managerUserRelativesVoZ(userId);
        return ResultMap.ok().put("data",userRelativesVoZ);
    }

    /**
     * 添加亲属基本信息
     * @author zk
     * @date 2019-07-02
     */
    @ApiOperation(value = "添加亲属基本信息")
    @PostMapping("/saveUserRelatives")
    @RequiresPermissions("upms/userRelatives/saveUserRelatives")
    public ResultMap saveUserRelatives(@Valid @RequestBody UserRelativesDetailVoZ userRelativesDetailVoZ) {
        try {
            List<UserRelatives> userRelatives1 = userRelativesService.getUserRelativesList(userRelativesDetailVoZ.getUserId());
            if (userRelatives1 != null && userRelatives1.size() >= 3){
                return ResultMap.error("该用户已有三条亲属！");
            }
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.RELATIVENO);
            String relativeId = SysConfigUtil.getNoBySysConfig();
            if (SysConfigUtil.saveRefNo(sysConfig)){
                SysConfig sysConfig1 = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.USERNO);
                String userId = SysConfigUtil.getNoBySysConfig();
                if (SysConfigUtil.saveRefNo(sysConfig1)){
                    if (userRelativesService.saveUserRelatives(userRelativesDetailVoZ, relativeId, userId)){
                        return ResultMap.ok("添加成功");
                    }
                }
            }

            return ResultMap.error("运行异常，请联系管理员");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 修改亲属基本信息
     * @author zk
     * @date 2019-07-02
     */
    @ApiOperation(value = "修改亲属基本信息")
    @PostMapping("/updateUserRelatives")
    @RequiresPermissions("upms/userRelatives/updateUserRelatives")
    public ResultMap updateUserRelatives(@Valid @RequestBody UserRelativesDetailVoZ userRelativesDetailVoZ) {
        try {
            UserRelatives userRelatives1 = userRelativesService.getById(userRelativesDetailVoZ.getUrSysId());
            if (userRelatives1 == null){
                return ResultMap.error("该亲属不存在！");
            }
            if (userRelativesService.updateUserRelatives(userRelatives1, userRelativesDetailVoZ)){
                return ResultMap.ok("修改成功");
            }
            return ResultMap.error("运行异常，请联系管理员");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


    /**
     * 删除亲属基本信息
     * @author zk
     * @date 2019-07-02
     */
    @ApiOperation(value = "删除亲属基本信息")
    @PostMapping("/deleteUserRelatives")
    @RequiresPermissions("upms/userRelatives/deleteUserRelatives")
    public ResultMap deleteUserRelatives(@Valid @RequestBody UserRelativesDetailVoZ userRelativesDetailVoZ) {
        try {
            UserRelatives userRelatives1 = userRelativesService.getById(userRelativesDetailVoZ.getUrSysId());
            if (userRelatives1 == null){
                return ResultMap.error("该亲属不存在！");
            }
            if (userRelativesService.deleteUserRelatives(userRelatives1, userRelativesDetailVoZ)){
                return ResultMap.ok("删除成功");
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
    @RequiresPermissions("upms/userRelatives/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        UserRelatives userRelatives = userRelativesService.getById(sysId);
        return ResultMap.ok().put("data",userRelatives);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/userRelatives/save")
    public ResultMap save(@Valid @RequestBody UserRelativesDetailVoZ userRelativesDetailVoZ) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("cellphoneNo", userRelativesDetailVoZ.getCellphoneNo());
            UserBasic userBasic1 = userBasicService.selectByData(params);
            if (userBasic1 != null){
                return ResultMap.error("改手机号已存在！");
            }
            List<UserRelatives> userRelatives1 = userRelativesService.getUserRelativesList(userRelativesDetailVoZ.getUserId());
            if (userRelatives1 != null && userRelatives1.size() >= 3){
                return ResultMap.error("该用户已有三条亲属！");
            }
            SysConfig sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.RELATIVENO);
            String relativeId = SysConfigUtil.getNoBySysConfig();
            if (SysConfigUtil.saveRefNo(sysConfig)){
                SysConfig sysConfig1 = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.USERNO);
                String userId = SysConfigUtil.getNoBySysConfig();
                if (SysConfigUtil.saveRefNo(sysConfig1)){
                    if (userRelativesService.saveUserRelatives1(userRelativesDetailVoZ, relativeId, userId)){
                        return ResultMap.ok("添加成功");
                    }
                }
            }

            return ResultMap.error("运行异常，请联系管理员");
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
            userRelatives.setEditTime(new Date());
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
    public ResultMap delete(String userId, String relativeId) {
        try {
            int i = userRelativesService.DeleteRelative(userId, relativeId);
            if(i>0){
                return ResultMap.ok("删除成功！");
            }
            return ResultMap.error("删除失败！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
