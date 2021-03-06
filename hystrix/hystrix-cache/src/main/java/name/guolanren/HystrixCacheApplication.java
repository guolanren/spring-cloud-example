package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableHystrix
public class HystrixCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixCacheApplication.class, args);
    }

}
