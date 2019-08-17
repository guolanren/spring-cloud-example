package name.guolanren.component;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author guolanren
 */
public class MyRule implements IRule {

    private ILoadBalancer loadBalancer;

    @Override
    public Server choose(Object key) {
        List<Server> servers = loadBalancer.getAllServers();
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.loadBalancer = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return loadBalancer;
    }
}
