package com.filehandling.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.filehandling.model.FileMetaDataEntity;
import com.filehandling.model.FileMetaDataEntity_;


public class FileSearchSpec implements Specification<FileMetaDataEntity>{
	private final FileMetaDataEntity fileMetaDataEntity;

	  public FileSearchSpec(FileMetaDataEntity fileMetaDataEntity) {
	    this.fileMetaDataEntity = fileMetaDataEntity;
	  }
		@Override
	public Predicate toPredicate(Root<FileMetaDataEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
		
			// TODO Auto-generated method stub
			List<Predicate> predicates = new ArrayList<>();

		    if (null !=fileMetaDataEntity.getMetaDataId()) {
		     // predicates.add(cb.like(cb.lower(root.get(AdCamp_.adContent)), adcamp.getAdContent().toLowerCase() + "%"));
		    	predicates.add(cb.and(cb.equal(root.get(FileMetaDataEntity_.metaDataId), fileMetaDataEntity.getMetaDataId())));
		    }

		    if (null!=fileMetaDataEntity.getFileName()) {
		    	predicates.add(cb.and(cb.equal(root.get(FileMetaDataEntity_.fileName), fileMetaDataEntity.getFileName().toLowerCase())));
		    }

		    if (null != fileMetaDataEntity.getSize()) {
		      predicates.add(cb.equal(root.get(FileMetaDataEntity_.size), fileMetaDataEntity.getSize()));
		    }
		    return andTogether(predicates, cb);
		  }

		  private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
		    return cb.and(predicates.toArray(new Predicate[0]));
		  }
			
	}
