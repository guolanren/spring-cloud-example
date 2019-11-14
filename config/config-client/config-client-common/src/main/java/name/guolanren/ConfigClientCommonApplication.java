package name.guolanren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guolanren
 */
@SpringBootApplication
public class ConfigClientCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientCommonApplication.class, args);
    }

    @Value("${version:null}")
    private String version;

    @GetMapping("/v")
    public String getVersion() {
        return version;
    }

    @Bean
    @Lazy
    @RefreshScope
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
