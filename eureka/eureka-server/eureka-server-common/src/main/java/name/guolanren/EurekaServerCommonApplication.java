package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerCommonApplication.class, args);
    }

}
