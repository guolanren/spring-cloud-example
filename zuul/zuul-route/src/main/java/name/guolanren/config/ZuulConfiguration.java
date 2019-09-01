package name.guolanren.config;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guolanren
 */
@Configuration
public class ZuulConfiguration {

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        // service: service-name-v1 to path: /v1/service-name
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
    }

}
