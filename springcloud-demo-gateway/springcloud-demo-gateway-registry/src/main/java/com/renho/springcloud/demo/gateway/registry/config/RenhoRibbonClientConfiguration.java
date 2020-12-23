package com.renho.springcloud.demo.gateway.registry.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.PropertiesFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author renho
 * @date 2020/12/23
 */
//@Configuration(proxyBeanMethods = false)
public class RenhoRibbonClientConfiguration {

    @Autowired
    private PropertiesFactory propertiesFactory;

    @Bean
//    @ConditionalOnMissingBean
    public ServerList<?> ribbonServerList(IClientConfig config) {
        return new RenhoServerList();
    }

    @Bean
//    @ConditionalOnMissingBean
    public RenhoServerIntrospector renhoServerIntrospector() {
        return new RenhoServerIntrospector();
    }
}
