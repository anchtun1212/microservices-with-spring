package com.anchtun.loan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.loan.model.Customer;
import com.anchtun.loan.model.Loan;
import com.anchtun.loan.service.LoanService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanController {

	private final LoanService loanService;
	
	@GetMapping("/myLoans")
	public List<Loan> getLoanDetails(@RequestBody Customer customer) {
		return loanService.getLoanDetails(customer);
	}
}
