package com.filehandling.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "FileMetaData") 
public class FileMetaDataEntity {
	public FileMetaDataEntity(Long size, String fileName, String creationTime, String lastAccessTime,
			String lastModifiedTime) {
		super();
		this.size = size;
		this.fileName = fileName;
		this.creationTime = creationTime;
		this.lastAccessTime = lastAccessTime;
		this.lastModifiedTime = lastModifiedTime;
	}
	
	 public FileMetaDataEntity() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private Long metaDataId;
	private Long size;
	public Long getMetaDataId() {
		return metaDataId;
	}
	public void setMetaDataId(Long metaDataId) {
		this.metaDataId = metaDataId;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(String lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public String getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	private String fileName;
	private String creationTime;
	private String lastAccessTime;
	private String lastModifiedTime;
}
