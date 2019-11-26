package name.guolanren.feign;

import name.guolanren.config.EurekaClientCommonFeignClientsConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author guolanren
 */
@FeignClient(value = "eureka-client-common", configuration = EurekaClientCommonFeignClientsConfiguration.class)
public interface EurekaClientCommonService {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);

}
