package com.mercedes.mercedes.Config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "files.urls")
public class s3bucketFiles {

    HashMap<String,String> hosts;

    public s3bucketFiles(HashMap<String,String> hosts) {
        this.hosts = hosts;
    }

    public HashMap<String,String > getHosts() {
        return hosts;
    }

    public void setHosts(HashMap<String,String> hosts) {
        this.hosts = hosts;
    }

    public s3bucketFiles() {
    }


}
