package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.Entities.EnquiryEntity;
import com.app.Entities.consellorsEntity;
import com.app.dto.Dashboard;
import com.app.repo.counsellorRepo;
import com.app.repo.enquiryRepo;

@Service
public class enquiryServiceImpl implements enquiryService {
	@Autowired
	public enquiryRepo E_repo;
	
	@Autowired
	private counsellorRepo c_repo;

	@Override
	public boolean addEnquiry(EnquiryEntity enqs, Integer counsellorId) {
		// TODO Auto-generated method stub
		
		consellorsEntity consellor = c_repo.findById(counsellorId).orElseThrow();
		enqs.setConsellor(consellor); // associiation with foreign key
		
		EnquiryEntity save = E_repo.save(enqs);
		
		return  save.getEnquiryId()!=null;
		
	}

	@Override
	public List<EnquiryEntity> getEnquiries(EnquiryEntity enqs, Integer consellorId) {
		// TODO Auto-generated method stub
	
		consellorsEntity consellor = c_repo.findById(consellorId).orElseThrow();
		enqs.setConsellor(consellor);
		
		Example<EnquiryEntity> of=Example.of(enqs);
		
		
		
		return E_repo.findAll(of);
	}

	@Override
	public EnquiryEntity getEnquiry(EnquiryEntity enquiry) {
		// TODO Auto-generated method stub
		
		
		
		return E_repo.findById(enquiry.getEnquiryId()).orElseThrow();
	}

	@Override
	public Dashboard getDashboardInfo(Integer consellorId) {
		// TODO Auto-generated method stub
		//EnquiryEntity entity = E_repo.findById(consellorId).orElseThrow();
		
		long totalEnquiry =E_repo.getEnquiries(consellorId);
		
		long openEnquiry=E_repo.getEnquiry(consellorId, "open");
		
		long enrolledEnquiry=E_repo.getEnquiry(consellorId, "enrolled");
		
		long lostEnquiry= E_repo.getEnquiry(consellorId, "lost");
		
		Dashboard d=new Dashboard();
		
		d.setEnrolledEnquiry(enrolledEnquiry);
		d.setLostEnquiry(lostEnquiry);
		d.setOpenEnquiry(openEnquiry);
		d.setTotalEnquiry(totalEnquiry);
		
		return d;
	}

	

}
