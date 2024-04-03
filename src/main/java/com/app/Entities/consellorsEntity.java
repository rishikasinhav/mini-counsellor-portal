package com.app.Entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "consellordtls")
@Data
public class consellorsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer consellorId;

	private String name;

	private String email;

	private String password;

	private long contact;

	@CreationTimestamp
	private LocalDate createdDate;

	@UpdateTimestamp
	private LocalDate updatedDate;

	@OneToMany(mappedBy = "consellor", cascade = CascadeType.ALL)
	private List<EnquiryEntity> Enquiry;

	

}
