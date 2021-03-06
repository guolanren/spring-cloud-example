package name.guolanren;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableAdminServer
public class AdminServerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerEurekaApplication.class, args);
    }

}
