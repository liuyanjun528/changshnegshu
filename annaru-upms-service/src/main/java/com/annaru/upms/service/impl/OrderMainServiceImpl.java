package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.exception.GlobalException;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.*;
import com.annaru.upms.entity.vo.*;
import com.annaru.upms.mapper.OrderMainMapper;
import com.annaru.upms.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定单主表
 *
 * @author zk
 * @date 2019-05-09 11:14:29
 */
@Service
public class OrderMainServiceImpl extends ServiceImpl<OrderMainMapper, OrderMain> implements IOrderMainService {

    @Autowired
    private IExamPackageAppendService examPackageAppendService;
    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private IOrderCustomerService orderCustomerService;
    @Autowired
    private IUserRelativesService userRelativesService;
    @Autowired
    private IOrderAppointmentService orderAppointmentService;
    @Autowired
    private IOrderAdditionalInfoService orderAdditionalInfoService;


    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderMain> page = new PageUtils<OrderMain>(params).getPage();
        IPage<OrderMain> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderMain>(iPage);
    }

    @Override
    public PageUtils notReceiptList(Map<String, Object> params) {
        Page<NotReceiptOrder> page = new PageUtils<NotReceiptOrder>(params).getPage();
        IPage<NotReceiptOrder> iPage = this.baseMapper.notReceiptList(page, params);
        return new PageUtils<NotReceiptOrder>(iPage);
    }

    @Override
    public PageUtils receiptOrderSelectList(Map<String, Object> params) {
        Page<NotReceiptOrder> page = new PageUtils<NotReceiptOrder>(params).getPage();
        IPage<NotReceiptOrder> iPage = this.baseMapper.receiptOrderSelectList(page, params);
        return new PageUtils<NotReceiptOrder>(iPage);
    }

    @Override
    public PageUtils selectOrderPage(Map<String, Object> params) {
        Page<OrderMainVoZDdlb> page = new PageUtils<OrderMainVoZDdlb>(params).getPage();
        IPage<OrderMainVoZDdlb> iPage = this.baseMapper.selectOrderPage(page, params);
        return new PageUtils<OrderMainVoZDdlb>(iPage);
    }

    @Override
    public OrderMainVoZTC selectPackageOrder(Map<String, Object> params) {
        OrderMainVoZTC list = this.baseMapper.selectPackageOrder(params);
        return list;
    }

    @Override
    public OrderMainVoZZF selectPackageAdvance(Map<String, Object> params) {
        OrderMainVoZZF list = this.baseMapper.selectPackageAdvance(params);
        return list;
    }

    @Override
    public OrderMainVoSumByStatusZ selectSumByStatus(Map<String, Object> params) {
        return this.baseMapper.selectSumByStatus(params);
    }

    @Override
    public OrderMainVoZMzlt selectPackageGreen(Map<String, Object> params) {
        OrderMainVoZMzlt list = this.baseMapper.selectPackageGreen(params);
        return list;
    }

    public OrderMain getOrderNo(Map<String,Object> params){
        return this.baseMapper.getOrderNo(params);
    }

    @Override
    public OrderMain getByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            return null;
        }
        return this.baseMapper.selectByOrderNo(orderNo);
    }

    @Override
    @Transactional
    public int insertOrderMain(OrderMain orderMain,String []RelativeId) {
        int i=0;
        try {
            //添加订单主表
            orderMain.setCreationtime(new Date());
            i = this.baseMapper.insertOrderMain(orderMain);

            //根据套餐编号查询 如果有赠送服务
            List<AppendOrderMain> appendOrderMains = this.baseMapper.selectAppendByOrderNo(orderMain.getOrderNo());

            if (i > 0 && null!=appendOrderMains ) {
                List<ExamPackageAppend> examPackageAppends = examPackageAppendService.selectExamName(Integer.parseInt(orderMain.getReferenceNo()));
                OrderDetail detail = new OrderDetail();
                detail.setCreationtime(orderMain.getCreationtime());
                for (ExamPackageAppend exam : examPackageAppends) {
                    System.out.println("周期：---->"+exam.getPeriods());
                    detail.setAppendId(exam.getAppendId());
                    detail.setTotalCount(exam.getPeriods());
                    detail.setRestCount(exam.getPeriods());
                    detail.setCreationtime(orderMain.getOrderTime());
                    detail.setOrderNo(orderMain.getOrderNo());
                    i=orderDetailService.insertOrderDetail(detail);//添订单详情表
                }
            }


            if (i > 0) {
                //只要生成订单 就往OrderCustomer表添加一条记录
                // 如果套餐个数==1 user_cates为1 如果套餐个数大于1 user_cates为2
                if (orderMain.getTotalQty()==1|| ArrayUtils.isEmpty(RelativeId)){
                    orderMain.getOrderCustomer().setOrderNo(orderMain.getOrderNo());
                    orderMain.getOrderCustomer().setRelativeId(orderMain.getUserId());
                    orderMain.getOrderCustomer().setUserCates(1);
                    i=orderCustomerService.insertOrderCustomer(orderMain.getOrderCustomer());//添加订单亲属表
                }

                //--添加亲属编号
                System.out.println("人数：---->"+orderMain.getTotalQty());
                if(orderMain.getTotalQty()>1){
                    //查询用户下的所有亲属
                    List<UserRelatives> list = userRelativesService.selectAll(orderMain.getUserId());
                    System.out.println("1---->"+list);
                    Boolean result=false;
                    for (UserRelatives relative : list) {
                        for (String  rela:RelativeId ){
                            if (relative.getRefNo().equals(rela)) {//判断传来的亲属userId 跟数据库的亲属id是否匹配
                                result=true;
                                break;
                            }
                        }

                    }
                    if(result==false){
                        i=0;
                        throw new GlobalException("没有相关亲属");
                    }
                    if (result) {
                        System.out.println("2---->"+result);
                        //如果亲属长度<总套餐个数 需要添加自己跟亲属
                        if(RelativeId.length<orderMain.getTotalQty()){
                            System.out.println("3---->"+RelativeId.length);
                            System.out.println("4---->"+orderMain.getTotalQty());
                            orderMain.getOrderCustomer().setOrderNo(orderMain.getOrderNo());
                            orderMain.getOrderCustomer().setRelativeId(orderMain.getUserId());
                            orderMain.getOrderCustomer().setUserCates(1);
                            i=orderCustomerService.insertOrderCustomer(orderMain.getOrderCustomer());//添加订单亲属表

                            for (String relativeId :RelativeId){    //如果匹配 传来几个亲属循环往OrderCustomer添加几个亲属编号
                                orderMain.getOrderCustomer().setOrderNo(orderMain.getOrderNo());
                                orderMain.getOrderCustomer().setRelativeId(relativeId);
                                orderMain.getOrderCustomer().setUserCates(2);
                                i=orderCustomerService.insertOrderCustomer(orderMain.getOrderCustomer());//添加订单亲属表
                            }
                        }
                        // 如果亲属长度=总套餐个数 只需要添加亲属  只为亲属购买的状态
                        if(RelativeId.length==orderMain.getTotalQty()){
                            for (String relativeId :RelativeId){
                                orderMain.getOrderCustomer().setOrderNo(orderMain.getOrderNo());
                                orderMain.getOrderCustomer().setRelativeId(relativeId);
                                orderMain.getOrderCustomer().setUserCates(2);
                                i=orderCustomerService.insertOrderCustomer(orderMain.getOrderCustomer());//添加订单亲属表
                            }
                        }

                    }
                                     }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return i;
    }

    @Override
    public List<AppendOrderMain> selectAppendByOrderNo(String orderNo) {
        return this.baseMapper.selectAppendByOrderNo(orderNo);
    }

    public List<Integer>  getTimes(Map<String,Object> params){
        return this.baseMapper.getTimes(params);
    }

    public OrderInfoVo getToB(Map<String,Object> params){
        return this.baseMapper.getToB(params);
    }

    public List<OrderExtensionInfoVo> getExtensionInfo(Map<String,Object> params){
        return this.baseMapper.getExtensionInfo(params);
    }

    public OrderInfoVo getBase(Map<String,Object> params){
        return this.baseMapper.getBase(params);
    }

    public UserPackagesVo getToBPackages(Map<String,Object> params){
        return this.baseMapper.getToBPackages(params);
    }

    public List<UserPackagesVo> getPackages(Map<String,Object> params){
        return this.baseMapper.getPackages(params);
    }

    public OrderMain getReferenceNo(Map<String,Object> params){
        return this.baseMapper.getReferenceNo(params);
    }

    public OrderMain getInfo(Map<String,Object> params){
        return this.baseMapper.getInfo(params);
    }

    @Override
    public PageUtils<ExamReportVo> getExamReportVoPage(Integer page, Integer limit, String userId, Integer packageCates, Integer orderCates,Integer cateId) {
        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        Page<ExamReportVo> pageObj = new PageUtils<ExamReportVo>(params).getPage();
        IPage<ExamReportVo> iPage = this.baseMapper.selectExamReportVoPage(pageObj, userId, packageCates, orderCates,cateId);
        return new PageUtils(iPage);
    }

    @Override
    public Boolean updateCloseOrder(String orderNo) {
        return this.baseMapper.updateCloseOrder(orderNo);
    }

    @Override
    public List<OrderMain> selectOrderNonPayment() {
        return this.baseMapper.selectOrderNonPayment();
    }

    @Override
    public int updateOrderStatus(String orderNo) {
        return this.baseMapper.updateOrderStatus(orderNo);
    }

    @Override
    public int insertHpvOrder(OrderMain orderMain) {
        return this.baseMapper.insertHpvOrder(orderMain);
    }

    @Override
    @Transactional
    public int insertHpvAppointment(OrderMain orderMain) {
        int i=0;
        try {
            //添加订单主表
            orderMain.setOrderCates(7);
            orderMain.setUserChannel("长生树APP");
            orderMain.setCreationtime(new Date());
            orderMain.setOrderTime(orderMain.getCreationtime());
            i = this.baseMapper.insertHpvAppointment(orderMain);

            if(i>0){    //添加预约表
                OrderAppointment oa=new OrderAppointment();
                oa.setOrderNo(orderMain.getOrderNo());
                oa.setUserId(orderMain.getUserId());
                oa.setAddress(orderMain.getOrderAppointment().getAddress());
                oa.setAppointmentCates(orderMain.getOrderCates());
                oa.setCreationTime(orderMain.getOrderTime());
                boolean save = orderAppointmentService.save(oa);

                if(save){   //添加预约其他信息表
                    OrderAdditionalInfo oai=new OrderAdditionalInfo();
                    oai.setOrderNo(orderMain.getOrderNo());
                    oai.setOption1(orderMain.getOrderAdditionalInfo().getOption1());
                    oai.setAppointmentCates(orderMain.getOrderCates());
                    oai.setAmount(orderMain.getAmount());
                    oai.setCreationTime(orderMain.getOrderTime());
                    orderAdditionalInfoService.save(oai);
                }
            }
             } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return i;
    }
}
