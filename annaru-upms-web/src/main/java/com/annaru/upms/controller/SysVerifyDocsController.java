package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.controllerutil.SysConfigUtil;
import com.annaru.upms.entity.SysConfig;
import com.annaru.upms.entity.vo.SysVerifyDocsVoZ;
import com.annaru.upms.service.ISysConfigService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.SysVerifyDocs;
import com.annaru.upms.service.ISysVerifyDocsService;

import javax.annotation.Resource;
import javax.validation.Valid;



/**
 * 认证资料
 *
 * @author zk
 * @date 2019-06-10 14:59:12
 */
@Api(tags = {"认证资料管理"}, description = "认证资料管理")
@RestController
@RequestMapping("upms/sysVerifyDocs")
public class SysVerifyDocsController extends BaseController {
    @Reference
    private ISysVerifyDocsService sysVerifyDocsService;
    @Reference
    private ISysConfigService iSysConfigService;
    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysVerifyDocs/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = sysVerifyDocsService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
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
    @RequiresPermissions("upms/sysVerifyDocs/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            SysVerifyDocs sysVerifyDocs = sysVerifyDocsService.getById(sysId);
            return ResultMap.ok().put("sysVerifyDocs",sysVerifyDocs);
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
    @RequiresPermissions("upms/sysVerifyDocs/save")
    public ResultMap save(@Valid @RequestBody SysVerifyDocs sysVerifyDocs) {
        try {
            sysVerifyDocsService.save(sysVerifyDocs);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 选择职业：医生、护士认证
     */
    @ApiOperation(value = "选择职业：医生、护士认证")
    @PostMapping("/saveDocsBasics")
    @RequiresPermissions("upms/sysVerifyDocs/saveDocsBasics")
    public ResultMap saveDocsBasics(@Valid @RequestBody SysVerifyDocsVoZ sysVerifyDocsVoZ) {

            SysConfig sysConfig = null;
            if (sysVerifyDocsVoZ.getIdentification() == 2){
                // 医生
                sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.DOCTOR);
                sysVerifyDocsVoZ.setUserNo(SysConfigUtil.getNoBySysConfig());
            }else if (sysVerifyDocsVoZ.getIdentification() == 1){
                // 护士
                sysConfig = SysConfigUtil.getSysConfig(iSysConfigService, SysConfigUtil.NURSE);
                sysVerifyDocsVoZ.setUserNo(SysConfigUtil.getNoBySysConfig());
            }
            if (sysVerifyDocsService.saveDocsBasics(sysVerifyDocsVoZ)){
                SysConfigUtil.saveRefNo(sysConfig.getRefNo());
                if (SysConfigUtil.saveRefNo(sysConfig.getRefNo())){
                    return ResultMap.ok("添加成功");
                }
            }

        return ResultMap.error("运行异常，请联系管理员");

    }

    /**
     * 查询护士、医生认证信息
     */
    @ApiOperation(value = "查询护士、医生认证信息")
    @GetMapping("/selectVerInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "identification", value = "1.护士2.医生 ", dataType = "Integer", paramType = "query"),
    })
    public Object selectVerInfo(@RequestParam String userId,Integer identification) {
        try {
            SysVerifyDocsVoZ sysVerifyDocsVoZ = sysVerifyDocsService.selectVerNurse(userId, identification);
            return ResultMap.ok("ok").put("sysVerifyDocsVoZ",sysVerifyDocsVoZ);
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
    @RequiresPermissions("upms/sysVerifyDocs/update")
    public ResultMap update(@Valid @RequestBody SysVerifyDocs sysVerifyDocs) {
        try {
            sysVerifyDocsService.updateById(sysVerifyDocs);
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
    @RequiresPermissions("upms/sysVerifyDocs/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysVerifyDocsService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
