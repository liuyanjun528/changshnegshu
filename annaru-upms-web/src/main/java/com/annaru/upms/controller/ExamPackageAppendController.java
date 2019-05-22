package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamPackageAppend;
import com.annaru.upms.service.IExamPackageAppendService;
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
 * 套餐赠送服务
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Api(tags = {"套餐赠送服务管理"}, description = "套餐赠送服务管理")
@RestController
@RequestMapping("upms/examPackageAppend")
public class ExamPackageAppendController extends BaseController {
    @Reference
    private IExamPackageAppendService examPackageAppendService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examPackageAppend/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = examPackageAppendService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/examPackageAppend/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        ExamPackageAppend examPackageAppend = examPackageAppendService.getById(sysId);
        return ResultMap.ok().put("examPackageAppend",examPackageAppend);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/examPackageAppend/save")
    public ResultMap save(@Valid @RequestBody ExamPackageAppend examPackageAppend) {
        try {

//            examPackageAppend.setCreateUser(ShiroKit.getUser().getId());
//            examPackageAppend.setCreateTime(new Date());
//            examPackageAppend.setUpdateTime(new Date());
            examPackageAppendService.save(examPackageAppend);
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
    @RequiresPermissions("upms/examPackageAppend/update")
    public ResultMap update(@Valid @RequestBody ExamPackageAppend examPackageAppend) {
        try {
//            examPackageAppend.setUpdateTime(new Date());
            examPackageAppendService.updateById(examPackageAppend);
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
    @RequiresPermissions("upms/examPackageAppend/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examPackageAppendService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
