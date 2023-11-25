package io.github.paulovieirajr.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCloudGatewayApplication.class, args);
    }

//	public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
//		return routeLocatorBuilder
//				.routes()
//					.route(r -> r.path("clients/**").uri("lb://ms-clientes"))
//				.build();
//	}

}
