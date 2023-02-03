package com.anchtun.account.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.anchtun.account.model.Card;
import com.anchtun.account.model.Customer;
import static com.anchtun.account.constants.Constants.CORRELATION_ID;

@FeignClient("card")
public interface CardFeignClient {

	@PostMapping(value = "myCards", consumes = "application/json")
	List<Card> getCardDetails(@RequestHeader(CORRELATION_ID) String correlationId, @RequestBody Customer customer);
}
