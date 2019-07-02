package com.annaru.upms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.common.result.ResultMap;
import com.annaru.upms.controllerutil.AppConst;
import com.annaru.upms.entity.medical.vo.*;
import com.annaru.upms.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 健康档案
 * @author lft
 * @date 2019-05-09 11:14:28
 */
@Api(tags = {"健康档案管理"}, description = "健康档案管理")
@RestController
@RequestMapping("upms/medical")
public class TbMedicalController extends BaseController {

    @Reference
    private ITbYlMzMedicalRecordService iTbYlMzMedicalRecordService; //门诊就诊记录

    @Reference
    private ITbYlZyMedicalRecordService iTbYlZyMedicalRecordService; //住院就诊记录

    @Reference
    private ITbLisReportService iTbLisReportService; //实验室检验报告

    @Reference
    private ITbLisIndicatorsService iTbLisIndicatorsService; //检验结果指标

    @Reference
    private ITbRisReportService iTbRisReportService; //影像检查报告表—放射类格式

    @Reference
    private ITbRisReport2Service iTbRisReport2Service;  //影像检查报告表—通用格式

    @Reference
    private ITbCisPrescriptionDetailService iTbCisPrescriptionDetailService; //门诊处方明细

   /* @Reference
    private IUserBasicService iUserBasicService; //用户*/

