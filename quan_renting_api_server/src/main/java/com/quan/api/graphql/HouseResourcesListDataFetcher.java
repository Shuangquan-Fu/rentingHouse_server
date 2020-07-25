package com.quan.api.graphql;

import com.quan.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseResourcesListDataFetcher implements MydataFetcher {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public String fieldName() {
        return "HouseResourcesList";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        Integer page = environment.getArgument("page");
        if(page == null){
            page =1;
        }
        Integer pageSize = environment.getArgument("pageSize");
        if(pageSize == null){
            pageSize = 5;
        }
        return this.houseResourcesService.queryList(null,page,pageSize);
    }
}
