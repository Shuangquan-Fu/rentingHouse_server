package com.quan.service.impl;

import com.quan.pojo.HouseResources;
import com.quan.service.BaseService;
import com.quan.service.HouseResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HouseResourcesServiceImpl extends BaseService<HouseResources> implements HouseResourcesService {
    @Override
    public int saveHouseResources(HouseResources houseResources) {
        // 编写校验逻辑，如果教研不通过，返回-1
        if (StringUtils.isBlank(houseResources.getTitle())) {
            return -1;
        }
// 其他校验以及逻辑省略 ……
        return super.save(houseResources);
    }
}
