package com.anchtun.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.account.model.Account;
import com.anchtun.account.model.Customer;
import com.anchtun.account.service.AccountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AccountController {
	
	private final AccountService accountService;

	@GetMapping("/myAccount")
	public Account getAccountDetails(@RequestBody Customer customer) {
		return accountService.getAccountDetails(customer);
	}
}
