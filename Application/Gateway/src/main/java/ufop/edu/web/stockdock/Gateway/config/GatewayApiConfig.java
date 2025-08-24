package ufop.edu.web.stockdock.Gateway.config;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayApiConfig {
    
    @Value("${gateway.frontend.uri}")
    private String uriFrontendService = "http://localhost:5173";

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        
        return builder.routes()
        .route("api-investments", 
            p -> p.path("/api/investments").or().method("GET").or().method("POST")
            .filters(f -> f.rewritePath("/api/investments", "/investments_wallet"))
            .uri("lb://investments-service")
        )
        .route("api-assets", 
            p -> p .path("/api/assets/").or().method("GET").or().method("POST")
            .filters(f -> f.rewritePath("/api/assets", "/investments_asset"))
            .uri("lb://investments-service")
        )
        .route("investments", p -> p 
            .path("/investments_wallet/**")
            .uri("lb://investments-service")
        )
        .route("investments", p -> p 
            .path("/investments_asset/**")
            .uri("lb://investments-service")
        )
        .route("frontend", p -> p 
            .path("/***")
            .uri(this.uriFrontendService)
        )
        .build();
    }
}
