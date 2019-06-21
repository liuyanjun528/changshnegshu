package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.entity.medical.TbInterfaceAuthorization;
import com.annaru.upms.service.ITbInterfaceAuthorizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 用户授权信息
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"用户授权信息管理"}, description = "用户授权信息管理")
@RestController
@RequestMapping("upms/interfaceAuthorization")
public class TbInterfaceAuthorizationController extends BaseController {

    @Reference
    private ITbInterfaceAuthorizationService iTbInterfaceAuthorizationService;

    /**
     * 用户授权信息查询
     */
    @ApiOperation(value = "用户授权信息查询")
    @GetMapping("/selectByUserId")
    @RequiresPermissions("upms/interfaceAuthorization/selectByUserId")
    public ResultMap selectByUserId(String userId) {
        try {
            List<TbInterfaceAuthorization> authorization = iTbInterfaceAuthorizationService.selectByUserId(userId);
            return ResultMap.ok().put("data",authorization);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
