package com.test.loans.model;

import lombok.Data;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;
	private String name;
	private String email;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "create_dt")
	private LocalDate createDt;

}