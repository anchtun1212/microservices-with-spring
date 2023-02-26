package com.anchtun.gatewayserver.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomRoutes {
	
	@Autowired
	private TokenRelayGatewayFilterFactory filterFactory;

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route(p -> p
	            .path("/anchtunbank/account/**")
	            .filters(f -> f.filters(filterFactory.apply())
	            			    .rewritePath("/anchtunbank/account/(?<segment>.*)","/${segment}")//replace the path: remove anchtunbank
	            				//.addResponseHeader("X-Response-Time", LocalDate.now().toString()))
	            			    .removeRequestHeader("Cookie"))
	            // lb: LoadBalancer
	            .uri("lb://ACCOUNT")).
	        route(p -> p
		            .path("/anchtunbank/loan/**")
		            .filters(f -> f.filters(filterFactory.apply())
		            		.rewritePath("/anchtunbank/loan/(?<segment>.*)","/${segment}")
		            		//.addResponseHeader("X-Response-Time", LocalDate.now().toString()))
		            		.removeRequestHeader("Cookie"))
		            .uri("lb://LOAN")).
	        route(p -> p
		            .path("/anchtunbank/card/**")
		            .filters(f -> f.filters(filterFactory.apply())
		            		.rewritePath("/anchtunbank/card/(?<segment>.*)","/${segment}")
		            		//.addResponseHeader("X-Response-Time", LocalDate.now().toString()))
		            		.removeRequestHeader("Cookie"))
		            .uri("lb://CARD")).build();
	}
}
