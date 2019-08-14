package name.guolanren.controller;

import name.guolanren.command.HystrixCollapserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author guolanren
 */
@RestController
public class HystrixCollapserController {

    @Autowired
    private HystrixCollapserCommand hystrixCollapserCommand;

    @GetMapping("/hello")
    public String hello(@RequestParam String namesStr) throws ExecutionException, InterruptedException {
        String[] names = namesStr.split(",");
        StringBuilder greets = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            greets.append(hystrixCollapserCommand.hello(names[i]).get() + "<br/>");
        }

        return greets.toString();
    }

}
