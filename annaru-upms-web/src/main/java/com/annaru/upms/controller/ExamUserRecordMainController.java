package com.annaru.upms.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.annaru.common.util.sdk.utils.DateUtil;
import com.annaru.upms.entity.vo.ExamUserRecordMainVoZ;
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

import com.annaru.upms.entity.ExamUserRecordMain;
import com.annaru.upms.service.IExamUserRecordMainService;
import javax.validation.Valid;



/**
 * 数据登记主表
 *
 * @author zk
 * @date 2019-06-17 13:19:24
 */
@Api(tags = {"数据登记主表管理"}, description = "数据登记主表管理")
@RestController
@RequestMapping("upms/examUserRecordMain")
public class ExamUserRecordMainController extends BaseController {
    @Reference
    private IExamUserRecordMainService examUserRecordMainService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/examUserRecordMain/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = examUserRecordMainService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 企业健康评估首页
     * @author zk
     * @date 2019-06-21
     */
    @ApiOperation(value = "企业健康评估首页", notes = "企业健康评估首页")
    @GetMapping("/selectMainDetailByUserId")
    @RequiresPermissions("upms/examUserRecordMain/selectMainDetailByUserId")
    public ResultMap selectMainDetailByUserId(@RequestParam("userId") String userId){
        try {
            List<ExamUserRecordMainVoZ> examUserRecordMainVoZ = examUserRecordMainService.selectMainDetailByUserId(userId);
            List<ExamUserRecordMainVoZ> examUserRecordMainVoZN = null;
            if (examUserRecordMainVoZ != null && examUserRecordMainVoZ.size() > 0){

                ExamUserRecordMainVoZ recordMain[] = new ExamUserRecordMainVoZ[examUserRecordMainVoZ.size() / 2];
                examUserRecordMainVoZN = new ArrayList<>();

                Collections.sort(examUserRecordMainVoZ);
                Pattern pattern = Pattern.compile("^[0-9]*$");
                for (int i = 0 ; i < examUserRecordMainVoZ.size() ; i++){

                    ExamUserRecordMainVoZ userRecordMainVoZ1 = examUserRecordMainVoZ.get(i * 2);
                    ExamUserRecordMainVoZ userRecordMainVoZ2 = examUserRecordMainVoZ.get(i * 2 + 1);
                    // 先判断答案不是数字类型的
                    Matcher matcher = pattern.matcher(userRecordMainVoZ1.getAnswerDetail());
                    int index = Integer.parseInt(userRecordMainVoZ1.getQuestionId().substring(1)) - 1;
                    if (!matcher.matches()){
                        recordMain[index] = userRecordMainVoZ1;
                    }else {
                        if (Double.parseDouble(userRecordMainVoZ1.getAnswerDetail()) > Double.parseDouble(userRecordMainVoZ2.getAnswerDetail())){
                            userRecordMainVoZ1.setArrows(1);
                            recordMain[index] = userRecordMainVoZ1;
                        }else if (Double.parseDouble(userRecordMainVoZ1.getAnswerDetail()) == Double.parseDouble(userRecordMainVoZ2.getAnswerDetail())){
                            userRecordMainVoZ1.setArrows(3);
                            recordMain[index] = userRecordMainVoZ1;
                        }else {
                            userRecordMainVoZ1.setArrows(2);
                            recordMain[index] = userRecordMainVoZ1;
                        }
                    }
                    if (i == examUserRecordMainVoZ.size() / 2 - 1){
                        break;
                    }
                }
                Collections.addAll(examUserRecordMainVoZN, recordMain);
            }
            return ResultMap.ok().put("data",examUserRecordMainVoZN);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{sysId}")
    @RequiresPermissions("upms/examUserRecordMain/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            ExamUserRecordMain examUserRecordMain = examUserRecordMainService.getById(sysId);
            return ResultMap.ok().put("examUserRecordMain",examUserRecordMain);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/examUserRecordMain/save")
    public ResultMap save(@Valid @RequestBody ExamUserRecordMain examUserRecordMain) {
        try {

            examUserRecordMainService.save(examUserRecordMain);
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
    @RequiresPermissions("upms/examUserRecordMain/update")
    public ResultMap update(@Valid @RequestBody ExamUserRecordMain examUserRecordMain) {
        try {

            examUserRecordMainService.updateById(examUserRecordMain);
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
    @RequiresPermissions("upms/examUserRecordMain/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            examUserRecordMainService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

}
