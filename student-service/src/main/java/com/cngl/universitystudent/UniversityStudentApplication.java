package com.cngl.universitystudent;

import com.cngl.universitystudent.client.UniversityClient;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversityStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityStudentApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	
	@Bean
	public UniversityClient getUniversityClient(){
		return Feign.builder()
        		.client(new OkHttpClient())
        		.encoder(new GsonEncoder())
        		.decoder(new GsonDecoder())
        		.target(UniversityClient.class, "http://localhost:8056/universities");
	}
}
