package com.anchtun.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anchtun.account.feign.CardFeignClient;
import com.anchtun.account.feign.LoanFeignClient;
import com.anchtun.account.model.Account;
import com.anchtun.account.model.Card;
import com.anchtun.account.model.Customer;
import com.anchtun.account.model.CustomerDetails;
import com.anchtun.account.model.Loan;
import com.anchtun.account.repository.AccountRepository;
import com.anchtun.account.service.AccountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	private final CardFeignClient cardFeignClient;
	private final LoanFeignClient loanFeignClient;

	@Override
	public Account getAccountDetails(Customer customer) {
		return accountRepository.findByCustomerId(customer.getId());
	}

	@Override
	public CustomerDetails myCustomerDetails(Customer customer) {
		Account accounts = accountRepository.findByCustomerId(customer.getId());
		List<Loan> loans = loanFeignClient.getLoanDetails(customer);
		List<Card> cards = cardFeignClient.getCardDetails(customer);

		CustomerDetails customerDetails = CustomerDetails.builder().accounts(accounts).loans(loans).cards(cards).build();

		return customerDetails;
	}

	@Override
	public CustomerDetails myCustomerDetailsFallback(Customer customer, Throwable t) {
		Account accounts = accountRepository.findByCustomerId(customer.getId());
		List<Loan> loans = null;
		List<Card> cards = null;
		try {
			loans = loanFeignClient.getLoanDetails(customer);
		} catch (Exception e) {
		}
		try {
			cards = cardFeignClient.getCardDetails(customer);
		} catch (Exception e) {
		}

		CustomerDetails customerDetails = CustomerDetails.builder().accounts(accounts).loans(loans).cards(cards).build();

		return customerDetails;
	}

}
