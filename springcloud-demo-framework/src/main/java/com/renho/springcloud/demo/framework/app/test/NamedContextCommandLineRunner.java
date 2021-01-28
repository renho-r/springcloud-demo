package com.renho.springcloud.demo.framework.app.test;

import com.renho.springcloud.demo.framework.configuration.namedcontext.domain.ServerList;
import com.renho.springcloud.demo.framework.configuration.namedcontext.configuration.MyNamedContextFactory;
import com.renho.springcloud.demo.framework.configuration.namedcontext.domain.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author renho
 * @date 2021/1/28
 */
@Component
public class NamedContextCommandLineRunner implements CommandLineRunner {

    @Autowired
    private MyNamedContextFactory myNamedContextFactory;

    @Override
    public void run(String... args) throws Exception {
        ServerList serverList = myNamedContextFactory.getServerList("m1");
        System.out.println(serverList.getName());
        IRule rule = myNamedContextFactory.getRule("m1");
        System.out.println(rule.getName());
        serverList = myNamedContextFactory.getServerList("m2");
        System.out.println(serverList.getName());
        rule = myNamedContextFactory.getRule("m2");
        System.out.println(rule.getName());
        serverList = myNamedContextFactory.getServerList("noname");
        System.out.println(serverList.getName());
        rule = myNamedContextFactory.getRule("noname");
        System.out.println(rule.getName());
//        context.getBean(MyContextBean.class);
    }
}
