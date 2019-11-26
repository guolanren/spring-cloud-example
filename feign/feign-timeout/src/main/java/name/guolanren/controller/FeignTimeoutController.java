package name.guolanren.controller;

import name.guolanren.feign.EurekaClientCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@RestController
public class FeignTimeoutController {

    @Autowired
    private EurekaClientCommonService eurekaClientService;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return eurekaClientService.hello(name);
    }

}
