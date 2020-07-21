package com.quan.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.quan.api.ApiHouseResourcesService;
import com.quan.pojo.HouseResources;
import org.springframework.stereotype.Service;

@Service
public class HouseResourcesService {
    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;
    public boolean save(HouseResources houseResources){
        int result = this.apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
    }
}
