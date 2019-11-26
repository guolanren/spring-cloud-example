package name.guolanren.config;

import feign.Logger;
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
    public Logger.Level logLevel() {
        return Logger.Level.FULL;
    }

}
