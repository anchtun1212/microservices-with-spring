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
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	private final CardFeignClient cardFeignClient;
	private final LoanFeignClient loanFeignClient;

	@Override
	public Account getAccountDetails(Customer customer) {
		return accountRepository.findByCustomerId(customer.getId());
	}

	@Override
	public CustomerDetails myCustomerDetails(String correlationId, Customer customer) {
		log.info("myCustomerDetails Start");
		Account accounts = accountRepository.findByCustomerId(customer.getId());
		List<Loan> loans = loanFeignClient.getLoanDetails(correlationId, customer);
		List<Card> cards = cardFeignClient.getCardDetails(correlationId, customer);

		CustomerDetails customerDetails = CustomerDetails.builder().accounts(accounts).loans(loans).cards(cards).build();
		log.info("myCustomerDetails End");
		return customerDetails;
	}

	@Override
	public CustomerDetails myCustomerDetailsFallback(String correlationId, Customer customer, Throwable t) {
		Account accounts = accountRepository.findByCustomerId(customer.getId());
		List<Loan> loans = null;
		List<Card> cards = null;
		try {
			loans = loanFeignClient.getLoanDetails(correlationId, customer);
		} catch (Exception e) {
		}
		try {
			cards = cardFeignClient.getCardDetails(correlationId, customer);
		} catch (Exception e) {
		}

		CustomerDetails customerDetails = CustomerDetails.builder().accounts(accounts).loans(loans).cards(cards).build();

		return customerDetails;
	}

}
