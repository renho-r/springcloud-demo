package com.renho.springcloud.demo.gateway.registry.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractServerList;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author renho
 * @date 2020/12/23
 */
public class RenhoServerList extends AbstractServerList<Server> {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        System.out.println("RenhoServerList.initWithNiwsConfig");
    }

    @Override
    public List<Server> getInitialListOfServers() {
        System.out.println("RenhoServerList.getInitialListOfServers");
        return null;
    }

    @Override
    public List<Server> getUpdatedListOfServers() {
        System.out.println("RenhoServerList.getUpdatedListOfServers");
        return null;
    }
}
