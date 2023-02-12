package com.codefromscratch.jsonparsing;

import com.codefromscratch.jsonparsing.pojos.SimpleTestCaseJsonPOJO;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class JsonParsingTest {
    private String simpleTestCaseJsonSource = "{\"title\": \"Parsed text test\" }";
    @Test
    void parse () throws IOException {
        JsonNode node = JsonParsing.parse(simpleTestCaseJsonSource);
//        System.out.println(node.get("title").asText());
        assertEquals(node.get("title").asText(),"Parsed text test");
    }

    @Test
    void fromJson () throws IOException {
        JsonNode node = JsonParsing.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPOJO pojo = JsonParsing.fromJson(node, SimpleTestCaseJsonPOJO.class);
//        System.out.println("pojo title:" + pojo.title);
        assertEquals(pojo.getTitle(), "Parsed text test");
    }

}