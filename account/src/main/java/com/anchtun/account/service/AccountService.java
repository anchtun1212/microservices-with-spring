package com.anchtun.account.service;

import com.anchtun.account.model.Account;
import com.anchtun.account.model.Customer;

public interface AccountService {

	Account getAccountDetails(Customer customer);

}
