package com.quan.api.graphql;

import com.quan.api.entity.map.MapHouseDataResult;
import com.quan.api.entity.map.MapHouseXY;
import com.quan.api.service.MongoHouseService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapHouseDataFetcher implements MydataFetcher{
    @Autowired
    private MongoHouseService mongoHouseService;

    @Override
    public String fieldName() {
        return "MapHouseData";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        //mock data
        List<MapHouseXY> list = new ArrayList<>();
        Float lng = ((Double)environment.getArgument("lng")).floatValue();
        Float lat = ((Double)environment.getArgument("lat")).floatValue();
        Integer zoom = environment.getArgument("zoom");
        return this.mongoHouseService.queryHouseData(lng,lat,zoom);
//        list.add(new MapHouseXY(116.43244f,39.929986f));
//        list.add(new MapHouseXY(116.424355f,39.92982f));
//        list.add(new MapHouseXY(116.423349f,39.935214f));
//        list.add(new MapHouseXY(116.350444f,39.931645f));
//        list.add(new MapHouseXY(116.351684f,39.91867f));
//        list.add(new MapHouseXY(116.353983f,39.913855f));
//        list.add(new MapHouseXY(116.357253f,39.923152f));
//        list.add(new MapHouseXY(116.349168f,39.923152f));
//        list.add(new MapHouseXY(116.36232f,39.938339f));
//        list.add(new MapHouseXY(116.374249f,39.94625f));
//        list.add(new MapHouseXY(116.380178f,39.953053f));
    }
}
