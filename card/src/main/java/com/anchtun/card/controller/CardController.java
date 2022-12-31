package com.anchtun.card.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.card.model.Card;
import com.anchtun.card.model.Customer;
import com.anchtun.card.service.CardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CardController {
	
	private final CardService cardService;
	
	@GetMapping("/myCards")
	public List<Card> getCardDetails(@RequestBody Customer customer) {
		return cardService.getCardDetails(customer);
	}

}
