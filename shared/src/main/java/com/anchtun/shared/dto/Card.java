package com.anchtun.shared.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
	private Long id;
	private Long customerId;
	private String number;
	private String type;
	private int totalLimit;
	private int amountUsed;
	private int availableAmount;
	private LocalDate createOn;
}
