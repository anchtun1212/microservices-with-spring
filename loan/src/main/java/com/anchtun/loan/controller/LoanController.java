package com.anchtun.loan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.loan.model.Customer;
import com.anchtun.loan.model.Loan;
import com.anchtun.loan.service.LoanService;
import com.anchtun.loan.service.mapper.CommonMapperService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoanController {

	private final LoanService loanService;
	private final CommonMapperService commonMapperService;
	
	@GetMapping("/myLoans")
	public List<Loan> getLoanDetails(@RequestBody Customer customer) {
		return loanService.getLoanDetails(customer);
	}
	
	@GetMapping("/loan/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		return commonMapperService.loanMapper();
	}
}
