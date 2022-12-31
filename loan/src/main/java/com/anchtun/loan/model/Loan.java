package com.anchtun.loan.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long number;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "start_on")
	private LocalDate startOn;

	private String type;

	@Column(name = "total_loan")
	private int totalLoan;

	@Column(name = "amount_paid")
	private int amountPaid;

	@Column(name = "outstanding_amount")
	private int outstandingAmount;

	@Column(name = "create_on")
	private String createOn;
}
