package com.quan.api;


import com.alibaba.dubbo.config.annotation.Service;
import com.quan.pojo.HouseResources;
import com.quan.service.HouseResourcesService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class ApiHouseResourcesServiceImpl implements ApiHouseResourcesService{

    @Autowired
    private HouseResourcesService houseResourcesService;

    public int saveHouseResources(HouseResources houseResources) {
        return this.houseResourcesService.saveHouseResources(houseResources);
    }
}
