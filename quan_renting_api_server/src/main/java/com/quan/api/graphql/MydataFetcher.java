package com.quan.api.graphql;

import graphql.schema.DataFetchingEnvironment;

public interface MydataFetcher {

    String fieldName();

    Object dataFetcher(DataFetchingEnvironment environment);
}
