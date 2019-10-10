package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.entity.MallArticalFansLog;
import com.annaru.upms.entity.vo.MallArticalFansLogExtends;
import com.annaru.upms.service.IMallArticalFansLogService;
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

import com.annaru.upms.entity.MallArticalList;
import com.annaru.upms.service.IMallArticalListService;
import javax.validation.Valid;



/**
 * 商城文章阅读
 *
 * @author zk
 * @date 2019-10-10 13:11:23
 */
@Api(tags = {"商城文章阅读管理"}, description = "商城文章阅读管理")
@RestController
@RequestMapping("upms/mallArticalList")
public class MallArticalListController extends BaseController {

    @Reference
    private IMallArticalListService mallArticalListService;
    @Reference
    private IMallArticalFansLogService mallArticalFansLogService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/mallArticalList/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = mallArticalListService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /***
     * 查询商城文章阅读
     * @Author: zxk
     * @Date: 2019/10/10
     */
    @ApiOperation(value = "查询所有的商城文章")
    @GetMapping("/listAll")
    public ResultMap listAll(){
        // 若sysId为空 则返回所有的
        List<MallArticalList> mallArticalList = mallArticalListService.selectAll();
        return ResultMap.ok().put("data",mallArticalList);
    }

    /***
     * 根据条件查询商城文章阅读详情
     * @Author: zxk
     * @Date: 2019/10/10
     */
    @ApiOperation(value = "根据条件查询所有的商城文章详情")
    @GetMapping("/mallArticalDetail")
    public ResultMap mallArticalDetail(@ApiParam(value = "系统编号")@RequestParam(required = true)Integer sysId,
                                       @ApiParam(value = "用户编号")@RequestParam(required = true)String userId){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId", sysId);
        params.put("userId", userId);
        return ResultMap.ok().put("data",mallArticalListService.mallArticalDetail(params));
    }

    /**
     * 点赞/取消点赞
     * @author zk
     * @date 2019/10/10
     */
    @ApiOperation(value = "点赞/取消点赞")
    @PostMapping("/praiseOrCancel")
    @RequiresPermissions("upms/mallArticalList/praiseOrCancel")
    public ResultMap praiseOrCancel(@ApiParam(value = "系统编号")@RequestParam(required = true)Integer sysId,
                                    @ApiParam(value = "用户编号")@RequestParam(required = true)String userId) {
        try {
            MallArticalFansLog mallArticalFansLog = new MallArticalFansLog();
            mallArticalFansLog.setArticalSysid(sysId);
            mallArticalFansLog.setUserId(userId);
            MallArticalFansLog mallArticalFansLog1 = mallArticalFansLogService.getOneByMallArticalFansLog(mallArticalFansLog);
            if (mallArticalFansLog1 != null){
                if (mallArticalFansLogService.cancelPraise(mallArticalFansLog)){
                    return ResultMap.ok("取消点赞成功");
                }
            }
            mallArticalFansLog.setCreationTime(new Date());
            if (mallArticalFansLogService.save(mallArticalFansLog)){
                return ResultMap.ok("点赞成功");
            }
            return ResultMap.error("操作失败");
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
    @RequiresPermissions("upms/mallArticalList/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            MallArticalList mallArticalList = mallArticalListService.getById(sysId);
            return ResultMap.ok().put("mallArticalList",mallArticalList);
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
    @RequiresPermissions("upms/mallArticalList/save")
    public ResultMap save(@Valid @RequestBody MallArticalList mallArticalList) {
        try {

//            mallArticalList.setCreateUser(ShiroKit.getUser().getId());
//            mallArticalList.setCreateTime(new Date());
//            mallArticalList.setUpdateTime(new Date());
            mallArticalListService.save(mallArticalList);
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
    @RequiresPermissions("upms/mallArticalList/update")
    public ResultMap update(@Valid @RequestBody MallArticalList mallArticalList) {
        try {
//            mallArticalList.setUpdateTime(new Date());
            mallArticalListService.updateById(mallArticalList);
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
    @RequiresPermissions("upms/mallArticalList/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            mallArticalListService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
