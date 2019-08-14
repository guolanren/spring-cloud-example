package name.guolanren.command;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author guolanren
 */
@Component
@DefaultProperties(groupKey = "cache", threadPoolKey = "cache")
public class HystrixCollapserCommand {

    private static final Logger logger = LoggerFactory.getLogger(HystrixCollapserCommand.class);

    @HystrixCollapser(batchMethod = "helloEveryone",
            collapserProperties = {
                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")
            })
    public Future<String> hello(String name) {
        logger.info("执行单个获取的方法");
        return null;
    }

    @HystrixCommand(fallbackMethod = "helloEveryoneFallback")
    public List<String> helloEveryone(List<String> names) {
        if (names.size() > 5) {
            throw new RuntimeException();
        }
        List<String> greets = new ArrayList<>(names.size());
        for (String name : names) {
            greets.add("hello " + name);
        }
        return greets;
    }

    public List<String> helloEveryoneFallback(List<String> names) {
        List<String> errors = new ArrayList<>(names.size());
        for (String name : names) {
            errors.add(String.format("hello %s error", name));
        }
        return errors;
    }
}
