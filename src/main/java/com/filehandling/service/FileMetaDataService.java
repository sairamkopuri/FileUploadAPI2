package com.filehandling.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.filehandling.dao.FileSearchSpec;
import com.filehandling.dao.IFileMetaDataDao;
import com.filehandling.model.FileMetaDataEntity;
@Service
@Transactional
public class FileMetaDataService implements IFileMetaDataService{

	@Autowired
	private IFileMetaDataDao fileMetaDataDao;
	@Override
	public List<FileMetaDataEntity> getAllFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileMetaDataEntity getFileDataByFileName(String fileName) {
		// TODO Auto-generated method stub
		return fileMetaDataDao.getFileDataByFileName(fileName);
	}

	@Override
	public boolean addFileData(FileMetaDataEntity fileMetaData) {
		fileMetaDataDao.save(fileMetaData);
		return true;
	}

	@Override
	public void updateFileData(FileMetaDataEntity userInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFileData(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FileMetaDataEntity> searchCampaign(FileMetaDataEntity fileEntity) {
		FileSearchSpec fileSearchSpec = new FileSearchSpec(fileEntity);
		List<FileMetaDataEntity> campaigns = fileMetaDataDao.findAll(fileSearchSpec);
		return campaigns;
	}

}
