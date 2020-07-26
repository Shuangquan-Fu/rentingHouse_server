package com.quan.api;


import com.alibaba.dubbo.config.annotation.Service;
import com.quan.pojo.HouseResources;
import com.quan.pojo.PageInfo;
import com.quan.service.HouseResourcesService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class ApiHouseResourcesServiceImpl implements ApiHouseResourcesService{

    @Autowired
    private HouseResourcesService houseResourcesService;

    public int saveHouseResources(HouseResources houseResources) {
        return this.houseResourcesService.saveHouseResources(houseResources);
    }

    @Override
    public boolean updateHouseResources(HouseResources houseResources) {
        return this.houseResourcesService.updateHouseResources(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
       return houseResourcesService.queryHouseResourcesList(page,pageSize,queryCondition);
    }

    public HouseResources queryHouseResourcesById(Long id) {
        return this.houseResourcesService.queryHouseResourcesById(id);
    }

}
