package com.anchtun.account.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Account {

	@Id
	@Column(name="account_number")
	private Long accountNumber;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name = "branch_address")
	private String branchAddress;
	
	@Column(name = "create_on")
	private LocalDate createOn;
	
}
