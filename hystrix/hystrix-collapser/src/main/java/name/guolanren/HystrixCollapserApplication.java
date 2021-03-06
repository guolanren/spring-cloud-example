package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableHystrix
public class HystrixCollapserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixCollapserApplication.class, args);
    }

}
