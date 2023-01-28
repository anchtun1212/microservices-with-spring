package com.anchtun.account.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.anchtun.account.model.Customer;
import com.anchtun.account.model.Loan;

@FeignClient("loan")
public interface LoanFeignClient {
	
	@PostMapping(value = "myLoans", consumes = "application/json")
	List<Loan> getLoanDetails(@RequestBody Customer customer);

}
