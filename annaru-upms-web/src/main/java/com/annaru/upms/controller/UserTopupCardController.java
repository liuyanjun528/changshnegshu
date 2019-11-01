package com.annaru.upms.controller;

import java.util.*;

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

import com.annaru.upms.entity.UserTopupCard;
import com.annaru.upms.service.IUserTopupCardService;
import javax.validation.Valid;



/**
 * 
 *
 * @author xck
 * @date 2019-11-01 16:27:32
 */
@Api(tags = {"管理"}, description = "管理")
@RestController
@RequestMapping("upms/userTopupCard")
public class UserTopupCardController extends BaseController {
    @Reference
    private IUserTopupCardService userTopupCardService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/userTopupCard/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = userTopupCardService.getDataPage(params);
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
    @RequiresPermissions("upms/userTopupCard/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            UserTopupCard userTopupCard = userTopupCardService.getById(sysId);
            return ResultMap.ok().put("userTopupCard",userTopupCard);
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
    @RequiresPermissions("upms/userTopupCard/save")
    public ResultMap save(@Valid @RequestBody UserTopupCard userTopupCard) {
        try {

//            userTopupCard.setCreateUser(ShiroKit.getUser().getId());
//            userTopupCard.setCreateTime(new Date());
//            userTopupCard.setUpdateTime(new Date());
            userTopupCardService.save(userTopupCard);
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
    @RequiresPermissions("upms/userTopupCard/update")
    public ResultMap update(@Valid @RequestBody UserTopupCard userTopupCard) {
        try {
            //userTopupCard.setUpdateTime(new Date());
            userTopupCardService.updateById(userTopupCard);
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
    @RequiresPermissions("upms/userTopupCard/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            userTopupCardService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
