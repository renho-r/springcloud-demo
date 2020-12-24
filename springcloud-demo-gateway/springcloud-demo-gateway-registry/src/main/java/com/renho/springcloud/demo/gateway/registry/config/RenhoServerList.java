package com.renho.springcloud.demo.gateway.registry.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.cloud.nacos.ribbon.NacosServerList;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.google.common.collect.Lists;
import com.netflix.client.config.IClientConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author renho
 * @date 2020/12/23
 */
public class RenhoServerList extends NacosServerList {

    public RenhoServerList(NacosDiscoveryProperties discoveryProperties) {
        super(discoveryProperties);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        super.initWithNiwsConfig(iClientConfig);
    }

    @Override
    public List<NacosServer> getInitialListOfServers() {
        System.out.println("RenhoServerList.getInitialListOfServers");
        if (isMy()) {
            return getServers();
        } else {
            return super.getInitialListOfServers();
        }
    }

    @Override
    public List<NacosServer> getUpdatedListOfServers() {
        System.out.println("RenhoServerList.getUpdatedListOfServers");
        if (isMy()) {
            return getServers();
        } else {
            return super.getUpdatedListOfServers();
        }
    }

    private boolean isMy() {
        return true;
    }

    private List<NacosServer> getServers() {
        List<NacosServer> result = new ArrayList<>();
        return Stream.of("httpbin.org", "localhost").map(host -> {
            Instance instance = new Instance();
            instance.setClusterName("cluster-name");
            instance.setEnabled(true);
            instance.setHealthy(true);
            instance.setInstanceId(super.getServiceId());
            instance.setServiceName(super.getServiceId());
            instance.setIp(host);
            instance.setPort(80);
            NacosServer nacosServer = new NacosServer(instance);
            return nacosServer;
        }).collect(Collectors.toList());
    }
}
