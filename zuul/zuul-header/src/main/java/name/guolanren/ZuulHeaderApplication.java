package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulHeaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulHeaderApplication.class, args);
    }

}
