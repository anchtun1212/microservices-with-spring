package com.anchtun.card.controller;

import static com.anchtun.card.constants.Constants.CORRELATION_ID;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.anchtun.card.model.Card;
import com.anchtun.card.model.Customer;
import com.anchtun.card.service.CardService;
import com.anchtun.card.service.mapper.CommonMapperService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CardController {
	
	private final CardService cardService;
	private final CommonMapperService commonMapperService;
	
	@PostMapping("/myCards")
	public List<Card> getCardDetails(@RequestHeader(CORRELATION_ID) String correlationId, @RequestBody Customer customer) {
		return cardService.getCardDetails(customer);
	}
	
	@GetMapping("/card/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		return commonMapperService.cardMapper();
	}

}
