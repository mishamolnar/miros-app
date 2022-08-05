package com.test.accounts.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Loan {

	private Long loanNumber;

	private Long customerId;

	private Date startDt;

	private String loanType;

	private Long totalLoan;

	private Long amountPaid;

	private Long outstandingAmount;

	private String createDt;

}