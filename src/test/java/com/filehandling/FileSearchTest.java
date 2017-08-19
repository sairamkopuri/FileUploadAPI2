package com.filehandling;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileSearchTest {
	
	@Test
	public void testFileSearch() throws JSONException
	{
		JSONObject request = new JSONObject();
		request.put("fileName","pgadmin.log" );
		
	  HttpHeaders requestHeaders = new HttpHeaders();
	  requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	  HttpEntity<String> entity = new HttpEntity<String>(request.toString(),requestHeaders);
	  //Creating http entity object with request body and headers
	 RestTemplate restTemplate = new RestTemplate();
	  //Invoking the API
	  ResponseEntity<String> response = restTemplate.exchange("http://localhost:9090/search",HttpMethod.POST, entity, String.class);
System.out.println(response+"response");
	}
	@Ignore
	public void testSearch() throws JSONException
	{
		JSONObject request = new JSONObject();
		request.put("fileName","pgadmin" );
		
	  HttpHeaders requestHeaders = new HttpHeaders();
	  requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	  HttpEntity<String> entity = new HttpEntity<String>(request.toString(),requestHeaders);
	  RestTemplate restTemplate = new RestTemplate();
	  ResponseEntity<String> response = restTemplate.exchange("http://localhost:9090/search",HttpMethod.POST, entity, String.class);
System.out.println(response+"response");
	}
}
