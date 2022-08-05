package com.test.cards.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

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