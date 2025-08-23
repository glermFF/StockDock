package ufop.edu.web.stockdock.Gateway.config;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayApiConfig {
    
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
        .route("investments", p -> p .path("/investments_wallet/**").uri("lb://investments-service"))
        .route("investments", p -> p .path("/investments_asset/**").uri("lb://investments-service")).build();
    }
}
