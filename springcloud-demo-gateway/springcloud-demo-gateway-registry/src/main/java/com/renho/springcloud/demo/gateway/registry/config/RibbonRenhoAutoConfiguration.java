package com.renho.springcloud.demo.gateway.registry.config;

import com.alibaba.cloud.nacos.ribbon.RibbonNacosAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author renho
 * @date 2020/12/23
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties
@ConditionalOnBean(SpringClientFactory.class)
//@ConditionalOnRibbonNacos
//@ConditionalOnNacosDiscoveryEnabled
@AutoConfigureAfter({RibbonAutoConfiguration.class, RibbonNacosAutoConfiguration.class})
@RibbonClients(defaultConfiguration = RenhoRibbonClientConfiguration.class)
public class RibbonRenhoAutoConfiguration {
}
