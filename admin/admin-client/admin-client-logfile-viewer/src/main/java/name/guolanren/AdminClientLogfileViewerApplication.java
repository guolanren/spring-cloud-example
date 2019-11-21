package name.guolanren;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@SpringBootApplication
@RestController
public class AdminClientLogfileViewerApplication {

    private static Logger logger = LoggerFactory.getLogger(AdminClientLogfileViewerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AdminClientLogfileViewerApplication.class, args);
    }

    @GetMapping("/hi")
    public String hi() {
        logger.info("sth");
        return "hi";
    }
}
