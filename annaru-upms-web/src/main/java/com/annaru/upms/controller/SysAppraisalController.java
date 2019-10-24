package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.SysAppraisal;
import com.annaru.upms.service.ISysAppraisalService;
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
 * 家庭医生评分
 *
 * @author xck
 * @date 2019-05-22 11:33:58
 */
@Api(tags = {"家庭医生评分管理"}, description = "家庭医生评分管理")
@RestController
@RequestMapping("upms/sysAppraisal")
public class SysAppraisalController extends BaseController {
    @Reference
    private ISysAppraisalService sysAppraisalService;


    /**
     * 信息
     */
    @ApiOperation(value = "查询评价星数", notes = "查看评价星数")
    @GetMapping("/getStart/{userId}")
    @RequiresPermissions("upms/sysAppraisal/getStart")
    public ResultMap getStart(@PathVariable("userId") String userId){
        List<SysAppraisal> sysAppraisals = sysAppraisalService.selectStart(userId);
        return ResultMap.ok().put("data",sysAppraisals);
    }



    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/sysAppraisal/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = sysAppraisalService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/sysAppraisal/save")
    public ResultMap save(@Valid @RequestBody SysAppraisal sysAppraisal) {
        try {
            SysAppraisal sa = sysAppraisalService.selectSysAppraisalInfoByUserId(sysAppraisal.getUserId());
            if(sa.getUserId()!=null&&sa.getReferenceNo()!=null&&sa.getCates()==1){// 1医生
                return ResultMap.error("该用户以对此医生做过评价，不允许再添加");
            }if(sa.getUserId()!=null&&sa.getReferenceNo()!=null&&sa.getCates()==2){ //2护士
                return ResultMap.error("该用户以对此护士做过评价，不允许再添加");
            }else {
                sysAppraisalService.save(sysAppraisal);
                return ResultMap.ok("添加成功");
            }
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
    @RequiresPermissions("upms/sysAppraisal/update")
    public ResultMap update(@Valid @RequestBody SysAppraisal sysAppraisal) {
        try {
            sysAppraisalService.updateById(sysAppraisal);
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
    @RequiresPermissions("upms/sysAppraisal/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            sysAppraisalService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
