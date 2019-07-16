package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.exception.GlobalException;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.OrderAdditionalInfo;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.entity.UserRelatives;
import com.annaru.upms.mapper.OrderAdditionalInfoMapper;
import com.annaru.upms.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description:添加企业门诊绿通
 * @Author: wh
 * @Date: 2019/6/5 9:46
 */
@Service
public class OrderAdditionalInfoServiceImpl extends ServiceImpl<OrderAdditionalInfoMapper, OrderAdditionalInfo> implements IOrderAdditionalInfoService {

    @Autowired
    private IOrderCustomerService orderCustomerService;
    @Autowired
    private IUserRelativesService userRelativesService;
    @Autowired
    private IOrderMainService orderMainService;
    @Autowired
    private IEntityHealthyAppointmentService entityHealthyAppointmentService;


    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<OrderAdditionalInfo> page = new PageUtils<OrderAdditionalInfo>(params).getPage();
        IPage<OrderAdditionalInfo> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<OrderAdditionalInfo>(iPage);
    }

    @Override
    public UserCards selectUserOrRelativeInfo(String userId, String relativeId) {
        return this.baseMapper.selectUserOrRelativeInfo(userId, relativeId);
    }

    @Override
    @Transactional
    public int insertGreenPassage(OrderAdditionalInfo orderAdditionalInfo, String[] RelativeId) {
        int i=0;
        try {
            //添加订单主表
            orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().setCreationtime(new Date());
            orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().setOrderCates(6);
            boolean save = orderMainService.save(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain());

            if (save=true) {
                //往entityHealthyAppointment 添加数据
                orderAdditionalInfo.getEntityHealthyAppointment().setPkgMainId(8);
                orderAdditionalInfo.getEntityHealthyAppointment().setPkgDetailId(802);
                orderAdditionalInfo.getEntityHealthyAppointment().setOrderNo(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderNo());
                orderAdditionalInfo.getEntityHealthyAppointment().setUserId(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getUserId());
                orderAdditionalInfo.getEntityHealthyAppointment().setCreationTime(new Date());
                boolean save1 = entityHealthyAppointmentService.save(orderAdditionalInfo.getEntityHealthyAppointment());
                //往orderAdditionalInfo 添加数据
                i = this.baseMapper.insertGreenPassage(orderAdditionalInfo);
            }

            if (i>0) {
                //只要生成订单 就往OrderCustomer表添加一条记录
                // 如果套餐个数==1 user_cates为1 如果套餐个数大于1 user_cates为2
                if (orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getTotalQty()==1&& ArrayUtils.isEmpty(RelativeId)){
                    orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setOrderNo(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderNo());
                    orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setRelativeId(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getUserId());
                    orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setUserCates(1);
                    int j=orderCustomerService.insertOrderCustomer(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer());//添加订单亲属表
                }

                if(null!=RelativeId){

                    //--添加亲属编号
                    if(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getTotalQty()>=1){
                        //查询用户下的所有亲属
                        List<UserRelatives> list = userRelativesService.selectAll(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getUserId());
                        Boolean result=false;
                        for (UserRelatives relative : list) {
                            for (String  rela:RelativeId ){
                                if (relative.getRelativeId().equals(rela)) {//判断传来的亲属ID 跟数据库保存的亲属是否匹配
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
                            //如果亲属长度<总套餐个数 需要添加自己跟亲属
                            if(RelativeId.length<orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getTotalQty()){
                                orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setOrderNo(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderNo());
                                orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setRelativeId(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getUserId());
                                orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setUserCates(1);
                                i=orderCustomerService.insertOrderCustomer(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer());//添加订单亲属表

                                for (String relativeId :RelativeId){    //如果匹配 传来几个亲属循环往OrderCustomer添加几个亲属编号
                                    orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setOrderNo(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderNo());
                                    orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setRelativeId(relativeId);
                                    orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setUserCates(2);
                                    i=orderCustomerService.insertOrderCustomer(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer());//添加订单亲属表
                                }
                            }
                            // 如果亲属长度=总套餐个数 只需要添加亲属  只为亲属购买的状态
                            if(RelativeId.length==orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getTotalQty()){
                                for (String relativeId :RelativeId){
                                    orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setOrderNo(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderNo());
                                    orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setRelativeId(relativeId);
                                    orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer().setUserCates(2);
                                    i=orderCustomerService.insertOrderCustomer(orderAdditionalInfo.getEntityHealthyAppointment().getOrderMain().getOrderCustomer());//添加订单亲属表
                                }
                            }

                        }
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return i;
    }

}
