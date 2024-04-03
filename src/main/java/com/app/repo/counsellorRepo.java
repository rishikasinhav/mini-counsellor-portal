package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.consellorsEntity;

public interface counsellorRepo extends JpaRepository<consellorsEntity, Integer> {

	public consellorsEntity findByEmailAndPwd(String email, String password);
	
	public consellorsEntity FindByEmail(String email);
}
