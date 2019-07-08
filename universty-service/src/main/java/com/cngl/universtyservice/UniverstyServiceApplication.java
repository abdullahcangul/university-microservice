package com.cngl.universtyservice;

import com.cngl.universtyservice.client.UniversityClient;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;

@SpringBootApplication
public class UniverstyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniverstyServiceApplication.class, args);
	
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
        		.target(UniversityClient.class, "https://gitlab.com/kodiasoft/intern/2019/snippets/1859421/raw");
	}

}
