package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.entity.UserCards;
import com.annaru.upms.mapper.UserCardsMapper;
import com.annaru.upms.service.IUserCardsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * 用户绑卡信息
 *
 * @author zk
 * @date 2019-05-09 11:14:28
 */
@Service
public class UserCardsServiceImpl extends ServiceImpl<UserCardsMapper, UserCards> implements IUserCardsService {

//    @Autowired
//    private UserCardsMapper cardsMapper;
//    @Autowired
//    private UserBasicMapper basicMapper;
//    @Autowired
//    private SysInstitutionMapper institutionMapper;
//
//    @Transactional
//    public int insertCardAndBaseAndInstitution(UserCards cards){
//        cardsMapper.insertCards(cards);
//        basicMapper.insertBasic(basic);
//        institutionMapper.insertInstitution(institution);
//        UserBasic basic=new UserBasic();
//        basic.setUserId(cards.getUserId());
//
//        int i = basicMapper.insertBasic(basic);
//        return i;
//    }






    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<UserCards> page = new PageUtils<UserCards>(params).getPage();
        IPage<UserCards> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<UserCards>(iPage);
    }

    @Override
    public List<UserCards> selectByStatus(int status, int cardCates) {
        return this.baseMapper.selectByStatus(status,cardCates);
    }

    @Override
    public int insertCardAndBaseAndInstitution(UserCards cards) {
        return this.baseMapper.insertCardAndBaseAndInstitution(cards);
    }


}
