package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.entity.vo.MallExamPackageRecommendExtends;
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

import com.annaru.upms.entity.MallExamPackageRecommend;
import com.annaru.upms.service.IMallExamPackageRecommendService;
import javax.validation.Valid;



/**
 * 商城推荐产品
 *
 * @author zk
 * @date 2019-10-10 13:11:23
 */
@Api(tags = {"商城推荐产品管理"}, description = "商城推荐产品管理")
@RestController
@RequestMapping("upms/mallExamPackageRecommend")
public class MallExamPackageRecommendController extends BaseController {
    @Reference
    private IMallExamPackageRecommendService mallExamPackageRecommendService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/mallExamPackageRecommend/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = mallExamPackageRecommendService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /***
     * 根据条件查询商城推荐产品
     * @Author: zxk
     * @Date: 2019/10/10
     */
    @ApiOperation(value = "根据条件查询商城推荐产品 / 查询所有的")
    @GetMapping("/listAll")
    public ResultMap listAll(){
        List<MallExamPackageRecommendExtends> mallExamPackageRecommendExtends = mallExamPackageRecommendService.selectAll();
        return ResultMap.ok().put("data",mallExamPackageRecommendExtends);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/mallExamPackageRecommend/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            MallExamPackageRecommend mallExamPackageRecommend = mallExamPackageRecommendService.getById(sysId);
            return ResultMap.ok().put("mallExamPackageRecommend",mallExamPackageRecommend);
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
    @RequiresPermissions("upms/mallExamPackageRecommend/save")
    public ResultMap save(@Valid @RequestBody MallExamPackageRecommend mallExamPackageRecommend) {
        try {

//            mallExamPackageRecommend.setCreateUser(ShiroKit.getUser().getId());
//            mallExamPackageRecommend.setCreateTime(new Date());
//            mallExamPackageRecommend.setUpdateTime(new Date());
            mallExamPackageRecommendService.save(mallExamPackageRecommend);
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
    @RequiresPermissions("upms/mallExamPackageRecommend/update")
    public ResultMap update(@Valid @RequestBody MallExamPackageRecommend mallExamPackageRecommend) {
        try {
//            mallExamPackageRecommend.setUpdateTime(new Date());
            mallExamPackageRecommendService.updateById(mallExamPackageRecommend);
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
    @RequiresPermissions("upms/mallExamPackageRecommend/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            mallExamPackageRecommendService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
