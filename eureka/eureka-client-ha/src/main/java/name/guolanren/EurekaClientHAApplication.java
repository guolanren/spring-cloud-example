package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientHAApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientHAApplication.class, args);
    }

}
