package com.renho.springcloud.demo.framework.app.configuration;

import com.renho.springcloud.demo.framework.configuration.namedcontext.configuration.MyNamedContextFactory;
import com.renho.springcloud.demo.framework.configuration.namedcontext.configuration.MySpecification;
import com.renho.springcloud.demo.framework.configuration.namedcontext.context.configuration.CommonContextAutoConfiguration;
import com.renho.springcloud.demo.framework.configuration.namedcontext.context.configuration.My1ContextAutoConfiguration;
import com.renho.springcloud.demo.framework.configuration.namedcontext.context.configuration.My2ContextAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author renho
 * @date 2021/1/28
 */
@Configuration
public class NamedContextConfiguration {
    @Bean
    public MyNamedContextFactory getMyNamedContextFactory(){
        MyNamedContextFactory context = new MyNamedContextFactory();
        MySpecification spcification = new MySpecification("m1", new Class[]{My1ContextAutoConfiguration.class});
        MySpecification spcification1 = new MySpecification("m2", new Class[]{My2ContextAutoConfiguration.class});
        MySpecification spcification2 = new MySpecification("default.common", new Class[]{CommonContextAutoConfiguration.class});
        List<MySpecification> spe = new ArrayList<>();
        spe.add(spcification);
        spe.add(spcification1);
        spe.add(spcification2);
        context.setConfigurations(spe);
        return context;
    }
}
