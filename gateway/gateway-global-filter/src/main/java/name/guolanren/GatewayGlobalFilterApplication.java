package name.guolanren;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.WebClientWriteResponseFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author guolanren
 */
@SpringBootApplication
public class GatewayGlobalFilterApplication {

    private static final Logger log = LoggerFactory.getLogger(GatewayGlobalFilterApplication.class);

    public static final String EUREKA_CLIENT_SERVICE = "lb://eureka-client";

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/hell")
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("route"))
                .build();
    }

    @Bean
    public GlobalFilter customFilter() {
        return new CustomGlobalFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayGlobalFilterApplication.class, args);
    }

    class CustomGlobalFilter implements GlobalFilter, Ordered {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("post filter");
            }));
        }

        @Override
        public int getOrder() {
            return -1;
        }
    }

}
