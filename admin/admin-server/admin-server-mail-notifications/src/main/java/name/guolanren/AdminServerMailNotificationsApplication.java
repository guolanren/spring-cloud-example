package name.guolanren;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableAdminServer
public class AdminServerMailNotificationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerMailNotificationsApplication.class, args);
    }

}
