package name.guolanren.config;

import feign.Request;
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
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }

}
