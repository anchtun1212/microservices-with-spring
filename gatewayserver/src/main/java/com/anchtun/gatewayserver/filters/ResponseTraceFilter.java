package com.anchtun.gatewayserver.filters;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

//post-filter
@Configuration
@Slf4j
@AllArgsConstructor
public class ResponseTraceFilter {

	private final FilterUtility filterUtility;
	
	@Bean
	public GlobalFilter postGlobalFilter() {
		return (exchange, chain) -> {
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
				String correlationId = filterUtility.getCorrelationId(requestHeaders);
				log.debug("Updated the correlation id to the outbound headers. {}", correlationId);
				exchange.getResponse().getHeaders().add(filterUtility.CORRELATION_ID, correlationId);
			}));
		};
	}
}