package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 访问规则: API网关地址 + 服务名 + 接口URI
 * @author guolanren
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulEurekaApplication.class, args);
    }

}
