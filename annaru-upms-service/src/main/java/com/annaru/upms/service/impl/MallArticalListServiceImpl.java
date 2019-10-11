package com.annaru.upms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.annaru.upms.entity.vo.MallArticalFansLogExtends;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.annaru.common.result.PageUtils;

import com.annaru.upms.mapper.MallArticalListMapper;
import com.annaru.upms.entity.MallArticalList;
import com.annaru.upms.service.IMallArticalListService;

import java.util.List;
import java.util.Map;

/**
 * 商城文章阅读
 *
 * @author zk
 * @date 2019-10-10 13:11:23
 */
@Service
public class MallArticalListServiceImpl extends ServiceImpl<MallArticalListMapper, MallArticalList> implements IMallArticalListService {

    @Override
    public PageUtils getDataPage(Map<String, Object> params){
        Page<MallArticalList> page = new PageUtils<MallArticalList>(params).getPage();
        IPage<MallArticalList> iPage = this.baseMapper.selectDataPage(page, params);
        return new PageUtils<MallArticalList>(iPage);
    }

    @Override
    public List<MallArticalList> selectAll() {
        return this.baseMapper.selectAll();
    }

    @Override
    public MallArticalFansLogExtends mallArticalDetail(Map<String, Object> params) {
        return this.baseMapper.mallArticalDetail(params);
    }

    @Override
    public boolean updateMallArticalByMallArtical(MallArticalList mallArticalList) {
        if (this.baseMapper.updateMallArticalByMallArtical(mallArticalList) > 0){
            return true;
        }
        return false;
    }


}
