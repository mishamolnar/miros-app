package com.test.accounts.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {

	private Long cardId;

	private Long customerId;

	private String cardNumber;

	private String cardType;

	private Long totalLimit;

	private Long amountUsed;

	private Long availableAmount;

	private Date createDt;

}