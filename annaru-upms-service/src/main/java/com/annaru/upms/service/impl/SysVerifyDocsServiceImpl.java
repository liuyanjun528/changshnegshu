package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.util.DateUtil;
import com.annaru.upms.entity.SysDoctor;
import com.annaru.upms.entity.SysNurse;
import com.annaru.upms.entity.UserBasic;
import com.annaru.upms.entity.vo.SysVerifyDocsVoZ;
import com.annaru.upms.service.ISysDoctorService;
import com.annaru.upms.service.ISysNurseService;
import com.annaru.upms.service.IUserBasicService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.SysVerifyDocsMapper;
import com.annaru.upms.entity.SysVerifyDocs;
import com.annaru.upms.service.ISysVerifyDocsService;
import jodd.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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
    @Autowired
    private SysVerifyDocsMapper sysVerifyDocsMapper;
    @Resource
    private IUserBasicService userBasicService;

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
         String getBelongOffice = "";
         if (sysVerifyDocsVoZ.getBelongOffice() != null && sysVerifyDocsVoZ.getBelongOffice() != 0){
             getBelongOffice = sysVerifyDocsVoZ.getBelongOffice().toString();
         }
         if (sysVerifyDocsVoZ.getIdentification() == 2){// 医生
             SysDoctor sysDoctor = new SysDoctor();
             sysDoctor.setDoctorNo(sysVerifyDocsVoZ.getUserNo());
             sysDoctor.setUserId(sysVerifyDocsVoZ.getUserId());
             sysDoctor.setDoctorName(sysVerifyDocsVoZ.getFullName());
             sysDoctor.setBelongInstitution(sysVerifyDocsVoZ.getBelongHospital());
             sysDoctor.setBelongOffice(getBelongOffice);
             sysDoctor.setJobTitle(sysVerifyDocsVoZ.getJobTitle());
             sysDoctor.setIntroductions(sysVerifyDocsVoZ.getIntroductions());
             sysDoctor.setCreationTime(new Date());
             if (iSysDoctorService.save(sysDoctor)){
                 isSave = true;
             }
         }else if (sysVerifyDocsVoZ.getIdentification() == 1){ // 护士
             SysNurse sysNurse = new SysNurse();
             sysNurse.setNurseNo(sysVerifyDocsVoZ.getUserNo());
             sysNurse.setUserId(sysVerifyDocsVoZ.getUserId());
             sysNurse.setNurseName(sysVerifyDocsVoZ.getFullName());
             sysNurse.setBelongHospital(sysVerifyDocsVoZ.getBelongHospital());
             sysNurse.setBelongOffice(getBelongOffice);
             sysNurse.setJobTitle(sysVerifyDocsVoZ.getJobTitle());
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
            sysVerifyDocs.setFullName(sysVerifyDocsVoZ.getFullName());
            sysVerifyDocs.setIdNo(sysVerifyDocsVoZ.getIdCardNo());
            sysVerifyDocs.setImages(sysVerifyDocsVoZ.getImg1());
            sysVerifyDocs.setCreationTime(new Date());
            if (iSysVerifyDocsService.save(sysVerifyDocs)){
                sysVerifyDocs = new SysVerifyDocs();
                sysVerifyDocs.setUserId(sysVerifyDocsVoZ.getUserId());
                sysVerifyDocs.setFullName(sysVerifyDocsVoZ.getFullName());
                sysVerifyDocs.setCates(sysVerifyDocsVoZ.getIdentification());
                sysVerifyDocs.setDocCates(2);
                sysVerifyDocs.setFullName(sysVerifyDocsVoZ.getFullName());
                sysVerifyDocs.setIdNo(sysVerifyDocsVoZ.getIdCardNo());
                sysVerifyDocs.setImages(sysVerifyDocsVoZ.getImg2());
                sysVerifyDocs.setCreationTime(new Date());
                if (iSysVerifyDocsService.save(sysVerifyDocs)){
                    List<SysVerifyDocs> sysVerifyDocsList = new ArrayList<>();
                    List<String> stringList = sysVerifyDocsVoZ.getStringList();
                    if (stringList != null && stringList.size() > 0){
                        for (int i = 0 ; i < stringList.size() ; i++){
                            if (StringUtil.isNotBlank(stringList.get(i))){
                                sysVerifyDocs = new SysVerifyDocs();
                                sysVerifyDocs.setUserId(sysVerifyDocsVoZ.getUserId());
                                sysVerifyDocs.setFullName(sysVerifyDocsVoZ.getFullName());
                                sysVerifyDocs.setCates(sysVerifyDocsVoZ.getIdentification());
                                sysVerifyDocs.setDocCates(3);
                                sysVerifyDocs.setFullName(sysVerifyDocsVoZ.getFullName());
                                sysVerifyDocs.setIdNo(sysVerifyDocsVoZ.getIdCardNo());
                                sysVerifyDocs.setImages(stringList.get(i));
                                sysVerifyDocs.setCreationTime(new Date());
                                sysVerifyDocsList.add(sysVerifyDocs);
                            }
                        }
                        if (sysVerifyDocsList != null && sysVerifyDocsList.size() > 0){
                            if (iSysVerifyDocsService.saveBatch(sysVerifyDocsList)){
                                Map<String, Object> params = new HashMap<>();
//                                params.put("idCardNo", sysVerifyDocsVoZ.getIdCardNo());
                                params.put("gender", sysVerifyDocsVoZ.getGender());
                                params.put("fullName", sysVerifyDocsVoZ.getFullName());
//                                params.put("dateOfBirth", getBirthday(sysVerifyDocsVoZ.getIdCardNo()));
                                params.put("userId", sysVerifyDocsVoZ.getUserId());
                                if (userBasicService.updateUserBascByParams(params)){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
         }
        return false;
    }

    @Override
    public SysVerifyDocsVoZ selectVerNurse(String userId, Integer identification) {
        if(StringUtils.isNotBlank(userId)){
            SysVerifyDocsVoZ sysVerifyDocsVoZ = null;
            if(1 == identification){
                sysVerifyDocsVoZ = sysVerifyDocsMapper.selectVerNurse(userId);
            }else if (2 == identification){
                sysVerifyDocsVoZ = sysVerifyDocsMapper.selectVerDoctor(userId);
            }
            if(sysVerifyDocsVoZ != null){
                return sysVerifyDocsVoZ;
            }
        }
        return new SysVerifyDocsVoZ();
    }

    @Override
    public SysVerifyDocs saveUserVerify(SysVerifyDocs sysVerifyDocs) {
        return this.baseMapper.saveUserVerify(sysVerifyDocs);
    }

    @Override
    public SysVerifyDocs selectResult(String userId) {
        return this.baseMapper.selectResult(userId);
    }

    /**
     * 根据身份证得到出生年月日
     * @author zk
     * @date 2019/9/27
     * @param cardID
     * @return
     */
    public String getBirthday(String cardID) {
//        Date returnDate=null;
        StringBuffer tempStr=null;
        if(cardID!=null&&cardID.trim().length()>0){
            if(cardID.trim().length()==15){
                tempStr=new StringBuffer(cardID.substring(6, 12));
                tempStr.insert(4, '-');
                tempStr.insert(2, '-');
                tempStr.insert(0, "19");
            }else if(cardID.trim().length()==18){
                tempStr=new StringBuffer(cardID.substring(6, 14));
                tempStr.insert(6, '-');
                tempStr.insert(4, '-');
            }
        }
        if(tempStr!=null&&tempStr.toString().trim().length()>0){
//            returnDate= DateUtil.stringToDate(tempStr.toString(), DateUtil.DATE_PATTERN.YYYY_MM_DD);
            return tempStr.toString();
        }
        return null;
    }

}





















