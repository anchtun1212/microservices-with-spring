package com.anchtun.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.account.model.Account;
import com.anchtun.account.model.Customer;
import com.anchtun.account.service.AccountService;
import com.anchtun.account.service.mapper.CommonMapperService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AccountController {
	
	private final AccountService accountService;
	private final CommonMapperService commonMapperService;

	@GetMapping("/myAccount")
	public Account getAccountDetails(@RequestBody Customer customer) {
		return accountService.getAccountDetails(customer);
	}
	
	@GetMapping("/account/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		return commonMapperService.accountMapper();
	}
}
