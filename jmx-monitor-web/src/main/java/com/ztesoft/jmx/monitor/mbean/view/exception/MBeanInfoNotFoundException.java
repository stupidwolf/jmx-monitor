package com.ztesoft.jmx.monitor.mbean.view.exception;

public class MBeanInfoNotFoundException extends MBeanException {
    public MBeanInfoNotFoundException() {
        super("Can not found MBeanInfo.");
    }

    public MBeanInfoNotFoundException(String message) {
        super(message);
    }
}
