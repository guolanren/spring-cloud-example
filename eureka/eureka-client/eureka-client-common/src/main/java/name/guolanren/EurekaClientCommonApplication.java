package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author guolanren
 */
@SpringBootApplication
public class EurekaClientCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientCommonApplication.class, args);
    }

}
