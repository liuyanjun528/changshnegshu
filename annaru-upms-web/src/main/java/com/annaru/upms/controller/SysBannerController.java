package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysBanner;
import com.annaru.upms.service.ISysBannerService;
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
 * 首页Banner
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"首页Banner管理"}, description = "首页Banner管理")
@RestController
@RequestMapping("upms/sysBanner")
public class SysBannerController extends BaseController {
    @Reference
    private ISysBannerService sysBannerService;

    /*** 方法描述:查询所有Banner
    * @params: []
    * @return: com.annaru.common.result.ResultMap
    * @Author: jyehui
    * @Date: 2019/7/1 12:12
    */
    @ApiOperation(value = "查询所有Banner")
    @GetMapping("/listAll")
    public ResultMap listAll(){
        List<SysBanner> sysBanners = sysBannerService.selectAll();

        return ResultMap.ok().put("data",sysBanners);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysBanner/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysBannerService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/sysBanner/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        SysBanner sysBanner = sysBannerService.getById(sysId);
        return ResultMap.ok().put("data",sysBanner);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysBanner/save")
    public ResultMap save(@Valid @RequestBody SysBanner sysBanner) {
        try {

//            sysBanner.setCreateUser(ShiroKit.getUser().getId());
//            sysBanner.setCreateTime(new Date());
//            sysBanner.setUpdateTime(new Date());
            sysBannerService.save(sysBanner);
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
    @RequiresPermissions("upms/sysBanner/update")
    public ResultMap update(@Valid @RequestBody SysBanner sysBanner) {
        try {
//            sysBanner.setUpdateTime(new Date());
            sysBannerService.updateById(sysBanner);
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
    @RequiresPermissions("upms/sysBanner/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysBannerService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
