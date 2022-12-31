package com.anchtun.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.loan.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

	List<Loan> findByCustomerIdOrderByStartOnDesc(Long customerId);
}
