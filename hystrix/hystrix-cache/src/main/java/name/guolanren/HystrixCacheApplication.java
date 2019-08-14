package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixCacheApplication.class, args);
    }

}
