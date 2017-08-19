package com.filehandling.restapi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.filehandling.model.FileMetaDataEntity;
import com.filehandling.service.IFileMetaDataService;
import com.filehandling.service.IStorageService;

@RestController
public class FileUploadAPI {
	 public IStorageService storageService;
	 @Autowired
	 public IFileMetaDataService fileService;
	 @Autowired
	    public FileUploadAPI(IStorageService storageService) {
	        this.storageService = storageService;
	    }
	@PostMapping("/api/upload")
	@ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<?> fileUpload( @RequestParam("file") MultipartFile file) throws IOException {
		if (file.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }
		storageService.store(file);
		Path file1=storageService.load(file.getOriginalFilename());
		BasicFileAttributes attr = Files.readAttributes(file1, BasicFileAttributes.class);
				FileMetaDataEntity fileMetaDataEntity=new FileMetaDataEntity(attr.size(), file.getOriginalFilename(), attr.creationTime().toString(), attr.lastAccessTime().toString(), attr.lastModifiedTime().toString());
		fileService.addFileData(fileMetaDataEntity);
        return new ResponseEntity("Successfully uploaded - " + file.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);


    }
}

