package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulFallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulFallbackApplication.class, args);
    }

}
