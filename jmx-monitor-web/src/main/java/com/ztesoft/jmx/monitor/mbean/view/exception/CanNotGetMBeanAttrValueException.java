package com.ztesoft.jmx.monitor.mbean.view.exception;

import javax.management.MBeanParameterInfo;

public class CanNotGetMBeanAttrValueException  extends MBeanException {
    public CanNotGetMBeanAttrValueException() {
        super("can not get mbean attr value of attribute.");
    }

    public CanNotGetMBeanAttrValueException(String message) {
        super(message);
    }

    public CanNotGetMBeanAttrValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public CanNotGetMBeanAttrValueException(Throwable cause) {
        super(cause);
    }
}
