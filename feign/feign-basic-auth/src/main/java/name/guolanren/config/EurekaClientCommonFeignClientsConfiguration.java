package name.guolanren.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @see FeignClientsConfiguration for the defaults
 * @author guolanren
 */
@Configuration
public class EurekaClientCommonFeignClientsConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("username", "password");
    }

}
