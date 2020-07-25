package com.quan.api.graphql;

import com.quan.api.entity.IndexAdResult;
import com.quan.api.entity.IndexAdResultData;
import com.quan.api.service.AdService;
import com.quan.pojo.Ad;
import com.quan.pojo.PageInfo;
import graphql.schema.DataFetchingEnvironment;
import org.apache.jute.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class IndexAdDataFetcher implements MydataFetcher {

    @Autowired
    private AdService adService;

    @Override
    public String fieldName() {
        return "IndexAdList";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        PageInfo<Ad> pageInfo = adService.queryAdList(1,1,3);
        List<Ad>  ads = pageInfo.getRecords();
        List<IndexAdResultData> list = new ArrayList<>();
        for (Ad ad : ads) {
            list.add(new IndexAdResultData(ad.getUrl()));
        }
        IndexAdResult indexAdResult = new IndexAdResult(list);
        return indexAdResult;
    }
}
