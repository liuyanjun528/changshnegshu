package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.service.IUserBasicService;
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
 * 用户基础信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"用户基础信息管理"}, description = "用户基础信息管理")
@RestController
@RequestMapping("upms/userBasic")
public class UserBasicController extends BaseController {
    @Reference
    private IUserBasicService userBasicService;

    /**
     * 修改旧密码
     */
    @ApiOperation(value = "修改旧密码")
    @PostMapping("/updatePassword")
    @RequiresPermissions("upms/userBasic/updatePassword")
    public String updatePassword(@RequestBody String password,String userId,String OldPwd) {

        UserBasic userBasic = userBasicService.selectByUid(userId);
        //如果输入的旧密码与旧密码相同 进行下一步
        if(OldPwd.equals(userBasic.getPassword())){
            //如果输入的新密码与旧密码不同 进行下一步
            if(!password.equals(userBasic.getPassword())){
                //修改密码
                userBasicService.updateOldPwd(password,userId);
                return "更新成功";
            }

            return "新密码与老密码相同,请换一个新密码";
        }else {
            return "输入的旧密码与旧密码不匹配,请想好再填";
        }

    }




    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/userBasic/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = userBasicService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/userBasic/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        UserBasic userBasic = userBasicService.getById(sysId);
        return ResultMap.ok().put("userBasic",userBasic);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/userBasic/save")
    public ResultMap save(@Valid @RequestBody UserBasic userBasic) {
        try {

//            userBasic.setCreateUser(ShiroKit.getUser().getId());
//            userBasic.setCreateTime(new Date());
//            userBasic.setUpdateTime(new Date());
            userBasicService.save(userBasic);
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
    @RequiresPermissions("upms/userBasic/update")
    public ResultMap update(@Valid @RequestBody UserBasic userBasic) {
        try {
//            userBasic.setUpdateTime(new Date());
            userBasicService.updateById(userBasic);
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
    @RequiresPermissions("upms/userBasic/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            userBasicService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
