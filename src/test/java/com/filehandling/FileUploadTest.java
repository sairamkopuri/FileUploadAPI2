package com.filehandling;

import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileUploadTest {
	
	@Test // success fully uploading file
	public void testFileUpload()
	{
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		parameters.add("file", new ClassPathResource("application.properties"));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "multipart/form-data");
		headers.set("Accept", "text/plain");

		String result = restTemplate.postForObject(
		    "http://localhost:9090/api/upload", 
		    new HttpEntity<MultiValueMap<String, Object>>(parameters, headers), 
		    String.class);
		System.out.println(result);
		
	}
	
	@Ignore
	
	public void testEmptyFileUpload()
	{
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		parameters.add("file", new ClassPathResource("app.properties"));

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "multipart/form-data");
		headers.set("Accept", "text/plain");

		String result = restTemplate.postForObject(
		    "http://localhost:9090/api/upload", 
		    new HttpEntity<MultiValueMap<String, Object>>(parameters, headers), 
		    String.class);
		System.out.println(result);
	}

}
