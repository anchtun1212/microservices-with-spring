package com.anchtun.account.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anchtun.account.config.AccountServiceConfig;
import com.anchtun.account.model.Properties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.annotation.PostConstruct;

@Service
public class CommonMapperService {
	
	@Autowired
	private AccountServiceConfig accountConfig;
	
	private ObjectWriter ow;
	
	@PostConstruct
	public void init() {
		ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	}

	public String accountMapper() throws JsonProcessingException {
		Properties properties = Properties.builder()
										.msg(accountConfig.getMsg())
										.buildVersion(accountConfig.getBuildVersion())
										.mailDetails(accountConfig.getMailDetails())
										.activeBranches(accountConfig.getActiveBranches())
										.build();
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}
}
