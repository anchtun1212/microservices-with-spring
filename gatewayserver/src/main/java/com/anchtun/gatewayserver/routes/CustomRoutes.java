package com.anchtun.gatewayserver.routes;

import java.time.LocalDate;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRoutes {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route(p -> p
	            .path("/anchtunbank/account/**")
	            .filters(f -> f.rewritePath("/anchtunbank/account/(?<segment>.*)","/${segment}")//replace the path: remove anchtunbank
	            				.addResponseHeader("X-Response-Time", LocalDate.now().toString()))
	            .uri("lb://ACCOUNT")).
	        route(p -> p
		            .path("/anchtunbank/loan/**")
		            .filters(f -> f.rewritePath("/anchtunbank/loan/(?<segment>.*)","/${segment}")
		            		.addResponseHeader("X-Response-Time", LocalDate.now().toString()))
		            .uri("lb://LOAN")).
	        route(p -> p
		            .path("/anchtunbank/card/**")
		            .filters(f -> f.rewritePath("/anchtunbank/card/(?<segment>.*)","/${segment}")
		            		.addResponseHeader("X-Response-Time", LocalDate.now().toString()))
		            .uri("lb://CARD")).build();
	}
}
