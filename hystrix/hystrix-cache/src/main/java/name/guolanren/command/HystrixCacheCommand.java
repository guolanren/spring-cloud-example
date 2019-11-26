package name.guolanren.command;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author guolanren
 */
@Component
@DefaultProperties(groupKey = "cache", threadPoolKey = "cache")
public class HystrixCacheCommand {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(commandKey = "hello", fallbackMethod = "helloFallback")
    @CacheResult
    public String hello(@CacheKey String name) {
        return restTemplate.getForObject("http://eureka-client-common/hello?name={name}", String.class, name);
    }

    public String helloFallback(String name) {
        return "hello error";
    }


    @HystrixCommand(commandKey = "hell", fallbackMethod = "hellFallback")
    @CacheRemove(commandKey = "hello")
    public String hell(String name) {
        return restTemplate.getForObject("http://eureka-client-common/hell?name={name}", String.class);
    }

    public String hellFallback(String name) {
        return "hell error";
    }
}
