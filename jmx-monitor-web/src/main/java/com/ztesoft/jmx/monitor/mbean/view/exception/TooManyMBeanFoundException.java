package com.ztesoft.jmx.monitor.mbean.view.exception;

public class TooManyMBeanFoundException extends MBeanException{
    public TooManyMBeanFoundException() {
        super("too many mbean found.");
    }

    public TooManyMBeanFoundException(String message) {
        super(message);
    }
}
