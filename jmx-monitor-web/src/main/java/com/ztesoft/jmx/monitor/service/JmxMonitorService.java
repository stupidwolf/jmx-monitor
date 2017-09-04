package com.ztesoft.jmx.monitor.service;

import com.ztesoft.jmx.monitor.model.JmxConnectionModel;

import javax.management.*;
import java.io.IOException;
import java.net.MalformedURLException;

public interface JmxMonitorService {
    void connect(JmxConnectionModel jmxConnectionModel) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, IntrospectionException;
}
