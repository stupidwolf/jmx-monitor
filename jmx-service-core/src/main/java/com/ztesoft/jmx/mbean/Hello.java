package com.ztesoft.jmx.mbean;

import com.ztesoft.jmx.mbean.HelloMBean;

import java.io.Serializable;

public class Hello implements HelloMBean, Serializable{
    private static final long serialVersionUID = -9020691567481789138L;

    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void helloWorld() {
        System.out.println("hello, " + this.name);
    }

    @Override
    public void helloWorld(String name) {
        System.out.println("hello, " + name);
    }

}
