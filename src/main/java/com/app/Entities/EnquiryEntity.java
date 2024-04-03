package com.app.Entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="enquirydtls")
@Data
public class EnquiryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer EnquiryId;
	
	private String name;
	
	private String contact;
	
	private String email;
	
	private String course;
	
	private String status;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@JoinColumn(name="consellorId")
	@ManyToOne
	private consellorsEntity consellor;

}
