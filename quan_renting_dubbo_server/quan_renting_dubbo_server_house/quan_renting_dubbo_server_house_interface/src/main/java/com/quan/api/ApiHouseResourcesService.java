package com.quan.api;

import com.quan.pojo.HouseResources;
import com.quan.pojo.PageInfo;

public interface ApiHouseResourcesService {
    int saveHouseResources(HouseResources houseResources);
    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition);
    HouseResources queryHouseResourcesById(Long id);
    boolean updateHouseResources(HouseResources houseResources);
}
