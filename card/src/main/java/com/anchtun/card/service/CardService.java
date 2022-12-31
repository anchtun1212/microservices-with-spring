package com.anchtun.card.service;

import java.util.List;

import com.anchtun.card.model.Card;
import com.anchtun.card.model.Customer;

public interface CardService {

	List<Card> getCardDetails(Customer customer);

}
