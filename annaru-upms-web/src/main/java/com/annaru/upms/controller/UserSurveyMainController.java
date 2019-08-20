package com.annaru.upms.controller;

import java.util.*;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.vo.UserSurveyMainVo;
import com.annaru.upms.entity.vo.UserSurveyVo;
import com.annaru.upms.service.IUserSurveyItemsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


import com.annaru.upms.entity.UserSurveyMain;
import com.annaru.upms.service.IUserSurveyMainService;
import javax.validation.Valid;



/**
 * 用户问券调查
 *
 * @author wh
 * @date 2019-05-21 15:55:50
 */
@Api(tags = {"用户问券调查管理"}, description = "用户问券调查管理")
@RestController
@RequestMapping("/userSurveyMain")
public class UserSurveyMainController extends BaseController {
    @Reference
    private IUserSurveyMainService userSurveyMainService;
    @Reference
    private IUserSurveyItemsService userSurveyItemsService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("/userSurveyMain/list")
    public ResultMap list(@ApiParam(value = "当前页", defaultValue="1")@RequestParam(required = false) long page,
                       @ApiParam(value = "每页数量", defaultValue = "10")@RequestParam(required = false) long limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = userSurveyMainService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看详情")
    @GetMapping("/info/{surveyId}")
    @RequiresPermissions("/userSurveyMain/info")
    public ResultMap info(@PathVariable("surveyId") Integer surveyId){
        UserSurveyMain userSurveyMain = userSurveyMainService.getById(surveyId);
        return ResultMap.ok().put("data",userSurveyMain);
    }

    /**
     * 问卷调查答案保存
     */
    @ApiOperation(value = "问卷调查答案保存")
    @PostMapping("/batchsave")
    @RequiresPermissions("/userSurveyMain/batchsave")
    public ResultMap batchsave(@Valid @RequestBody UserSurveyMainVo userSurvey) {
        try {
            UserSurveyMain userSurveyMain = new UserSurveyMain();
            userSurveyMain.setUserId(userSurvey.getUserId());
            int s = userSurveyMainService.saveOne(userSurveyMain);
            for(int i = 0;i<userSurvey.getSurveyItemsList().size();i++){
                userSurvey.getSurveyItemsList().get(i).setSurveyId(s);
            }
            userSurveyItemsService.saveBatch(userSurvey.getSurveyItemsList(),userSurvey.getSurveyItemsList().size());
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    @ApiOperation(value = "查询历史答题记录",notes = "历史问卷调查详情")
    @GetMapping("/message")
    @RequiresPermissions("/userSurveyMain/message")
    public ResultMap info(@RequestParam String userId,
                          @RequestParam String type){
        Map<String,Object> params = new HashMap<>();
        params.put("userId",userId);
        params.put("type",type);
        UserSurveyVo userSurveyMain = userSurveyMainService.getByUserId(params);
        return ResultMap.ok().put("data",userSurveyMain);
    }



    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("/userSurveyMain/save")
    public ResultMap save(@Valid @RequestBody UserSurveyMain userSurveyMain) {
        try {

            //userSurveyMain.setCreateUser(ShiroKit.getUser().getId())
            userSurveyMainService.save(userSurveyMain);
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
    @RequiresPermissions("/userSurveyMain/update")
    public ResultMap update(@Valid @RequestBody UserSurveyMain userSurveyMain) {
        try {
            userSurveyMainService.updateById(userSurveyMain);
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
    @RequiresPermissions("/userSurveyMain/delete")
    public ResultMap delete(@RequestBody Integer[]surveyIds) {
        try {
            userSurveyMainService.removeByIds(Arrays.asList(surveyIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
