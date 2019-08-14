package name.guolanren.controller;

import name.guolanren.command.HystrixDashboardCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@RestController
public class HystrixDashboardController {

    @Autowired
    private HystrixDashboardCommand hystrixEurekaCommand;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return hystrixEurekaCommand.hello(name);
    }

    @GetMapping("/hell")
    public String hell(@RequestParam String name) {
        return hystrixEurekaCommand.hell(name);
    }

}
