package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.exception.GlobalException;
import com.annaru.upms.entity.OrderMain;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.UserRelatives;
import com.annaru.upms.entity.vo.EntityHealthyAppointmentVo;
import com.annaru.upms.service.IOrderCustomerService;
import com.annaru.upms.service.IOrderMainService;
import com.annaru.upms.service.IUserRelativesService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.EntityHealthyAppointmentMapper;
import com.annaru.upms.entity.EntityHealthyAppointment;
import com.annaru.upms.service.IEntityHealthyAppointmentService;
import jodd.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 企业服务预约记录
 *
 * @author wh
 * @date 2019-05-22 12:06:42
 */
@Service
public class EntityHealthyAppointmentServiceImpl extends ServiceImpl<EntityHealthyAppointmentMapper, EntityHealthyAppointment> implements IEntityHealthyAppointmentService {

    @Autowired
    private IOrderCustomerService orderCustomerService;
    @Autowired
    private IUserRelativesService userRelativesService;
    @Autowired
    private IOrderMainService orderMainService;



    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<EntityHealthyAppointment> page = new PageUtils<EntityHealthyAppointment>(params).getPage();
        IPage<EntityHealthyAppointment> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<EntityHealthyAppointment>(iPage);
    }

    @Override
    public List<EntityHealthyAppointmentVo> selectServiceAppointment(String orderNo) {
        return this.baseMapper.selectServiceAppointment(orderNo);
    }

    @Override
    public int updateStatusByOrderNo(String orderNo) {
        return this.baseMapper.updateStatusByOrderNo(orderNo);
    }

    @Override
    public PageUtils selectUpDoorServer(Map<String, Object> params) {
        Page<EntityHealthyAppointmentVo> page = new PageUtils<EntityHealthyAppointmentVo>(params).getPage();
        IPage<EntityHealthyAppointmentVo> iPage = this.baseMapper.selectUpDoorServer(page, params);
        return new PageUtils<EntityHealthyAppointment>(iPage);

    }
    @Override
    public List<EntityHealthyAppointment> getTimeByUserIdZ(Map<String,Object> params) {
        return this.baseMapper.getTimeByUserIdZ(params);
    }

    @Override
    @Transactional
    public int insertEntityDoctorAppointment(EntityHealthyAppointment entityHealthyAppointment, String []RelativeId) {
        int i=0;
        try {
            //添加订单主表
            entityHealthyAppointment.getOrderMain().setCreationtime(new Date());
            entityHealthyAppointment.getOrderMain().setOrderCates(5);
            entityHealthyAppointment.getOrderMain().setUserChannel("长生树APP");
            boolean save = orderMainService.save(entityHealthyAppointment.getOrderMain());

            //往entityHealthyAppointment 添加数据
            if (save=true) {
                entityHealthyAppointment.setPkgMainId(8);
                entityHealthyAppointment.setPkgDetailId(801);
                i = this.baseMapper.insertEntityDoctorAppointment(entityHealthyAppointment);
            }

            if (i>0) {
                //只要生成订单 就往OrderCustomer表添加一条记录
                // 如果套餐个数==1 user_cates为1 如果套餐个数大于1 user_cates为2
                if (entityHealthyAppointment.getOrderMain().getTotalQty()==1&& ArrayUtils.isEmpty(RelativeId)){
                    entityHealthyAppointment.getOrderMain().getOrderCustomer().setOrderNo(entityHealthyAppointment.getOrderMain().getOrderNo());
                    entityHealthyAppointment.getOrderMain().getOrderCustomer().setRelativeId(entityHealthyAppointment.getOrderMain().getUserId());
                    entityHealthyAppointment.getOrderMain().getOrderCustomer().setUserCates(1);
                    orderCustomerService.insertOrderCustomer(entityHealthyAppointment.getOrderMain().getOrderCustomer());//添加订单亲属表
                }

                if(null!=RelativeId){

                    //--添加亲属编号
                    if(entityHealthyAppointment.getOrderMain().getTotalQty()>=1){
                        //查询用户下的所有亲属
                        List<UserRelatives> list = userRelativesService.selectAll(entityHealthyAppointment.getOrderMain().getUserId());
                        Boolean result=false;
                        for (UserRelatives relative : list) {
                            for (String  rela:RelativeId ){
                                if (relative.getRefNo().equals(rela)) {//判断传来的亲属usuerId 跟数据库的是否匹配
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
                            if(RelativeId.length<entityHealthyAppointment.getOrderMain().getTotalQty()){
                                entityHealthyAppointment.getOrderMain().getOrderCustomer().setOrderNo(entityHealthyAppointment.getOrderMain().getOrderNo());
                                entityHealthyAppointment.getOrderMain().getOrderCustomer().setRelativeId(entityHealthyAppointment.getOrderMain().getUserId());
                                entityHealthyAppointment.getOrderMain().getOrderCustomer().setUserCates(1);
                                i=orderCustomerService.insertOrderCustomer(entityHealthyAppointment.getOrderMain().getOrderCustomer());//添加订单亲属表

                                for (String relativeId :RelativeId){    //如果匹配 传来几个亲属循环往OrderCustomer添加几个亲属编号
                                    entityHealthyAppointment.getOrderMain().getOrderCustomer().setOrderNo(entityHealthyAppointment.getOrderMain().getOrderNo());
                                    entityHealthyAppointment.getOrderMain().getOrderCustomer().setRelativeId(relativeId);
                                    entityHealthyAppointment.getOrderMain().getOrderCustomer().setUserCates(2);
                                    i=orderCustomerService.insertOrderCustomer(entityHealthyAppointment.getOrderMain().getOrderCustomer());//添加订单亲属表
                                }
                            }
                            // 如果亲属长度=总套餐个数 只需要添加亲属  只为亲属购买的状态
                            if(RelativeId.length==entityHealthyAppointment.getOrderMain().getTotalQty()){
                                for (String relativeId :RelativeId){
                                    entityHealthyAppointment.getOrderMain().getOrderCustomer().setOrderNo(entityHealthyAppointment.getOrderMain().getOrderNo());
                                    entityHealthyAppointment.getOrderMain().getOrderCustomer().setRelativeId(relativeId);
                                    entityHealthyAppointment.getOrderMain().getOrderCustomer().setUserCates(2);
                                    i=orderCustomerService.insertOrderCustomer(entityHealthyAppointment.getOrderMain().getOrderCustomer());//添加订单亲属表
                                }
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
    public int selectEntityServiceCount(String userId) {
        return this.baseMapper.selectEntityServiceCount(userId);
    }

    @Override
    public boolean updateStatus3ByOrderNo(String orderNo) {
        if (this.baseMapper.updateStatus3ByOrderNo(orderNo) > 0){
            return true;
        }
        return false;
    }

    @Override
    public EntityHealthyAppointment selectDoctorByUserId(String userId) {
        return this.baseMapper.selectDoctorByUserId(userId);
    }

    @Override
    public int selectIsNotServer(String doctorNo) {
        return this.baseMapper.selectIsNotServer(doctorNo);
    }

    @Override
    public Integer updateByOderNo(String orderNo) {
        if(StringUtil.isNotBlank(orderNo)){
            return this.baseMapper.updateByOderNo(orderNo);
        }
        return 0;
    }
}
