package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.ExamMaster;
import com.annaru.upms.service.IExamMasterService;
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
 * 体检项目主表
 *
 * @author zk
 * @date 2019-05-09 11:14:30
 */
@Api(tags = {"体检项目主表管理"}, description = "体检项目主表管理")
@RestController
@RequestMapping("upms/examMaster")
public class ExamMasterController extends BaseController {
    @Reference
    private IExamMasterService examMasterService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examMaster/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = examMasterService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }

    /**
     * 查询所有体检项目主表
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/infoList")
    @RequiresPermissions("upms/examMaster/infoList")
    public ResultMap infoList(){
        List<ExamMaster> examMaster = examMasterService.list();
        return ResultMap.ok().put("data",examMaster);
    }

    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/examMaster/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        ExamMaster examMaster = examMasterService.getById(sysId);
        return ResultMap.ok().put("data",examMaster);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/examMaster/save")
    public ResultMap save(@Valid @RequestBody ExamMaster examMaster) {
        try {

//            examMaster.setCreateUser(ShiroKit.getUser().getId());
//            examMaster.setCreateTime(new Date());
//            examMaster.setUpdateTime(new Date());
            examMasterService.save(examMaster);
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
    @RequiresPermissions("upms/examMaster/update")
    public ResultMap update(@Valid @RequestBody ExamMaster examMaster) {
        try {
//            examMaster.setUpdateTime(new Date());
            examMasterService.updateById(examMaster);
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
    @RequiresPermissions("upms/examMaster/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examMasterService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
