package com.annaru.upms.controller;

import java.util.*;

import com.annaru.upms.entity.vo.ExamPackageMainVo;
import com.annaru.upms.entity.vo.ExamPackageMainVoTcxqZ;
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

import com.annaru.upms.entity.ExamPackageMain;
import com.annaru.upms.service.IExamPackageMainService;
import javax.validation.Valid;



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
                       @ApiParam(value = "价格区间开始")@RequestParam(required = false)Double amountFrom,
                       @ApiParam(value = "价格区间结束")@RequestParam(required = false)Double amountTo,
                       @ApiParam(value = "年龄")@RequestParam(required = false)Integer label,
                       @ApiParam(value = "适用性别:(1:男/2:女/3:男女都适用)")@RequestParam(required = false)Integer suiteGender,
                       @ApiParam(value = "检查项目主表编号")@RequestParam(required = false)Integer examMasterI,
                       @ApiParam(value = "根据预约排序")@RequestParam(required = false)Integer sortCountPerson,
                       @ApiParam(value = "根据价格排序")@RequestParam(required = false)Integer amountSort){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("amountFrom", amountFrom);
        params.put("amountTo", amountTo);
        params.put("label", label);
        params.put("suiteGender", suiteGender);
        params.put("examMasterI", examMasterI);
        params.put("sort_count_person", sortCountPerson);
        params.put("amountSort", amountSort);
        PageUtils<Map<String, Object>> pageList = examPackageMainService.selectDataPageZ(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 套餐详情
     */
    @ApiOperation(value = "套餐详情", notes = "套餐详情")
    @GetMapping("/selectInfoBySysId/{sysId}")
    @RequiresPermissions("upms/examPackageMain/selectInfoBySysId")
    public ResultMap selectInfoBySysId(@PathVariable("sysId") Integer sysId){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId",sysId);
        ExamPackageMainVo examPackageMain = examPackageMainService.selectInfoBySysId(params);
        return ResultMap.ok().put("data",examPackageMain);
    }

    /**
     * 根据套餐编号查询套餐详情
     */
    @ApiOperation(value = "根据套餐编号查询套餐详情", notes = "根据套餐编号查询套餐详情")
    @GetMapping("/selectInfoBySysIdZ/{sysId}")
    @RequiresPermissions("upms/examPackageMain/selectInfoBySysIdZ")
    public ResultMap selectInfoBySysIdZ(@PathVariable("sysId") Integer sysId){
        Map<String, Object> params = new HashMap<>();
        params.put("sysId",sysId);
        ExamPackageMainVoTcxqZ examPackageMain = examPackageMainService.selectInfoBySysIdZ(params);
        return ResultMap.ok().put("data",examPackageMain);
    }

    /**
     * 查看全部套餐
     */
    @ApiOperation(value = "查看全部套餐名称", notes = "查看全部套餐名称")
    @GetMapping("/getAll")
    @RequiresPermissions("upms/examPackageMain/getAll")
    public ResultMap getAll(){
        List<ExamPackageMain> examPackageMains = examPackageMainService.selectAllExam();
        return ResultMap.ok().put("data",examPackageMains);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/examPackageMain/save")
    public ResultMap save(@Valid @RequestBody ExamPackageMain examPackageMain) {
        try {
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
