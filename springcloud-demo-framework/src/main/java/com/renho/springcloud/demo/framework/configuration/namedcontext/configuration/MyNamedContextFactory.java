package com.renho.springcloud.demo.framework.configuration.namedcontext.configuration;

import com.renho.springcloud.demo.framework.configuration.namedcontext.context.configuration.CommonContextAutoConfiguration;
import com.renho.springcloud.demo.framework.configuration.namedcontext.domain.ServerList;
import com.renho.springcloud.demo.framework.configuration.namedcontext.domain.IRule;
import org.springframework.cloud.context.named.NamedContextFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author renho
 * @date 2021/1/28
 */
public class MyNamedContextFactory extends NamedContextFactory<MySpecification> {

    public MyNamedContextFactory() {
        //自定义自动配置类
        super(CommonContextAutoConfiguration.class, "mycontext", "mycontext.name");
    }

    public ServerList getServerList(String name) {
        //自定义接口类型
        return getInstance(name, ServerList.class);
    }

    public IRule getRule(String name) {
        //自定义接口类型
        return getInstance(name, IRule.class);
    }

    @Override
    protected AnnotationConfigApplicationContext getContext(String name) {
        return super.getContext(name);
    }

    public void setProperties() {

    }
}






