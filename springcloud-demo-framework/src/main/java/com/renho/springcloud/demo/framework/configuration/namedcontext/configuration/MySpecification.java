package com.renho.springcloud.demo.framework.configuration.namedcontext.configuration;

import org.springframework.cloud.context.named.NamedContextFactory;

/**
 * @author renho
 * @date 2021/1/28
 */
public class MySpecification implements NamedContextFactory.Specification {

    private String name;
    private Class<?>[] configuration;

    public MySpecification(String name, Class<?>[] configuration) {
        this.name = name;
        this.configuration = configuration;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<?>[] getConfiguration() {
        return configuration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfiguration(Class<?>[] configuration) {
        this.configuration = configuration;
    }
}