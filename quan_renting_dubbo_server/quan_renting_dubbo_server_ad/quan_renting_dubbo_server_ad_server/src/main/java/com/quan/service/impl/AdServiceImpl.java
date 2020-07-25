package com.quan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quan.pojo.Ad;
import com.quan.pojo.PageInfo;
import com.quan.service.AdService;
import com.quan.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl extends BaseService<Ad> implements AdService {
    @Override
    public PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize) {
        IPage<Ad> iPage = super.queryPageListByWhere(ad, page, pageSize);
        return new PageInfo(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());
    }
}
