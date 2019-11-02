package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ipresolver.RemoteAddressResolver;
import org.springframework.cloud.gateway.support.ipresolver.XForwardedRemoteAddressResolver;
import org.springframework.context.annotation.Bean;

/**
 * @author guolanren
 */
@SpringBootApplication
public class GatewayProxyRouteApplication {

    public static final String EUREKA_CLIENT_SERVICE = "lb://eureka-client";

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RemoteAddressResolver resolver = XForwardedRemoteAddressResolver.maxTrustedIndex(1);

        return builder.routes()
                .route(r -> r.remoteAddr("10.1.1.1", "10.10.1.1/24")
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("direct-route"))
                .route(r -> r.remoteAddr(resolver, "10.1.1.1", "10.10.1.1/24")
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("proxied-route"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayProxyRouteApplication.class, args);
    }

}
