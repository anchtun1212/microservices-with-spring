package com.anchtun.loan.service;

import java.util.List;

import com.anchtun.loan.model.Customer;
import com.anchtun.loan.model.Loan;

public interface LoanService {

	List<Loan> getLoanDetails(Customer customer);

}
