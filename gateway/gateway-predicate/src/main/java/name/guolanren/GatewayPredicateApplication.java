package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import java.time.ZonedDateTime;

/**
 * @author guolanren
 */
@SpringBootApplication
public class GatewayPredicateApplication {

    public static final String EUREKA_CLIENT_SERVICE = "lb://eureka-client";

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/hello").and().after(ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("after"))
                .route(r -> r.path("/hell").and().before(ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("before"))
                .route(r -> r.between(ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]"), ZonedDateTime.parse("2020-12-03T10:15:30+01:00[Europe/Paris]"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("between"))
                .route(r -> r.cookie("who", "guo.*")
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("cookie"))
                .route(r -> r.header("X-Request-Id", "\\d+")
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("header"))
                .route(r -> r.host("**.google.com", "**.apache.org")
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("host"))
                .route(r -> r.method(HttpMethod.GET)
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("method"))
                .route(r -> r.path("/hello")
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("path"))
                .route(r -> r.query("name", "guo.*")
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("query"))
                .route(r -> r.remoteAddr("192.168.1.1/24")
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("remote_addr"))
                .route(r -> r.weight("group1", 8)
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("weight_high"))
                .route(r -> r.weight("group1", 2)
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("weight_low"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayPredicateApplication.class, args);
    }

}
