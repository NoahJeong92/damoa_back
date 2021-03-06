package com.second.damoa;

import com.second.damoa.social.config.AppProperties;
import com.second.damoa.social.config.ClientProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {AppProperties.class, ClientProperties.class})
public class DamoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamoaApplication.class, args);
	}


}
