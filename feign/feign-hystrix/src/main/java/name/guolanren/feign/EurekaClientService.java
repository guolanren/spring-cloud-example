package name.guolanren.feign;

import feign.hystrix.FallbackFactory;
import name.guolanren.config.EurekaClientFeignClientsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author guolanren
 */
@FeignClient(value = "eureka-client",
        fallback = EurekaClientService.EurekaClientServiceFallback.class,
//        fallbackFactory = EurekaClientService.EurekaClientServiceFallbackFactory.class,
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

    @Component
    class EurekaClientServiceFallbackFactory implements FallbackFactory<EurekaClientService> {
        private static final Logger logger = LoggerFactory.getLogger(EurekaClientServiceFallbackFactory.class);

        @Override
        public EurekaClientService create(Throwable cause) {
            return new EurekaClientService() {
                @Override
                public String hello(String name) {
                    logger.error(cause.getMessage());
                    return "hello error";
                }
            };
        }
    }

}
