package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = FeignClientsConfiguration.class)
public class FeignEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaApplication.class, args);
    }

}