    /**
     *  根据卡号查询健康档案首页信息
     * @param kh 卡号
     */
    @ApiOperation(value = "查询首页信息")
    @GetMapping("/getIndex")
    @RequiresPermissions("upms/medical/getIndex")
    public ResultMap getIndex(@ApiParam(value = "身份证号", required = true) @RequestParam String kh) {
        try {
            Map<String, Object> map = new HashMap<>();
            //根据卡号查询近一年的门诊记录
            List<TbYlMzMedicalRecordListVo> listYlMzMedicalRecord = iTbYlMzMedicalRecordService.getJzjlCsByKh(kh);
            if (listYlMzMedicalRecord.size() > 0 ) {
                map.put("mzjl",listYlMzMedicalRecord.size());
            }
            //根据卡号查询近三年门诊次数最多医院
            TbYlMzMedicalRecordListVo tbYlMzMedicalRecordListVo = iTbYlMzMedicalRecordService.getHospitalNameByKh(kh);
            if(tbYlMzMedicalRecordListVo != null){
                map.put("hospitalName", tbYlMzMedicalRecordListVo.getHospitalName());
            }
            //根据卡号查询近一年的住院记录
            List<TbYlZyMedicalRecordListVo> listYlZyMedicalRecord = iTbYlZyMedicalRecordService.getJyjlCs(kh);
            if (listYlZyMedicalRecord.size() > 0 ) {
                map.put("zyjl",listYlZyMedicalRecord.size());
            }
            return ResultMap.ok().put("data",map);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }


    /**
     *  根据卡号查询门诊记录列表
     * @param kh 卡号
     */
    @ApiOperation(value = "门诊记录列表")
    @GetMapping("/getJzjlPage")
    @RequiresPermissions("upms/medical/getJzjlPage")
    public ResultMap getJzjlPage(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                             @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                             @ApiParam(value = "身份证号", required = true) @RequestParam String kh,
                             @ApiParam(value = "开始日期") @RequestParam(required = false) String dateFrom,
                             @ApiParam(value = "结束日期") @RequestParam(required = false) String dateTo) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("kh", kh);
            params.put("dateFrom", dateFrom);
            params.put("dateTo", dateTo);
            PageUtils<Map<String, Object>> pageList = iTbYlMzMedicalRecordService.getJzjlPage(params);
            return ResultMap.ok().put("data",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 门诊记录详情
     * @param csid 门诊记录id
     * @return
     */
    @ApiOperation(value = "门诊记录详情")
    @GetMapping("/getMzjlDetail")
    @RequiresPermissions("upms/medical/getMzjlDetail")
    public ResultMap getMzjlDetail(@ApiParam(value = "门诊记录id", required = true) @RequestParam String csid){
        Map<String, Object> map = new HashMap<>();
        // 就诊记录
        TbYlMzMedicalRecordDetailVo jzjl = iTbYlMzMedicalRecordService.getJzjlById(csid);
        map.put("jzjl", jzjl);

        if (jzjl!=null) {
            // 用药记录
            map.put("yyjl", iTbCisPrescriptionDetailService.getYp(jzjl.getJzlsh()));

            // 影像检查报告
            List<TbRisReportListVo> tbRisReports = iTbRisReportService.getYxbgByJzlsh(jzjl.getJzlsh());
            List<TbRisReport2ListVo> tbRisReports2 = iTbRisReport2Service.getYxbgByJzlsh(jzjl.getJzlsh());
            for (TbRisReport2ListVo r2 : tbRisReports2) {
                TbRisReportListVo r = new TbRisReportListVo();
                r.setJysj(r2.getJcsj());
                r.setYxzd(r2.getBt1nr());
                r.setHospitalName(r2.getHospitalName());
                r.setJcmc(r2.getJcmc());
                tbRisReports.add(r);
            }
            map.put("yxbg", tbRisReports);

            // 检验报告
            List<TbLisReportDetailVo> tbLisReports = iTbLisReportService.getJybgByJzlsh(jzjl.getJzlsh());
            map.put("jybg", tbLisReports);
            return ResultMap.ok().put("data",map);
        }else {
            return ResultMap.error("就诊记录不存在！");
        }

    }

    /**
     * 根据卡号查询住院就诊记录
     * @param kh 卡号
     */
    @ApiOperation(value = "住院记录列表")
    @GetMapping("/getJzjzjlList")
    @RequiresPermissions("upms/medical/getJzjzjlList")
    public ResultMap getJzjzjlList(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                                   @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                                   @ApiParam(value = "身份证号", required = true) @RequestParam String kh,
                                   @ApiParam(value = "开始日期") @RequestParam(required = false) String dateFrom,
                                   @ApiParam(value = "结束日期") @RequestParam(required = false) String dateTo) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("kh", kh);
            params.put("dateFrom", dateFrom);
            params.put("dateTo", dateTo);
            PageUtils<Map<String, Object>> pageList = iTbYlZyMedicalRecordService.getJyjlPage(params);
            return ResultMap.ok().put("data",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 根据卡号查询检验报告列表
     * @param kh
     */
    @ApiOperation(value = "检验报告列表")
    @GetMapping("/getJybgList")
    @RequiresPermissions("upms/medical/getJybgList")
    public ResultMap getJybgList(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                                 @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                                 @ApiParam(value = "身份证号", required = true) @RequestParam String kh,
                                 @ApiParam(value = "开始日期") @RequestParam(required = false) String dateFrom,
                                 @ApiParam(value = "结束日期") @RequestParam(required = false) String dateTo) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("kh", kh);
            params.put("dateFrom", dateFrom);
            params.put("dateTo", dateTo);
            PageUtils<Map<String, Object>> pageList = iTbLisReportService.getJybgPage(params);
            return ResultMap.ok().put("data",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 查询检验报告详情
     * @param csid
     * @return
     */
    @ApiOperation(value = "检验报告详情")
    @GetMapping("/getJybgDetail")
    @RequiresPermissions("upms/medical/getJybgDetail")
    public ResultMap getJybgDetail(@ApiParam(value = "就诊流水号", required = true) @RequestParam String csid,
                                   @ApiParam(value = "报告单号", required = true) @RequestParam String bgdh){
        Map<String, Object> map = new HashMap<>();
        // 就诊记录
        TbYlMzMedicalRecordDetailVo jzjl = iTbYlMzMedicalRecordService.getJzjlById(csid);
        map.put("jzjl", jzjl);
        if (jzjl!=null) {
            // 检验报告
            List<TbLisIndicatorsListVo> tbLisReports = iTbLisIndicatorsService.getJybg(bgdh);
            map.put("jybg", tbLisReports);
            return ResultMap.ok().put("data",map);
        }else {
            return ResultMap.error("报告不存在！");
        }

    }

    /**
     * 根据卡号查询影像检查报告列表
     * @param kh 卡号
     */
    @ApiOperation(value = "影像检查报告列表")
    @GetMapping("/getYxbgList")
    @RequiresPermissions("upms/medical/getYxbgList")
    public ResultMap getYxbgList(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                                 @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                                 @ApiParam(value = "身份证号", required = true) @RequestParam String kh,
                                 @ApiParam(value = "开始日期") @RequestParam(required = false) String dateFrom,
                                 @ApiParam(value = "结束日期") @RequestParam(required = false) String dateTo) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("kh", kh);
            params.put("dateFrom", dateFrom);
            params.put("dateTo", dateTo);
            PageUtils<Map<String, Object>> pageList = iTbRisReportService.getYxbgPage(params);
            return ResultMap.ok().put("data",pageList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 查询用药记录列表
     * @param kh
     * @return
     */
    @ApiOperation(value = "用药记录列表")
    @GetMapping("/getYyjl")
    @RequiresPermissions("upms/medical/getYyjl")
    public ResultMap getYyjl(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                             @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                             @ApiParam(value = "身份证号", required = true) @RequestParam String kh,
                             @ApiParam(value = "开始日期") @RequestParam(required = false) String dateFrom,
                             @ApiParam(value = "结束日期") @RequestParam(required = false) String dateTo) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("kh", kh);
            params.put("dateFrom", dateFrom);
            params.put("dateTo", dateTo);
            PageUtils<Map<String, Object>> map_list = iTbCisPrescriptionDetailService.getYyjlPage(params);
            List<TbCisPrescriptionDetailListVo> yyjl_list = map_list.getList();
            for (TbCisPrescriptionDetailListVo listVo: yyjl_list) {
                List<TbCisPrescriptionDetailVo> yp_list = iTbCisPrescriptionDetailService.getYp(listVo.getJzlsh());
                for (TbCisPrescriptionDetailVo detailVo : yp_list) {
                    if (StringUtils.isNotBlank(detailVo.getSypcdm())) {
                        String sypcdm = detailVo.getSypcdm().toLowerCase();
                        detailVo.setSypc(AppConst.sypc_dm.get(sypcdm));
                    }else {
                        detailVo.setJl(null);
                        detailVo.setDw(null);
                    }
                    detailVo.setYf(AppConst.yf_dm.get(detailVo.getYf()));
                    listVo.setTbCisPrescriptionDetailVo(detailVo);
                }
            }
            if(yyjl_list.size()>0){
                map_list.setList(yyjl_list);
                return ResultMap.ok().put("data",map_list);
            }else {
                return ResultMap.error("没有用药记录数据！");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 查询用药记录详情
     * @param jzlsh
     * @return
     */
    @ApiOperation(value = "用药记录详情")
    @GetMapping("/getYyjlDetail")
    @RequiresPermissions("upms/medical/getYyjlDetail")
    public ResultMap getYyjlDetail(@ApiParam(value = "就诊流水号", required = true) @RequestParam String jzlsh){
        try {
            Map<String, Object> map = new HashMap<>();
            if (StringUtils.isBlank(jzlsh)) {
                return ResultMap.error("就诊流水号为空！");
            }
            TbCisPrescriptionDetailListVo yyjl_detail = iTbCisPrescriptionDetailService.getYyjlByJzlsh(jzlsh);
            if (yyjl_detail==null) {
                return ResultMap.error("未查到该用药记录详情！");
            }
            List<TbCisPrescriptionDetailVo> yp_list = iTbCisPrescriptionDetailService.getYp(yyjl_detail.getJzlsh());
            for (TbCisPrescriptionDetailVo i : yp_list) {
                if (StringUtils.isNotBlank(i.getSypcdm())) {
                    String sypcdm = i.getSypcdm().toLowerCase();
                    i.setSypc(AppConst.sypc_dm.get(sypcdm));
                }else {
                    i.setJl(null);
                    i.setDw(null);
                }
                i.setYf(AppConst.yf_dm.get(i.getYf()));
            }
            map.put("yyjl",yyjl_detail);
            map.put("yp", yp_list);
            return ResultMap.ok().put("data",map);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }


}
