package com.mercedes.mercedes.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercedes.mercedes.Model.Input;
import com.mercedes.mercedes.service.mercedesExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ApplicationUtil {

    @Autowired
    private mercedesExamService mercedesExamService;

    @Autowired
    private RestTemplate restTemplate;
    public static List<Input> inputConverter(Object input){

        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> map = oMapper.convertValue(input, Map.class);
        List<Input> ab= new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();


        Object totalTestcases=map.get("Total Test Cases");

        map.values().forEach(c1-> {

            try {
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(c1);
                Input input1 = objectMapper.readValue(json, Input.class);
                ab.add(input1);

            } catch (JsonProcessingException e) {
            }
        });

        return ab;

    }


    public  HashMap<String,Integer> getOutput(List<Input> inputs){
        int test=1;
        HashMap<String,Integer> values= new HashMap<>();

        for(Input input:inputs){
            values.put(String.valueOf(test), mercedesExamService.getData(input));
            test++;
        }
        return values;

    }


    public void postCallForOuterApiTest(HashMap<String ,Integer> value, int testCase){
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
        map.add("email", "raj8754412846@gmail.com");
        map.add("password", "shubham");
        map.add("testCase",testCase);
        map.add("answerStr",value);
        MultiValueMap<String, Object> map1 = new LinkedMultiValueMap<String,Object>();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity requestBodyFormUrlEncoded = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
        ResponseEntity<Object> responseEntity = null;
        try {
           responseEntity= restTemplate.exchange("https://mercedes-hiring-2023.hackerearth.com/check",
                   HttpMethod.POST, requestBodyFormUrlEncoded, Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
