package name.guolanren.feign;

import feign.hystrix.FallbackFactory;
import name.guolanren.config.EurekaClientCommonFeignClientsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author guolanren
 */
@FeignClient(value = "eureka-client-common",
        fallback = EurekaClientCommonService.EurekaClientServiceFallback.class,
//        fallbackFactory = EurekaClientCommonService.EurekaClientServiceFallbackFactory.class,
        configuration = EurekaClientCommonFeignClientsConfiguration.class)
public interface EurekaClientCommonService {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);

    @Component
    class EurekaClientServiceFallback implements EurekaClientCommonService {
        @Override
        public String hello(String name) {
            return "hello error";
        }
    }

//    @Component
//    class EurekaClientServiceFallbackFactory implements FallbackFactory<EurekaClientCommonService> {
//        private static final Logger logger = LoggerFactory.getLogger(EurekaClientServiceFallbackFactory.class);
//
//        @Override
//        public EurekaClientCommonService create(Throwable cause) {
//            return new EurekaClientCommonService() {
//                @Override
//                public String hello(String name) {
//                    logger.error(cause.getMessage());
//                    return "hello error";
//                }
//            };
//        }
//    }

}
