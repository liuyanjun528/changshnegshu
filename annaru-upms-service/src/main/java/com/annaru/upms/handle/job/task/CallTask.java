package com.annaru.upms.handle.job.task;

import com.annaru.upms.service.ICallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component("callTask")
public class CallTask {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ICallService callService;

    /**
     * 检查主从 进行比较
     * 1、从创业数据库 查询当天所有叫号数据
     * 2、获取本地数据库 当天所有叫号数据
     * 3、两个数据库当天叫号数据对比 保存到本地数据库
     */
    public void chakeUpdateDb() {



        List list=new ArrayList();
        list.contains("");
    }


    /**
     * 推消息到客户端
     */
    public void sendMsg() {

    }


}
