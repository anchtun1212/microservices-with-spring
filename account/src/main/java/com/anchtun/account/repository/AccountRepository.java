package com.anchtun.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anchtun.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Account findByCustomerId(Long customerId);
}
