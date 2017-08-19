package com.filehandling;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.filehandling.service.IStorageService;

@SpringBootApplication
public class FileHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileHandlingApplication.class, args);
	}
	
	/* @Bean
	    CommonsMultipartResolver multipartResolver(){
	        return new CommonsMultipartResolver();
	    }*/
	/* @Bean
	    CommandLineRunner init(IStorageService storageService) {
	        return (args) -> {
	            storageService.deleteAll();
	            storageService.init();
	        };
	    }*/
}
