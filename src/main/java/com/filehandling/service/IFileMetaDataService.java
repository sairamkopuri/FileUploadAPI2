package com.filehandling.service;

import java.util.List;

import com.filehandling.model.FileMetaDataEntity;


public interface IFileMetaDataService {
	List<FileMetaDataEntity> getAllFiles();
	FileMetaDataEntity getFileDataByFileName(String fileName);
    boolean addFileData(FileMetaDataEntity fileEntity);
    void updateFileData(FileMetaDataEntity fileEntity);
    void deleteFileData(Long id);
    List<FileMetaDataEntity> searchCampaign(FileMetaDataEntity fileEntity);
}
