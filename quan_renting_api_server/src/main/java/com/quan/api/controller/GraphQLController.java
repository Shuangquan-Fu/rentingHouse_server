package com.quan.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RequestMapping("graphql")
@Controller
@CrossOrigin
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    private static final ObjectMapper MAPPER = new ObjectMapper();
    @GetMapping
    @ResponseBody
    public Map<String, Object> graphql(@RequestParam("query") String query) throws
            IOException {
        return this.graphQL.execute(query).toSpecification();
    }
    @PostMapping
    @ResponseBody
    public Map<String, Object> postGraphql(@RequestBody String json) throws
            IOException {
        JsonNode jsonNode = MAPPER.readTree(json);
        if(jsonNode.has("query")){
            String query = jsonNode.get("query").asText();
            return this.graphQL.execute(query).toSpecification();
        }
        return null;
    }
//    @PostMapping
//    @ResponseBody
//    public Map<String, Object> postGraphql(@RequestBody String json) throws IOException, IOException {
//        JsonNode jsonNode = MAPPER.readTree(json);
//        if(jsonNode.has("query")){
//            String query = jsonNode.get("query").asText();
//            return this.graphQL.execute(query).toSpecification();
//        }
//        return null;
//    }

}
