package name.guolanren.check;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @author guolanren
 */
@Component
public class ClientHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    private ClientHealthIndicator healthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus currentStatus) {
        Status status = healthIndicator.health().getStatus();
        if (status.equals(Status.UP)) {
            return InstanceInfo.InstanceStatus.UP;
        } else {
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }

}
