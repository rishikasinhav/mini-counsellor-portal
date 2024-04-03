package com.app.service;

import org.springframework.stereotype.Service;

import com.app.Entities.consellorsEntity;


public interface consellorService {

	//login 
	public consellorsEntity loginConsellor(String email, String password);
	
	//registration
	public boolean saveConsellor(consellorsEntity consellor);
}
