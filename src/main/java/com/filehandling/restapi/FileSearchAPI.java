package com.filehandling.restapi;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filehandling.model.FileMetaDataEntity;
import com.filehandling.service.IFileMetaDataService;

@RestController
public class FileSearchAPI {
	@Autowired
	 public IFileMetaDataService fileService;
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes="application/json")
	
	public ResponseEntity<List<FileMetaDataEntity>> processAdCampaign(@RequestBody FileMetaDataEntity fileMetaDataEntity)
	{
		 List<FileMetaDataEntity>list=fileService.searchCampaign(fileMetaDataEntity);
		if(list.size()==0) {
			return new ResponseEntity<List<FileMetaDataEntity>>(list,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FileMetaDataEntity>>(list,HttpStatus.OK);
	}

}
