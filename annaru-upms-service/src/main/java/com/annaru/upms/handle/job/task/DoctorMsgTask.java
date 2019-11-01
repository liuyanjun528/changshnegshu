package com.annaru.upms.handle.job.task;

import com.annaru.upms.entity.*;
import com.annaru.upms.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author：wh
 * @Description：每周五的下午4点发送消息给医生
 * @Date:2019/10/31 9:32
 */
@Component("DoctorMsgTask")
public class DoctorMsgTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ISysDoctorService sysDoctorService;//医生表
    @Autowired
    private IEntityHealthyAppointmentService entityHealthyAppointmentService;//查询医生下周是否有健康评估
    @Autowired
    private ISysDoctorNurseScheduleService sysDoctorNurseScheduleService;//查询医生下周是否排班
    @Autowired
    private ISysMessageTemplateService sysMessageTemplateService;//查询消息模板
    @Autowired
    private ISysMessageService sysMessageService;//添加消息
    @Autowired
    private ISysNurseService sysNurseService;




    public void doctorMsgResult() {
        logger.info("定时任务开始---给医生发送消息");

        //0.查询所有医生
        List<SysDoctor> sysDoctors = sysDoctorService.seleDoctorAll();

        for(SysDoctor sd:sysDoctors){
        // 1.查询医生下周是否有上门健康评估服务并且是未完成的
            int i = entityHealthyAppointmentService.selectIsNotServer(sd.getDoctorNo());

        //2.查询医生下周是否有排班
            int j = sysDoctorNurseScheduleService.selectDoctorNextWeekSchedule(sd.getDoctorNo());

        //3.下周没有健康评估服务 并且 有排班跳过
            if(i<0||j>0){
                return ;
            }else if(i>0&&j<0){ //下周有服务 没排班 进行消息通知

        //4.给医生发送消息
                SysMessageTemplate sysMessageTemplate = sysMessageTemplateService.selectMessageTemplate(39);
                //添加消息内容
                SysMessage sm=new SysMessage();
                sm.setUserId(sd.getUserId());
                sm.setMsgCate(2);
                sm.setBusinessCate(7);
                sm.setContent(sysMessageTemplate.getContentTemplate());
                sm.setCreationTime(new Date());
                sysMessageService.save(sm);
            }
        }
        logger.info("定时任务-->给医生发送消息 执行完成");
    }
    //--------------------------------------------------------------------------------------
    public void nurseMsgResult() {
        logger.info("定时任务开始---给护士发送消息");

        //0.查询所有护士
        List<SysNurse> sysNurses = sysNurseService.selectAllNurse();
        for(SysNurse sn:sysNurses){

            //1.查询护士下周是否有排班
            int i = sysDoctorNurseScheduleService.selectNurseNextWeekSchedule(sn.getNurseNo());

            //2.下周有排班跳过
            if(i>0){
                return ;
            }else{ //下周没排班 进行消息通知
                //3.给护士发送消息
                SysMessageTemplate sysMessageTemplate = sysMessageTemplateService.selectMessageTemplate(33);
                //添加消息内容
                SysMessage msg=new SysMessage();
                msg.setUserId(sn.getUserId());
                msg.setMsgCate(2);
                msg.setBusinessCate(4);
                msg.setContent(sysMessageTemplate.getContentTemplate());
                msg.setCreationTime(new Date());
                sysMessageService.save(msg);
            }
        }
        logger.info("定时任务-->给护士发送消息执行完成!");
    }


}
