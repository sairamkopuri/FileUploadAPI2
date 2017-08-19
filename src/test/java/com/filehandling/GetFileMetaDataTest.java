package com.filehandling;

import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetFileMetaDataTest {

	
	@Test
	public void testGetMetaData() throws JSONException
	{
HttpHeaders headers = new HttpHeaders();
		
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:9090/getMetaData")
                .queryParam("fileName", "pgadmin.log");
        HttpEntity<?> entity = new HttpEntity<>(headers);

  	  ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(), 
  	        HttpMethod.GET, 
  	        entity, 
  	        String.class);
  	  

		System.out.println(response);

	}
	
	@Ignore
	public void testGetMetaData1() throws JSONException
	{
HttpHeaders headers = new HttpHeaders();
		
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:9090/getMetaData")
                .queryParam("fileName", "pgadmin1.log");
        HttpEntity<?> entity = new HttpEntity<>(headers);

  	  ResponseEntity<String> response = restTemplate.exchange( builder.build().encode().toUri(), 
  	        HttpMethod.GET, 
  	        entity, 
  	        String.class);
  	  

		System.out.println(response);

	}
}
