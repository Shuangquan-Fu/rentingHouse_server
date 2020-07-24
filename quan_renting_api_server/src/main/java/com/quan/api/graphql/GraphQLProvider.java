package com.quan.api.graphql;

import com.quan.api.service.HouseResourcesService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    private List<MydataFetcher> mydataFetchers;

    @Autowired
    private HouseResourcesService houseResourcesService;

    //对象初始化
    @PostConstruct
    public void init() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:house.graphqls");
        this.graphQL = GraphQL.newGraphQL(buildGraphQLSchema(file)).build();
    }

    private GraphQLSchema buildGraphQLSchema(File file){
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(file);
        RuntimeWiring runtimeWiring = buildWiring();
        return new SchemaGenerator().makeExecutableSchema(typeRegistry,runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("QuanQuery", builder -> {
                    for (MydataFetcher myDataFetcher : mydataFetchers) {
                        builder.dataFetcher(myDataFetcher.fieldName(),
                                environment ->
                                        myDataFetcher.dataFetcher(environment));
                    }
                    return builder;
                })
                .build();
    }
    @Bean
    public GraphQL graphQL(){
        return this.graphQL;
    }
}
