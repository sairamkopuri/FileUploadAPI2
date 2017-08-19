package com.filehandling.restapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filehandling.model.FileMetaDataEntity;
import com.filehandling.service.IFileMetaDataService;

@RestController
public class GetFileMetaDataAPI {

	@Autowired
	 public IFileMetaDataService fileService;
	@GetMapping("/getMetaData")
	public ResponseEntity<FileMetaDataEntity> getFileMetaData(@RequestParam("fileName") String fileName)
	{
		FileMetaDataEntity fileEntity = new FileMetaDataEntity();
		fileEntity = fileService.getFileDataByFileName(fileName);
		return new ResponseEntity(fileEntity,HttpStatus.OK);
	}
}
