package com.anchtun.card.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anchtun.card.model.Card;
import com.anchtun.card.model.Customer;
import com.anchtun.card.repository.CardRepository;
import com.anchtun.card.service.CardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class CardServiceImpl implements CardService {
	
	private final CardRepository cardRepository;

	@Override
	public List<Card> getCardDetails(Customer customer) {
		log.info("getCardDetails Start");
		List<Card>  result = cardRepository.findByCustomerId(customer.getId());
		log.info("getCardDetails End");
		return result;
	}

}
