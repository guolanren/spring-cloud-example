package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableFeignClients
public class FeignUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignUploadApplication.class, args);
    }

}
