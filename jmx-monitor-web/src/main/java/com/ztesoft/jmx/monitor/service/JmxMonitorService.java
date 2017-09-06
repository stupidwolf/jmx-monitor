package com.ztesoft.jmx.monitor.service;

import com.ztesoft.jmx.monitor.exception.connection.JmxConnectionInvalidException;
import com.ztesoft.jmx.monitor.model.JmxConnectionModel;
import com.ztesoft.jmx.monitor.vo.ObjectNamesVO;

import javax.management.*;
import javax.management.remote.JMXConnector;
import java.io.IOException;

public interface JmxMonitorService {
    JMXConnector connect(JmxConnectionModel jmxConnectionModel) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, IntrospectionException;

    ObjectNamesVO getObjectNamesVO(MBeanServerConnection mBeanServerConnection, ObjectName objectName, QueryExp queryExp) throws JmxConnectionInvalidException, IOException;
}
