package com.quan.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.quan.api.ApiAdService;
import com.quan.api.entity.WebResult;
import com.quan.pojo.Ad;
import com.quan.pojo.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class AdService {

    @Reference(version = "1.0.0")
    private ApiAdService apiAdService;

    public PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize){
        PageInfo<Ad> adPageInfo = this.apiAdService.queryAdList(type,page,pageSize);
        return adPageInfo;
    }
}
