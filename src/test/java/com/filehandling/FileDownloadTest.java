package com.filehandling;

import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest

public class FileDownloadTest {

	
	@Test
    
	public void testDownload()
	{
		HttpHeaders headers = new HttpHeaders();
		
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:9090/download")
                .queryParam("file", "application.properties");
        HttpEntity<?> entity = new HttpEntity<>(headers);

  	  ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(), 
  	        HttpMethod.GET, 
  	        entity, 
  	        String.class);
  	  
  	
  System.out.println(response+"response");
	}
}
