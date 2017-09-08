package com.ztesoft.jmx.monitor.service;

import com.ztesoft.jmx.monitor.dto.ObjectNamesDTO;
import com.ztesoft.jmx.monitor.exception.connection.JmxConnectionInvalidException;
import com.ztesoft.jmx.monitor.model.JmxConnectionModel;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface JmxMonitorService {
    JMXConnector connect(JmxConnectionModel jmxConnectionModel) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, IntrospectionException;

    /**
     *
     * @param mBeanServerConnection  if mBeanServerConnection is null
     * @param objectName if null, query all
     * @param queryExp if null, query all
     * @return ObjectNamesDTO
     * @throws JmxConnectionInvalidException  throw JmxConnectionInvalidException.
     */
    ObjectNamesDTO getObjectNamesDTO(MBeanServerConnection mBeanServerConnection, ObjectName objectName, QueryExp queryExp) throws JmxConnectionInvalidException;

    /**
     * 从session中获取当前获取jmx 连接对象
     * @param session
     * @return
     * @throws JmxConnectionInvalidException
     */
    JMXConnector getCurrentJMXConnector(HttpSession session) throws JmxConnectionInvalidException;
}
