package com.anchtun.loan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anchtun.loan.model.Customer;
import com.anchtun.loan.model.Loan;
import com.anchtun.loan.repository.LoanRepository;
import com.anchtun.loan.service.LoanService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {
	
	private final LoanRepository loanRepository;

	@Override
	public List<Loan> getLoanDetails(Customer customer) {
		return loanRepository.findByCustomerIdOrderByStartOnDesc(customer.getId());
	}

}
