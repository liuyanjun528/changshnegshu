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
    private ISysVerifyDocsService sysVerifyDocsService;
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
    public boolean saveDocsBasics(SysVerifyDocsVoZ sysVerifyDocsVoZ, List<SysVerifyDocs> sysVerifyDocsList1) {
         boolean isSave = false;

         int isReturn = 0;
        // 判断这个 userId 的认证资料集合
        SysVerifyDocs sysVerifyDocs1 = null;
        SysVerifyDocs sysVerifyDocs2 = null;
        if (sysVerifyDocsList1.size() == 0){
             // 用户未认证
             isReturn = 1;
        }else if (sysVerifyDocsList1.size() == 2){
             sysVerifyDocs1 = sysVerifyDocsList1.get(0);
             sysVerifyDocs2 = sysVerifyDocsList1.get(1);
             if ((sysVerifyDocs1.getDocCates() == 1 && sysVerifyDocs2.getDocCates() == 2) || (sysVerifyDocs1.getDocCates() == 2 && sysVerifyDocs2.getDocCates() == 1)){
                // 用户已认证
                 isReturn = 2;
             }
        }else if (sysVerifyDocsList1.size() > 2){
             // 护士已经认证过
             return false;
         }
         String getBelongOffice = "";
         if (sysVerifyDocsVoZ.getBelongOffice() != null && sysVerifyDocsVoZ.getBelongOffice() != 0){
            getBelongOffice = sysVerifyDocsVoZ.getBelongOffice().toString();
         }
         if (sysVerifyDocsVoZ.getIdentification() == 2){// 医生
             SysDoctor sysDoctor = new SysDoctor();
             sysDoctor.setDoctorNo(sysVerifyDocsVoZ.getUserNo());
             sysDoctor.setUserId(sysVerifyDocsVoZ.getUserId());
             sysDoctor.setBelongInstitution(sysVerifyDocsVoZ.getBelongHospital());
             sysDoctor.setBelongOffice(getBelongOffice);
             sysDoctor.setJobTitle(sysVerifyDocsVoZ.getJobTitle());
             sysDoctor.setIntroductions(sysVerifyDocsVoZ.getIntroductions());
             sysDoctor.setCreationTime(new Date());
             if (isReturn == 1){
                 sysDoctor.setDoctorName(sysVerifyDocsVoZ.getFullName());
             }
             if (isReturn == 2){
                 sysDoctor.setDoctorName(sysVerifyDocs1.getFullName());
             }
             if (iSysDoctorService.save(sysDoctor)){
                 isSave = true;
             }
         }else if (sysVerifyDocsVoZ.getIdentification() == 1){ // 护士
             SysNurse sysNurse = new SysNurse();
             sysNurse.setNurseNo(sysVerifyDocsVoZ.getUserNo());
             sysNurse.setUserId(sysVerifyDocsVoZ.getUserId());
             sysNurse.setBelongHospital(sysVerifyDocsVoZ.getBelongHospital());
             sysNurse.setBelongOffice(getBelongOffice);
             sysNurse.setJobTitle(sysVerifyDocsVoZ.getJobTitle());
             sysNurse.setIntroductions(sysVerifyDocsVoZ.getIntroductions());
             sysNurse.setCreationTime(new Date());
             if (isReturn == 1){
                 sysNurse.setNurseName(sysVerifyDocsVoZ.getFullName());
             }
             if (isReturn == 2){
                 sysNurse.setNurseName(sysVerifyDocs1.getFullName());
             }
             if (iSysNurseService.save(sysNurse)){
                 isSave = true;
             }
         }
         if (isSave){
            // 用户未认证
            if (isReturn == 1){
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
                        return dosIf(sysVerifyDocsVoZ, isReturn);
                    }
                }
            }
            // 用户已经认证, 要认证医护, 则先要修改类别和审核状态, 在保存资格证
            if (isReturn == 2){
                SysVerifyDocs sysVerifyDocs = new SysVerifyDocs();
                sysVerifyDocs.setUserId(sysVerifyDocsVoZ.getUserId());
                sysVerifyDocs.setCates(sysVerifyDocsVoZ.getIdentification());
                if (sysVerifyDocsService.updateByUserId(sysVerifyDocs)){
                    sysVerifyDocsVoZ.setFullName(sysVerifyDocs1.getFullName());
                    sysVerifyDocsVoZ.setIdCardNo(sysVerifyDocs1.getIdNo());
                    return dosIf(sysVerifyDocsVoZ, isReturn);
                }
            }
         }
         return false;
    }

    /**
     * 保存资格认证
     * @author zk
     * @date 2019/10/16
     * @param sysVerifyDocsVoZ
     * @return
     */
    public boolean dosIf(SysVerifyDocsVoZ sysVerifyDocsVoZ, int isReturn){

        SysVerifyDocs sysVerifyDocs = null;
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
                    if (isReturn == 1){
                        params.put("idCardNo", sysVerifyDocsVoZ.getIdCardNo());
                        params.put("dateOfBirth", getBirthday(sysVerifyDocsVoZ.getIdCardNo()));
                    }
                    params.put("gender", sysVerifyDocsVoZ.getGender());
                    params.put("fullName", sysVerifyDocsVoZ.getFullName());
                    params.put("userId", sysVerifyDocsVoZ.getUserId());
                    if (userBasicService.updateUserBascByParams(params)){
                        return true;
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
    public SysVerifyDocs selectResult(String userId,Integer cates) {
        return this.baseMapper.selectResult(userId,cates);
    }

    @Override
    public boolean updateByUserId(SysVerifyDocs sysVerifyDocs) {
        if (this.baseMapper.updateByUserId(sysVerifyDocs) > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<SysVerifyDocs> getListByUserId(String userId) {
        return this.baseMapper.getListByUserId(userId);
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





















