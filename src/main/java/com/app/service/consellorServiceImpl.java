package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.consellorsEntity;
import com.app.repo.counsellorRepo;


@Service
public class consellorServiceImpl implements consellorService {

	@Autowired
	public counsellorRepo c_repo;
	
	//public consellorsEntity c_entity;
	
	
	@Override
	public consellorsEntity loginConsellor(String email, String password) {
		// TODO Auto-generated method stub
		
		return c_repo.findByEmailAndPwd(email, password);
	}
	
	

	@Override
	public boolean saveConsellor(consellorsEntity consellor) {
		 
		 	
		 	if(c_repo.FindByEmail(consellor.getEmail())!=null)
		 	{
		 		return false;
		 	}
		 	else
		 	{
		 		consellorsEntity saveConsellor = c_repo.save(consellor);
				return saveConsellor.getConsellorId()!=null;
		 	}
		 
	}

	
}
