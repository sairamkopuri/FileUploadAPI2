package com.filehandling.restapi;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filehandling.service.IStorageService;


@RestController
public class FileDownloadAPI {
	public IStorageService storageService;
	 @Autowired
	    public FileDownloadAPI(IStorageService storageService) {
	        this.storageService = storageService;
	    }
	@RequestMapping(path = "/download", method = RequestMethod.GET)
	public ResponseEntity<Resource> download(@RequestParam("file") String fileName) throws IOException {

		 HttpHeaders headers = new HttpHeaders();
	        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        headers.add("Pragma", "no-cache");
	        headers.add("Expires", "0");

	    Resource resource = storageService.loadAsResource(fileName);

	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(fileName.length())
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .body(resource);
	}

}
