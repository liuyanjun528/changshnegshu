package com.annaru.upms.controller;

import java.util.*;

import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.vo.OrderPaymentDetailVoSaveZ;
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

import com.annaru.upms.entity.OrderPaymentDetail;
import com.annaru.upms.service.IOrderPaymentDetailService;
import javax.validation.Valid;



/**
 * 分期还款表
 *
 * @author xck
 * @date 2019-06-13 11:27:39
 */
@Api(tags = {"分期还款表管理"}, description = "分期还款表管理")
@RestController
@RequestMapping("upms/orderPaymentDetail")
public class OrderPaymentDetailController extends BaseController {
    @Reference
    private IOrderPaymentDetailService orderPaymentDetailService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/orderPaymentDetail/list")
    public ResultMap list(@ApiParam(value = "当前页")@RequestParam(defaultValue="1") int page,
                       @ApiParam(value = "每页数量")@RequestParam(defaultValue = "10") int limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("page",page);
            params.put("limit", limit);
            params.put("key", key);
            PageUtils<Map<String, Object>> pageList = orderPaymentDetailService.getDataPage(params);
            return ResultMap.ok().put("page",pageList);
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
    @RequiresPermissions("upms/orderPaymentDetail/info")
    public ResultMap info(@PathVariable("sysId") Integer sysId){
        try {
            OrderPaymentDetail orderPaymentDetail = orderPaymentDetailService.getById(sysId);
            return ResultMap.ok().put("orderPaymentDetail",orderPaymentDetail);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 预计分期还款记录
     */
    @ApiOperation(value = "预计分期还款记录")
    @PostMapping("/installmentRepayment")
    @RequiresPermissions("upms/orderPaymentDetail/installmentRepayment")
    public ResultMap installmentRepayment(@RequestBody OrderPaymentDetailVoSaveZ orderPaymentDetailVoSaveZ) {
        try {

            OrderPaymentDetail orderPaymentDetailSet = new OrderPaymentDetail();
            orderPaymentDetailSet.setOrderNo(orderPaymentDetailVoSaveZ.getOrderNo());
            List<OrderPaymentDetail> orderPaymentDetails = orderPaymentDetailService.getEntityList(orderPaymentDetailSet);
            if (orderPaymentDetails != null && orderPaymentDetails.size() > 0){
                return ResultMap.error("该预计分期还款记录已存在！");
            }

            Date getNextPayMent = null;
            List<OrderPaymentDetail> orderPaymentDetailList = new ArrayList<>();
            OrderPaymentDetail orderPaymentDetail = null;
            // 根据期数得到每次还款的间隔月
            int intervalMonth = 12 / orderPaymentDetailVoSaveZ.getTotalPeriod();
            for (int i = 0 ; i < intervalMonth ; i++){
                orderPaymentDetail = new OrderPaymentDetail();
                orderPaymentDetail.setOrderNo(orderPaymentDetailVoSaveZ.getOrderNo()); // 订单编号
                if (getNextPayMent != null){
                    getNextPayMent = getNextPayMent(getNextPayMent, intervalMonth);
                }else {
                    getNextPayMent = getNextPayMent(DateUtil.stringToDate(orderPaymentDetailVoSaveZ.getStartDate(), DateUtil.DATE_PATTERN.YYYY_MM_DD_HH_MM_SS), intervalMonth);
                }
                orderPaymentDetail.setRepayDate(getNextPayMent); // 应付款日期
                orderPaymentDetail.setTotalAmount(orderPaymentDetailVoSaveZ.getTotalAmount()); // 订单总金额
                orderPaymentDetail.setCurrentyPeriod(i + 1); // 还款期数
                orderPaymentDetail.setTotalPeriod(orderPaymentDetailVoSaveZ.getTotalPeriod()); // 总分期数
                orderPaymentDetailList.add(orderPaymentDetail);
            }
            if (orderPaymentDetailService.saveBatch(orderPaymentDetailList)){
                return ResultMap.ok("添加成功");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
        return ResultMap.error("运行异常，请联系管理员");
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/orderPaymentDetail/save")
    public ResultMap save(@Valid @RequestBody OrderPaymentDetail orderPaymentDetail) {
        try {

            orderPaymentDetailService.save(orderPaymentDetail);
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
    @RequiresPermissions("upms/orderPaymentDetail/update")
    public ResultMap update(@Valid @RequestBody OrderPaymentDetail orderPaymentDetail) {
        try {
            orderPaymentDetailService.updateById(orderPaymentDetail);
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
    @RequiresPermissions("upms/orderPaymentDetail/delete")
    public ResultMap delete(@RequestBody Integer[]sysIds) {
        try {
            orderPaymentDetailService.removeByIds(Arrays.asList(sysIds));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 根据开始日期和间隔月得到下次的还款时间
     */
    public Date getNextPayMent(Date date, int intervalMonth){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, intervalMonth);
        return c.getTime();

    }

        /**
         * 根据开始日期和间隔月得到下次的还款时间
         */
//    public String getNextPayMent(String startDate, int intervalMonth){ // yyyy-MM-dd HH:mm:ss
//        int year = Integer.parseInt(startDate.substring(0 , 4)); // 年
//        int month = Integer.parseInt(startDate.substring(5 , 7)); // 月
//        int day = Integer.parseInt(startDate.substring(8 , 10)); // 日
//        int nextD = Integer.parseInt(startDate.substring(10));
//
//        int yearN = 0; // 年
//        int monthN = 0; // 月
//        int dayN = 0; // 日
//
//        StringBuffer sb = new StringBuffer("");
//        if ((month + intervalMonth) > 12){
//            sb.append(year + 1);
//            sb.append("-");
//            if ((month + intervalMonth - 12) < 10){
//                sb.append("0");
//            }
//            sb.append((month + intervalMonth) - 12);
//
//            yearN = year + 1;
//            monthN = (month + intervalMonth) - 12;
//        }else{
//            sb.append(year);
//            sb.append("-");
//            if (month < 10){
//                sb.append("0");
//            }
//            sb.append(month);
//            sb.append("-");
//            yearN = year;
//            monthN = month;
//        }
//        if (day > getDays(yearN, monthN)){
//            dayN = getDays(yearN, monthN);
//        }else if (day < getDays(yearN, monthN)){
//            dayN = day;
//        }
//        if (dayN < 10){
//            sb.append("0");
//        }
//        sb.append(dayN);
//        sb.append(nextD);
//
//        return sb.toString();
//    }

    /**
     * 计算当前月有多少天
     *
     * @return
     */
//    public int getDays(int year, int month) {
//        int days = 0;
//        if (month != 2) {
//            switch (month) {
//                case 1:
//                case 3:
//                case 5:
//                case 7:
//                case 8:
//                case 10:
//                case 12:
//                    days = 31;
//                    break;
//                case 4:
//                case 6:
//                case 9:
//                case 11:
//                    days = 30;
//            }
//        } else {
//            // 闰年
//            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
//                days = 29;
//            else
//                days = 28;
//        }
//        return days;
//    }

    public static void main(String[] arg){
        System.out.println(DateUtil.stringToDate("2019-06-13 15:55:10", DateUtil.DATE_PATTERN.YYYY_MM_DD_HH_MM_SS));
    }



}
