package com.renho.springcloud.demo.gateway.registry.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServerList;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.PropertiesFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author renho
 * @date 2020/12/23
 */
//@Configuration(proxyBeanMethods = false)
public class RenhoRibbonClientConfiguration {

    @Autowired
    private PropertiesFactory propertiesFactory;

    @Primary
    @Bean
    public ServerList<?> renhoRibbonServerList(IClientConfig config, NacosDiscoveryProperties nacosDiscoveryProperties) {
        if (this.propertiesFactory.isSet(ServerList.class, config.getClientName())) {
            ServerList serverList = this.propertiesFactory.get(ServerList.class, config,
                    config.getClientName());
            return serverList;
        }

        RenhoServerList serverList = new RenhoServerList(nacosDiscoveryProperties);
        serverList.initWithNiwsConfig(config);
        return serverList;
    }
}
