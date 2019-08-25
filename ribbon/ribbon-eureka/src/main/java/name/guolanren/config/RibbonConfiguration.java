package name.guolanren.config;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import name.guolanren.component.MyPing;
import name.guolanren.component.MyRule;
import org.springframework.context.annotation.Bean;

/**
 * @author guolanren
 */
public class RibbonConfiguration {

    @Bean
    public IPing ping() {
        return new MyPing();
    }

    @Bean
    public IRule rule() {
        return new MyRule();
    }

}
