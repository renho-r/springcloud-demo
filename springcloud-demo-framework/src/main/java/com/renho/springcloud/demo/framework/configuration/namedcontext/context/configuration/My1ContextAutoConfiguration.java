package com.renho.springcloud.demo.framework.configuration.namedcontext.context.configuration;

import com.renho.springcloud.demo.framework.configuration.namedcontext.domain.ServerList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author renho
 * @date 2021/1/28
 */
@Configuration
@EnableConfigurationProperties
public class My1ContextAutoConfiguration {

    String client = "m1";

    @Value("${mycontext.name:hello}")
    private String name;

    @Bean
    @ConditionalOnMissingBean
    public ServerList getServerList() {
        return new ServerList(client + ":" + name);
    }
}