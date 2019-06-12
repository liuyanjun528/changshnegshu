package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.SysDoctor;
import com.annaru.upms.entity.SysNurse;
import com.annaru.upms.entity.vo.SysVerifyDocsVoZ;
import com.annaru.upms.service.ISysDoctorService;
import com.annaru.upms.service.ISysNurseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysVerifyDocsMapper;
import com.annaru.upms.entity.SysVerifyDocs;
import com.annaru.upms.service.ISysVerifyDocsService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 认证资料
 *
 * @author zk
 * @date 2019-06-10 14:59:12
 */
@Service
public class SysVerifyDocsServiceImpl extends ServiceImpl<SysVerifyDocsMapper, SysVerifyDocs> implements ISysVerifyDocsService {

    @Resource
    private ISysDoctorService iSysDoctorService;
    @Resource
    private ISysNurseService iSysNurseService;
    @Resource
    private ISysVerifyDocsService iSysVerifyDocsService;

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<SysVerifyDocs> page = new PageUtils<SysVerifyDocs>(params).getPage();
        IPage<SysVerifyDocs> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<SysVerifyDocs>(iPage);
    }

    @Override
    @Transactional
    public boolean saveDocsBasics(SysVerifyDocsVoZ sysVerifyDocsVoZ) {
         boolean isSave = false;
         if (sysVerifyDocsVoZ.getIdentification() == 2){// 医生
             SysDoctor sysDoctor = new SysDoctor();
             sysDoctor.setDoctorNo(sysVerifyDocsVoZ.getUserNo());
             sysDoctor.setUserId(sysVerifyDocsVoZ.getUserId());
             sysDoctor.setBelongInstitution(sysVerifyDocsVoZ.getBelongHospital());
             sysDoctor.setBelongOffice(sysVerifyDocsVoZ.getBelongOffice());
             sysDoctor.setJobTitle(sysVerifyDocsVoZ.getJobTitle());
             sysDoctor.setDuties(sysVerifyDocsVoZ.getDuties());
             sysDoctor.setIntroductions(sysVerifyDocsVoZ.getIntroductions());
             sysDoctor.setCreationTime(new Date());
             if (iSysDoctorService.save(sysDoctor)){
                 isSave = true;
             }
         }else if (sysVerifyDocsVoZ.getIdentification() == 1){ // 护士
             SysNurse sysNurse = new SysNurse();
             sysNurse.setNurseNo(sysVerifyDocsVoZ.getUserNo());
             sysNurse.setUserId(sysVerifyDocsVoZ.getUserId());
             sysNurse.setBelongHospital(sysVerifyDocsVoZ.getBelongHospital());
             sysNurse.setBelongOffice(sysVerifyDocsVoZ.getBelongOffice());
             sysNurse.setJobTitle(sysVerifyDocsVoZ.getJobTitle());
             sysNurse.setDuties(sysVerifyDocsVoZ.getDuties());
             sysNurse.setIntroductions(sysVerifyDocsVoZ.getIntroductions());
             sysNurse.setCreationTime(new Date());
             if (iSysNurseService.save(sysNurse)){
                 isSave = true;
             }
         }
         if (isSave){
            SysVerifyDocs sysVerifyDocs = new SysVerifyDocs();
            sysVerifyDocs.setUserId(sysVerifyDocsVoZ.getUserId());
            sysVerifyDocs.setCates(sysVerifyDocsVoZ.getIdentification());
            sysVerifyDocs.setDocCates(1);
            sysVerifyDocs.setImages(sysVerifyDocsVoZ.getImg1());
            sysVerifyDocs.setCreationTime(new Date());
            if (iSysVerifyDocsService.save(sysVerifyDocs)){
                sysVerifyDocs = new SysVerifyDocs();
                sysVerifyDocs.setUserId(sysVerifyDocsVoZ.getUserId());
                sysVerifyDocs.setCates(sysVerifyDocsVoZ.getIdentification());
                sysVerifyDocs.setDocCates(2);
                sysVerifyDocs.setImages(sysVerifyDocsVoZ.getImg2());
                sysVerifyDocs.setCreationTime(new Date());
                if (iSysVerifyDocsService.save(sysVerifyDocs)){
                    return true;
                }
            }
         }
        return false;
    }

}





















