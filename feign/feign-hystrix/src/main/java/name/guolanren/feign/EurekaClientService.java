package name.guolanren.feign;

import name.guolanren.config.EurekaClientFeignClientsConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author guolanren
 */
@FeignClient(value = "eureka-client", fallback = EurekaClientService.EurekaClientServiceFallback.class,
        configuration = EurekaClientFeignClientsConfiguration.class)
public interface EurekaClientService {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);

    @Component
    class EurekaClientServiceFallback implements EurekaClientService {
        @Override
        public String hello(String name) {
            return "hello error";
        }
    }
}
