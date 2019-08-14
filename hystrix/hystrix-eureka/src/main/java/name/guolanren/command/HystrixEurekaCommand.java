package name.guolanren.command;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author guolanren
 */
@Component
@DefaultProperties(groupKey = "groupKey", threadPoolKey = "threadPoolKey",
        commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
        },
        threadPoolProperties = {
                @HystrixProperty(name = "coreSize", value = "1")
        })
public class HystrixEurekaCommand {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(groupKey = "group-key", commandKey = "command-key", threadPoolKey = "threadPool-key",
            fallbackMethod = "helloFallback")
    public String hello(String name) {
        return restTemplate.getForObject("http://eureka-client/hello?name={name}", String.class, name);
    }

    public String helloFallback(String name) {
        return "hello error";
    }


    @HystrixCommand(fallbackMethod = "hellFallback", ignoreExceptions = {Exception.class})
    public String hell(String name) {
        return restTemplate.getForObject("http://eureka-client/hell?name={name}", String.class);
    }

    public String hellFallback(String name) {
        return "hell error";
    }
}
