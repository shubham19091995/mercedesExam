package com.mercedes.mercedes.controller;
import java.net.URL;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercedes.mercedes.Model.Input;
import com.mercedes.mercedes.Util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mercedes.mercedes.Config.s3bucketFiles;
import org.springframework.web.client.RestTemplate;

@RestController
// we can use v2 mapping from Request Mapping but since we have only two endpoints, so I am using in GetMapping only .
public class mercedesTest {



    @Autowired
    public ApplicationUtil applicationUtil;

    @Autowired
    public s3bucketFiles s3bucketFiles;

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/minimumRequirement")
    public HashMap<String,Integer> getMinimumRequirement(@RequestBody(required = true) Object input) {

        List<Input> data= ApplicationUtil.inputConverter(input);

         return  applicationUtil.getOutput(data);
    }

    @GetMapping("/v2/advance")
    public void  getAdvance(){
        int testcase=1;
        HashMap<String,String> hosts=s3bucketFiles.getHosts();
        List<Input> data= new ArrayList<>();
        for(String hostUrls:hosts.values()){
            try {
                URL url = new URL(hostUrls);

                ObjectMapper objectMapper = new ObjectMapper();
                Object jsonString = objectMapper.readValue(url, Object.class);
               data = ApplicationUtil.inputConverter(jsonString);


            } catch (Exception e) {
                e.printStackTrace();
            }

            applicationUtil.postCallForOuterApiTest(applicationUtil.getOutput(data),testcase);
       }



    }
}
