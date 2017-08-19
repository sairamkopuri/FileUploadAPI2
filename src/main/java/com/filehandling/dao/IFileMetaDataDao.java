package com.filehandling.dao;

import java.io.Serializable;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.filehandling.model.FileMetaDataEntity;


@Transactional
@Repository
public interface IFileMetaDataDao extends JpaRepository<FileMetaDataEntity, Serializable>,JpaSpecificationExecutor<FileMetaDataEntity>
{
	@Query("select adc from #{#entityName} adc where adc.fileName=?1")
	FileMetaDataEntity getFileDataByFileName(String fileName);
}