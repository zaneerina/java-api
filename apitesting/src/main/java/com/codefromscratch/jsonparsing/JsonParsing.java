package com.codefromscratch.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// this class will be used to process the parsing from json to java <-->
public class JsonParsing {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper () {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        // .. config ..
        return defaultObjectMapper;
    }

    // parse a string (a json string) into a json node:
    public static JsonNode parse (String source) throws IOException {
        return objectMapper.readTree(source);
    }

    // used to parse a POJO to json: <A> A means that we don't know which type it will be
    public static <A> A fromJson (JsonNode node, Class <A> aClass) throws JsonProcessingException {
        return objectMapper.treeToValue(node, aClass);
    }


}
