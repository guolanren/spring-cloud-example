package name.guolanren.feign;

import name.guolanren.config.EurekaClientFeignClientsConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author guolanren
 */
@FeignClient(value = "eureka-client", configuration = EurekaClientFeignClientsConfiguration.class)
public interface EurekaClientService {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);

}
