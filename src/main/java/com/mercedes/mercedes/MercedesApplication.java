package com.mercedes.mercedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class MercedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercedesApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}

}
