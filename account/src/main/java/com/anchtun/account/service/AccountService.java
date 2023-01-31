package com.anchtun.account.service;

import com.anchtun.account.model.Account;
import com.anchtun.account.model.Customer;
import com.anchtun.account.model.CustomerDetails;

public interface AccountService {

	Account getAccountDetails(Customer customer);

	CustomerDetails myCustomerDetails(Customer customer);

	CustomerDetails myCustomerDetailsFallback(Customer customer, Throwable t);

}
