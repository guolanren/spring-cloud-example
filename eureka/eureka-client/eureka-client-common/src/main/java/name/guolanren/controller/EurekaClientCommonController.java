package name.guolanren.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author guolanren
 */
@RestController
public class EurekaClientCommonController {

    @Value("${spring.application.name}:${server.port}")
    String fromWhere;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return String.format("hello %s from %s", name, fromWhere);
    }

    @GetMapping("/hell")
    public String hell(@RequestParam String name) {
        return String.format("hell %s from %s", name, fromWhere);
    }

}
