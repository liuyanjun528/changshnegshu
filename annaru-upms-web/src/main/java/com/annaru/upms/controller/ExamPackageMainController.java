package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamPackageMain;
import com.annaru.upms.service.IExamPackageMainService;
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
 * 套餐
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"套餐管理"}, description = "套餐管理")
@RestController
@RequestMapping("upms/examPackageMain")
public class ExamPackageMainController extends BaseController {
    @Reference
    private IExamPackageMainService examPackageMainService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examPackageMain/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = examPackageMainService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/examPackageMain/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        ExamPackageMain examPackageMain = examPackageMainService.getById(sysId);
        return ResultMap.ok().put("examPackageMain",examPackageMain);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/examPackageMain/save")
    public ResultMap save(@Valid @RequestBody ExamPackageMain examPackageMain) {
        try {

//            examPackageMain.setCreateUser(ShiroKit.getUser().getId());
//            examPackageMain.setCreateTime(new Date());
//            examPackageMain.setUpdateTime(new Date());
            examPackageMainService.save(examPackageMain);
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
    @RequiresPermissions("upms/examPackageMain/update")
    public ResultMap update(@Valid @RequestBody ExamPackageMain examPackageMain) {
        try {
//            examPackageMain.setUpdateTime(new Date());
            examPackageMainService.updateById(examPackageMain);
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
    @RequiresPermissions("upms/examPackageMain/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examPackageMainService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
