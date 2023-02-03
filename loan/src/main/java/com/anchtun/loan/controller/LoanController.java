package com.anchtun.loan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.loan.model.Customer;
import com.anchtun.loan.model.Loan;
import com.anchtun.loan.service.LoanService;
import com.anchtun.loan.service.mapper.CommonMapperService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;
import static com.anchtun.loan.constants.Constants.CORRELATION_ID;

@RestController
@AllArgsConstructor
public class LoanController {

	private final LoanService loanService;
	private final CommonMapperService commonMapperService;
	
	@PostMapping("/myLoans")
	public List<Loan> getLoanDetails(@RequestHeader(CORRELATION_ID) String correlationId, @RequestBody Customer customer) {
		return loanService.getLoanDetails(customer);
	}
	
	@GetMapping("/loan/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		return commonMapperService.loanMapper();
	}
}
