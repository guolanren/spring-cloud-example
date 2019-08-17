package name.guolanren.config;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import name.guolanren.component.MyPing;
import name.guolanren.component.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 郭耀展
 */
@Configuration
@RibbonClient(name = "eureka-client")
public class RibbonConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IPing ping() {
        return new MyPing();
    }

    @Bean
    public IRule rule() {
        return new MyRule();
    }
}
