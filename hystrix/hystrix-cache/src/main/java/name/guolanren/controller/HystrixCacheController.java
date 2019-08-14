package name.guolanren.controller;

import name.guolanren.command.HystrixCacheCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@RestController
public class HystrixCacheController {

    @Autowired
    private HystrixCacheCommand hystrixCacheCommand;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(hystrixCacheCommand.hello(name));
            stringBuilder.append("<br/>");
        }
        stringBuilder.append("change node by remove cache!!!<br/>");
        hystrixCacheCommand.hell(name);
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(hystrixCacheCommand.hello(name));
            stringBuilder.append("<br/>");
        }
        return stringBuilder.toString();
    }

}
