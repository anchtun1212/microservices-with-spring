package com.anchtun.account.service.impl;

import org.springframework.stereotype.Service;

import com.anchtun.account.model.Account;
import com.anchtun.account.model.Customer;
import com.anchtun.account.repository.AccountRepository;
import com.anchtun.account.service.AccountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository accountRepository;

	@Override
	public Account getAccountDetails(Customer customer) {
		return accountRepository.findByCustomerId(customer.getId());
	}

}
