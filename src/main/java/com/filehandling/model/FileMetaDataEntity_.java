package com.filehandling.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(FileMetaDataEntity.class)
public class FileMetaDataEntity_ {
	public static volatile SingularAttribute<FileMetaDataEntity, Long> metaDataId;
	  public static volatile SingularAttribute<FileMetaDataEntity, Long> size;
	  public static volatile SingularAttribute<FileMetaDataEntity, String> fileName;
	  public static volatile SingularAttribute<FileMetaDataEntity, String> creationTime;
	  public static volatile SingularAttribute<FileMetaDataEntity, String> lastAccessTime;
	  public static volatile SingularAttribute<FileMetaDataEntity, String> lastModifiedTime;
}
