package name.guolanren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author guolanren
 */
@RestController
public class RibbonRetryController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/loadBalanced")
    public String loadBalanced() {
        return restTemplate.getForObject("http://eureka-client-common/hello?name=guolanren", String.class);
    }

}
