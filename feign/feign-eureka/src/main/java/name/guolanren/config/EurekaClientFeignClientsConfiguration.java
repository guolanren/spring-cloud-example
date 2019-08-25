package name.guolanren.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author guolanren
 */
public class EurekaClientFeignClientsConfiguration {

    /**
     * 默认ResponseEntityDecoder
     */
//    @Bean
//    public Decoder feignDecoder() {
//        return null;
//    }

    /**
     * 默认SpringEncoder
     */
//    @Bean
//    public Encoder feignEncoder() {
//        return null;
//    }

    /**
     * 默认Slf4jLogger
     */
//    @Bean
//    public Logger feignLogger() {
//        return null;
//    }

    /**
     * 默认SpringMvcContract
     */
//    @Bean
//    public Contract feignContract() {
//        return null;
//    }

    /**
     * 默认HystrixFeign.Builder
     */
//    @Bean
//    public Feign.Builder feignBuilder() {
//        return null;
//    }

    /**
     * 默认LoadBalancerFeignClient
     */
//    @Bean
//    public Client feignClient() {
//        return null;
//    }

//    @Bean
//    public Logger.Level logLevel() {
//        return null;
//    }

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1L), 5);
    }

//    @Bean
//    public ErrorDecoder errorDecoder() {
//        return null;
//    }

//    @Bean
//    public Request.Options options() {
//        return null;
//    }

//    @Bean
//    public RequestInterceptor requestInterceptor1() {
//        return null;
//    }

//    @Bean
//    public RequestInterceptor requestInterceptor2() {
//        return null;
//    }

//    @Bean
//    public SetterFactory setterFactory() {
//        return null;
//    }

}
