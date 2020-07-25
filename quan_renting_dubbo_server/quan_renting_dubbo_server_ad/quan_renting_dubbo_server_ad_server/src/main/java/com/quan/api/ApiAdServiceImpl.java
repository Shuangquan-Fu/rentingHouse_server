package com.quan.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.quan.pojo.Ad;
import com.quan.pojo.PageInfo;
import com.quan.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class ApiAdServiceImpl implements ApiAdService {

    @Autowired
    private AdService adService;

    @Override
    public PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize) {
        Ad ad = new Ad();
        ad.setType(type);
        return this.adService.queryAdList(ad,page,pageSize);
    }
}
