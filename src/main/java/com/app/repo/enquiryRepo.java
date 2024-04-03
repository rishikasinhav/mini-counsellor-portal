package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.Entities.EnquiryEntity;

public interface enquiryRepo extends JpaRepository<EnquiryEntity, Integer> {

	@Query()
	public long getEnquiries(Integer cousellorId);
	
	public long getEnquiry(Integer EnquiryId, String status );
	
	
	public List<EnquiryEntity> getEnquiry(Integer consellorId);
	
}
