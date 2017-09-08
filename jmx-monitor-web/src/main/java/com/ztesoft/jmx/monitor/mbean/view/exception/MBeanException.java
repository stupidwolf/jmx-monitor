package com.ztesoft.jmx.monitor.mbean.view.exception;

public class MBeanException extends RuntimeException{
    public MBeanException() {
        super("Mbean exception");
    }

    public MBeanException(String message) {
        super(message);
    }

    public MBeanException(String message, Throwable cause) {
        super(message, cause);
    }

    public MBeanException(Throwable cause) {
        super(cause);
    }

    public MBeanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
