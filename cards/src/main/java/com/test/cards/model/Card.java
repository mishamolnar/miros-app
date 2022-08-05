package com.test.cards.model;

import java.sql.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_id")
	private Long cardId;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "total_limit")
	private Long totalLimit;

	@Column(name = "amount_used")
	private Long amountUsed;

	@Column(name = "available_amount")
	private Long availableAmount;

	@Column(name = "create_dt")
	private Date createDt;

}