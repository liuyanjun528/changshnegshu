package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysMessageTemplate;
import com.annaru.upms.service.ISysMessageTemplateService;
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
 * 消息模板
 *
 * @author wh
 * @date 2019-09-25 16:25:15
 */
@Api(tags = {"消息模板管理"}, description = "消息模板管理")
@RestController
@RequestMapping("upms/sysMessageTemplate")
public class SysMessageTemplateController extends BaseController {
    @Reference
    private ISysMessageTemplateService sysMessageTemplateService;


    /**
      * @Description:一个公共的查询消息方法模板通过消息类型
      * @Author: wh
      * @Date: 2019/9/25 17:28
      */
    @ApiOperation(value = "一个公共的查询消息方法模板通过消息类型", notes = "一个公共的查询消息方法模板通过消息类型")
    @GetMapping("/selectMessageTemplate")
    public ResultMap selectMessageTemplate(int businessCate){
        try {
            SysMessageTemplate sysMessageTemplate = sysMessageTemplateService.selectMessageTemplate(businessCate);
            return ResultMap.ok().put("sysMessageTemplate",sysMessageTemplate);
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
    @RequiresPermissions("upms/sysMessageTemplate/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = sysMessageTemplateService.getDataPage(params);
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
    @RequiresPermissions("upms/sysMessageTemplate/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            SysMessageTemplate sysMessageTemplate = sysMessageTemplateService.getById(sysId);
            return ResultMap.ok().put("sysMessageTemplate",sysMessageTemplate);
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
    @RequiresPermissions("upms/sysMessageTemplate/save")
    public ResultMap save(@Valid @RequestBody SysMessageTemplate sysMessageTemplate) {
        try {
            sysMessageTemplateService.save(sysMessageTemplate);
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
    @RequiresPermissions("upms/sysMessageTemplate/update")
    public ResultMap update(@Valid @RequestBody SysMessageTemplate sysMessageTemplate) {
        try {
            sysMessageTemplateService.updateById(sysMessageTemplate);
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
    @RequiresPermissions("upms/sysMessageTemplate/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysMessageTemplateService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
