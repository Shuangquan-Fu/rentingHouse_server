package com.quan.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.quan.api.ApiHouseResourcesService;
import com.quan.api.entity.Pagination;
import com.quan.api.entity.TableResult;
import com.quan.pojo.HouseResources;
import com.quan.pojo.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class HouseResourcesService {
    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResources houseResources){
        int result = this.apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
    }

    public TableResult queryList(HouseResources houseResources, Integer currentPage, Integer pageSize) {
        PageInfo<HouseResources> pageInfo = this.apiHouseResourcesService.queryHouseResourcesList(currentPage, pageSize, houseResources);
        return new TableResult(pageInfo.getRecords(), new Pagination(currentPage, pageSize, pageInfo.getTotal()));
    }

    public HouseResources queryById(Long id){
        return apiHouseResourcesService.queryHouseResourcesById(id);
    }

    public boolean update(HouseResources houseResources) {
        return this.apiHouseResourcesService.updateHouseResources(houseResources);
    }
}
