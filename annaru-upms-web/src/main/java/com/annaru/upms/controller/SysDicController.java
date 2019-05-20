package com.annaru.upms.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.ResultMap;
import com.annaru.common.result.SelectNode;
import com.annaru.common.result.TreeNode;
import com.annaru.upms.entity.SysDic;
import com.annaru.upms.service.ISysDicService;
import com.annaru.upms.shiro.ShiroKit;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * @author TuMinglong
 * @description 数据字典类 前端控制器
 * @date 2018年3月6日 上午10:02:48
 */
@Api(tags = "数据字典管理", description = "数据字典管理")
@RestController
@RequestMapping("/sys/dic")
public class SysDicController extends BaseController {

    @Reference
    private ISysDicService sysDicService;


    /**
     * 数据字典树表
     *
     * @return
     */
    @ApiOperation(value = "数据字典树表")
    @GetMapping("/list")
    public Object treeGrid(@RequestParam(required = false) String dicName,
                           @RequestParam(required = false) String dicCode) {
        Map<String, Object> par = new HashMap<>();
        if (StringUtils.isNotBlank(dicName)) {
            par.put("varName", StringUtils.deleteWhitespace(dicName));
        }
        if (StringUtils.isNotBlank(dicCode)) {
            par.put("varCode", StringUtils.deleteWhitespace(dicCode));
        }
        return sysDicService.selectTreeGrid(par);
    }

    /**
     * 选择字典（添加、修改）
     *
     * @return
     */
    @ApiOperation(value = "选择字典（添加、修改）")
    @GetMapping("/select/{pid}")
    public ResultMap select(@PathVariable("pid") String pid) {
        Map<String, Object> par = new HashMap<>();
        if (StringUtils.isNotBlank(pid)) {
            par.put("parentId", pid);
        }
        List<TreeNode> tree = sysDicService.selectTree(par);
        tree.add(TreeNode.createParent());
        return ResultMap.ok().put("dicList", tree);
    }

    @ApiOperation(value = "查看详细")
    @GetMapping("/info/{dicId}")
    public ResultMap info(@PathVariable("dicId") String dicId) {
        SysDic sysDic = sysDicService.getById(dicId);
        SysDic sysDic2 = sysDicService.getById(sysDic.getParentId());
        if (sysDic2 != null) {
            sysDic.setParentName(sysDic.getVarName());
        } else {
            sysDic.setParentName("顶级");
        }
        return ResultMap.ok().put("dic", sysDic);
    }

    /**
     * 添加
     *
     * @param
     * @return
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Object save(@Valid @RequestBody SysDic sysDic) {
        try {
            sysDic.setCreateTime(new Date());
            sysDic.setCreateUser(ShiroKit.getUser().getLoginName());
            boolean b = sysDicService.save(sysDic);
            if (b) {
                return ResultMap.ok("添加成功！");
            } else {
                return ResultMap.ok("添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResultMap.error("添加失败，请联系管理员");
        }

    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Object update(@Valid @RequestBody SysDic sysDic) {
        try {
            sysDic.setUpdateTime(new Date());
            sysDic.setUpdateUser(ShiroKit.getUser().getLoginName());
            boolean b = sysDicService.updateById(sysDic);
            if (b) {
                return ResultMap.ok("修改成功！");
            } else {
                return ResultMap.error("修改失败！");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("编辑失败，请联系管理员");
        }
    }

    /**
     * 删除
     *
     * @param dicId
     * @return
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete/{dicId}")
    public ResultMap delete(@PathVariable("dicId") String dicId) {
        try {
            sysDicService.removeById(dicId);
            QueryWrapper<SysDic> wrapper = new QueryWrapper<>();
            wrapper.eq("parent_id", dicId);
            sysDicService.remove(wrapper);
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResultMap.error("批量删除失败，请联系管理员");
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/delete")
    public ResultMap deleteBatchIds(@RequestParam String[] ids) {
        try {
            List<String> idList = new ArrayList<String>();
            Collections.addAll(idList, ids);
            if (idList != null && !idList.isEmpty()) {
                sysDicService.removeByIds(Arrays.asList(ids));
                for (String id : idList) {
                    QueryWrapper<SysDic> wrapper = new QueryWrapper<>();
                    wrapper.eq("parent_id", id);
                    sysDicService.remove(wrapper);
                }
                return ResultMap.ok("删除成功！");
            } else {
                return ResultMap.error("删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return ResultMap.error("批量删除失败，请联系管理员");
        }
    }

    /**
     * 获取数据字典select树
     *
     * @return
     */
    @ApiOperation(value = "获取数据字典select树")
    @GetMapping("/selectNode/{pid}")
    public Object selectTree(@PathVariable("parentId") String parentId) {
        List<SelectNode> tree = new ArrayList<>();
        Map<String, Object> par = new HashMap<>();
        par.put("parentId", parentId);
        List<Map<String, Object>> list = sysDicService.selectTreeByParentId(par);
        if (!list.isEmpty()) {
            for (Map<String, Object> map : list) {
                SelectNode selectNode = new SelectNode();
                selectNode.setLabel(map.get("varName").toString());
                selectNode.setValue(map.get("id").toString());
                tree.add(selectNode);
            }
        }
        return ResultMap.ok().put("list", tree);
    }
}
