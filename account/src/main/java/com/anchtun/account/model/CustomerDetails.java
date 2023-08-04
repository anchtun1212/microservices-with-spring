package com.anchtun.account.model;

import java.util.List;

import com.anchtun.shared.dto.Card;
import com.anchtun.shared.dto.Loan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerDetails {
	private Account accounts;
	private List<Loan> loans;
	private List<Card> cards;
}
