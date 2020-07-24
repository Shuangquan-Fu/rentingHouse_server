package com.quan.api;

import com.quan.pojo.HouseResources;
import com.quan.pojo.PageInfo;

public interface ApiHouseResourcesService {
    int saveHouseResources(HouseResources houseResources);
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition);
    public HouseResources queryHouseResourcesById(Long id);
}
