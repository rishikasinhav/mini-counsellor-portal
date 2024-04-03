package com.app.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.app.Entities.EnquiryEntity;

import com.app.dto.Dashboard;


public interface enquiryService  {
	
	//Add Enquiry
	public boolean addEnquiry(EnquiryEntity enqs, Integer consellorId );
	
	//fetch all enquiry dtls+filter based on consellorId
	public List<EnquiryEntity> getEnquiries(EnquiryEntity enqs,Integer consellorsId);
	
	//edit enquiry
	public EnquiryEntity getEnquiry(EnquiryEntity enquiryId);
	
	//fetch dashboard details
	public Dashboard getDashboardInfo(Integer consellorId);
}
