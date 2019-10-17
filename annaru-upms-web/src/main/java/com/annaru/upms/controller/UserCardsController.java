package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.entity.vo.UserCardInfoVo;
import com.annaru.upms.entity.vo.UserCardVo;
import com.annaru.upms.service.IUserBasicService;
import com.annaru.upms.service.IUserCardsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


/**
 * 用户绑卡信息
 * @author wh
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"用户绑卡信息管理"}, description = "用户绑卡信息管理")
@RestController
@RequestMapping("upms/userCards")
public class UserCardsController extends BaseController {
    @Reference
    private IUserCardsService userCardsService;

    @Reference
    private IUserBasicService userBasicService;


    /**
     * 查询企业门诊绿通预约人信息
     */
    @ApiOperation(value = "查询企业家庭医生预约人信息")
    @GetMapping("/getGreenPassUserInfo")
    //@RequiresPermissions("upms/userCards/getGreenPassUserInfo")
    public ResultMap getGreenPassUserInfo(String userId,String refNo) {
        try {
            List<UserCardInfoVo> userCardInfoVo = userCardsService.getGreenPassUserInfo(userId,refNo);
            return ResultMap.ok().put("data", userCardInfoVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/userCards/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                          @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                          @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = userCardsService.getDataPage(params);
        return ResultMap.ok().put("data",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/userCards/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        UserCards userCards = userCardsService.getById(sysId);
        return ResultMap.ok().put("data",userCards);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/userCards/save")
    public ResultMap save(@Valid @RequestBody UserCards userCards) {
        try {
            userCards.setCreationTime(new Date());
            userCardsService.save(userCards);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 通过用户编号修改个人信息和医保卡号 wh
     */
    @ApiOperation(value = "修改个人信息和添加医保卡号")
    @PostMapping("/update")
    public ResultMap update(@RequestBody UserCardVo userCards) {

        int i = userBasicService.updateCardAndBasics(userCards);
        if (i>0){
            //如果 usercard表中 userID已存在 返回 卡号已存在
            int j = userCardsService.selectCardNo(userCards.getUserId());
            if(j>0){
                return ResultMap.error("该用户的医保卡号已存在！");
            }
            UserCards uc=new UserCards();
            uc.setCardNo(userCards.getCardNo());
            uc.setUserId(userCards.getUserId());
            userCardsService.save(uc);
                return ResultMap.ok("修改成功");
            }
            return ResultMap.error("运行异常，请联系管理员");

    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    @RequiresPermissions("upms/userCards/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            userCardsService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


}
