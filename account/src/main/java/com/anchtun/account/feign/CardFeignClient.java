package com.anchtun.account.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.anchtun.account.model.Card;
import com.anchtun.account.model.Customer;

@FeignClient("card")
public interface CardFeignClient {

	@PostMapping(value = "myCards", consumes = "application/json")
	List<Card> getCardDetails(@RequestBody Customer customer);
}
