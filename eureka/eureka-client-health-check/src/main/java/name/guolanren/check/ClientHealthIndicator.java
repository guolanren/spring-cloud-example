package name.guolanren.check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author guolanren
 */
@Component
public class ClientHealthIndicator implements HealthIndicator {

    private volatile Boolean up = true;

    @Override
    public Health health() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            return new Health.Builder()
                    .withDetail("up", "It is healthy")
                    .up()
                    .build();
        } else {
            return new Health.Builder()
                    .withDetail("down", "Something is wrong")
                    .down()
                    .build();
        }
    }

    public Boolean getUp() {
        return up;
    }

    public void setUp(Boolean up) {
        this.up = up;
    }

}
