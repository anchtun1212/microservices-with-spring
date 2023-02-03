package com.anchtun.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.account.model.Account;
import com.anchtun.account.model.Customer;
import com.anchtun.account.model.CustomerDetails;
import com.anchtun.account.service.AccountService;
import com.anchtun.account.service.mapper.CommonMapperService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import static com.anchtun.account.constants.Constants.CORRELATION_ID;

@AllArgsConstructor
@RestController
public class AccountController {
	
	private final AccountService accountService;
	private final CommonMapperService commonMapperService;

	@PostMapping("/myAccount")
	public Account getAccountDetails(@RequestBody Customer customer) {
		return accountService.getAccountDetails(customer);
	}
	
	@GetMapping("/account/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		return commonMapperService.accountMapper();
	}
	
	@PostMapping("/myCustomerDetails")
	//@CircuitBreaker(name = "detailsForCustomerSupportApp", fallbackMethod = "myCustomerDetailsFallback")
	@Retry(name = "retryDetailsForCustomer", fallbackMethod = "myCustomerDetailsFallback")
	public CustomerDetails myCustomerDetails(@RequestHeader(CORRELATION_ID) String correlationId, @RequestBody Customer customer) {
		return accountService.myCustomerDetails(correlationId, customer);
	}
	
	private CustomerDetails myCustomerDetailsFallback(@RequestHeader(CORRELATION_ID) String correlationId, Customer customer, Throwable t) {
		return accountService.myCustomerDetailsFallback(correlationId, customer, t);
	}
	
	@GetMapping("/sayHello")
	@RateLimiter(name = "sayHello", fallbackMethod = "sayHelloFallback")
	public String sayHello() {
		return "Hello, Welcome to AnchtunBank";
	}

	private String sayHelloFallback(Throwable t) {
		return "Hi, Welcome to AnchtunBank";
	}
}
