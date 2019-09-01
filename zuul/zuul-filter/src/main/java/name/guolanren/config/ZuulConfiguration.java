package name.guolanren.config;

import name.guolanren.filter.CustomZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guolanren
 */
@Configuration
public class ZuulConfiguration {

    @Bean
    public CustomZuulFilter customZuulFilter() {
        return new CustomZuulFilter();
    }

}
