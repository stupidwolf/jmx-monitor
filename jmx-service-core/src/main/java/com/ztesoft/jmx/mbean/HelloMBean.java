package com.ztesoft.jmx.mbean;

public interface HelloMBean {
    String getName();

    void setName(String name);

    void helloWorld();

    void helloWorld(String name);
}
