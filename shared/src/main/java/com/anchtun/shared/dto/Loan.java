package com.anchtun.shared.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loan {
	private Long number;
	private Long customerId;
	private LocalDate startOn;
	private String type;
	private int totalLoan;
	private int amountPaid;
	private int outstandingAmount;
	private String createOn;
}
