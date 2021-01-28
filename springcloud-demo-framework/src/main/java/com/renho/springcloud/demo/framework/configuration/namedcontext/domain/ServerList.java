package com.renho.springcloud.demo.framework.configuration.namedcontext.domain;

/**
 * @author renho
 * @date 2021/1/28
 */
public class ServerList {

    private String name;

    public ServerList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
