package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author guolanren
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerAsymmetricEncryptionDecryptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerAsymmetricEncryptionDecryptionApplication.class, args);
    }

}
