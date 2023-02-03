package com.anchtun.account.service;

import com.anchtun.account.model.Account;
import com.anchtun.account.model.Customer;
import com.anchtun.account.model.CustomerDetails;

public interface AccountService {

	Account getAccountDetails(Customer customer);

	CustomerDetails myCustomerDetails(String correlationId, Customer customer);

	CustomerDetails myCustomerDetailsFallback(String correlationId, Customer customer, Throwable t);

}
