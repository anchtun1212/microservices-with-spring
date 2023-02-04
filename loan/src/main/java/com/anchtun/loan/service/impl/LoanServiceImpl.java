package com.anchtun.loan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anchtun.loan.model.Customer;
import com.anchtun.loan.model.Loan;
import com.anchtun.loan.repository.LoanRepository;
import com.anchtun.loan.service.LoanService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class LoanServiceImpl implements LoanService {
	
	private final LoanRepository loanRepository;

	@Override
	public List<Loan> getLoanDetails(Customer customer) {
		log.info("getLoanDetails Start");
		List<Loan> result = loanRepository.findByCustomerIdOrderByStartOnDesc(customer.getId());
		log.info("getLoanDetails End");
		return result;
	}

}
