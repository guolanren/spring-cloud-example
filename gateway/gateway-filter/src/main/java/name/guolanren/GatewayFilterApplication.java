package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.DedupeResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.unit.DataSize;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

/**
 * @author guolanren
 */
@SpringBootApplication
public class GatewayFilterApplication {

    public static final String EUREKA_CLIENT_SERVICE = "lb://eureka-client";

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/hello/{who}")
                        .filters(f -> f.addRequestHeader("WHO", "{who}"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("add_request_header"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.addRequestParameter("who", "guolanren"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("add_request_parameter"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.addResponseHeader("who", "guolanren"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("add_response_header"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.dedupeResponseHeader("Access-Control-Allow-Credentials Access-Control-Allow-Origin",
                                DedupeResponseHeaderGatewayFilterFactory.Strategy.RETAIN_FIRST.name()))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("dedupe_response_header"))
                // todo hystrix 复习后再补上
                // todo fallbackHeaders 复习后再补上
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.mapRequestHeader("From-Header", "To-Header"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("map_request_header"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.prefixPath("/context"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("prefix_path"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.preserveHostHeader())
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("preserve_host_header"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.requestRateLimiter(null))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("preserve_host_header"))
                // todo RequestRateLimiterGatewayFilter 不是很懂, 下次再说
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.redirect(302, URI.create("https://www.google.com")))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("redirect"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.removeRequestHeader("X-Request-Foo"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("remove_request_header"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.removeResponseHeader("X-Request-Foo"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("remove_response_header"))
                .route(r -> r.path("/foo/**")
                        .filters(f -> f.rewritePath("/foo(?<segment>/?.*)", "${segment}"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("rewrite_path"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.rewriteLocationResponseHeader("AS_INREQUEST", "Location", null, null))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("rewrite_location_response_header"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.rewriteResponseHeader("X-Response-Foo", "password=[^&]+", "password=***"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("rewrite_response_header"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.saveSession())
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("save_session"))
                .route(r -> r.path("/foo/{segment}")
                        .filters(f -> f.setPath("/{segment}"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("set_path"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.setRequestHeader("X-Request-Foo", "Bar"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("set_request_header"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.setResponseHeader("X-Response-Foo", "Bar"))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("set_response_header"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.setStatus(HttpStatus.NOT_FOUND))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("set_status"))
                .route(r -> r.path("/name/bar/foo")
                        .filters(f -> f.stripPrefix(2))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("strip_prefix"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.retry(retryConfig -> {
                            retryConfig.setRetries(5)
                                    .setStatuses(HttpStatus.BAD_GATEWAY)
                                    .setMethods(HttpMethod.GET)
                                    .setSeries(HttpStatus.Series.SERVER_ERROR)
                                    .setExceptions(IOException.class, TimeoutException.class)
                                    .setBackoff(Duration.ofMillis(10), Duration.ofMillis(50), 2, false);
                        }))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("retry"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.setRequestSize(DataSize.ofMegabytes(5)))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("set_request_size"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.modifyRequestBody(String.class, String.class, MediaType.APPLICATION_JSON_VALUE,
                                (exchange, s) -> Mono.just(s.toUpperCase())))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("modify_request_body"))
                .route(r -> r.alwaysTrue()
                        .filters(f -> f.modifyRequestBody(String.class, String.class, MediaType.APPLICATION_JSON_VALUE,
                                (exchange, s) -> Mono.just(s.toLowerCase())))
                        .uri(EUREKA_CLIENT_SERVICE)
                        .id("modify_response_body"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterApplication.class, args);
    }

}
