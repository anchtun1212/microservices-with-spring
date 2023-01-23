package com.anchtun.card.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anchtun.card.config.CardServiceConfig;
import com.anchtun.card.model.Properties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.annotation.PostConstruct;

@Service
public class CommonMapperService {
	
	@Autowired
	private CardServiceConfig cardConfig;
	
	private ObjectWriter ow;
	
	@PostConstruct
	public void init() {
		ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	}

	public String cardMapper() throws JsonProcessingException {
		Properties properties = Properties.builder()
										.msg(cardConfig.getMsg())
										.buildVersion(cardConfig.getBuildVersion())
										.mailDetails(cardConfig.getMailDetails())
										.activeBranches(cardConfig.getActiveBranches())
										.build();
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}
}
