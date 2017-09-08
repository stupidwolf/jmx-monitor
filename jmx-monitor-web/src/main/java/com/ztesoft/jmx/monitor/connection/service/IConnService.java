package com.ztesoft.jmx.monitor.connection.service;

import com.ztesoft.jmx.monitor.connection.exception.ConnInvalidException;
import com.ztesoft.jmx.monitor.connection.model.ConnModel;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public interface IConnService {
    JMXConnector connect(ConnModel connModel) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, IntrospectionException;


    /**
     * 从session中获取当前获取jmx 连接对象
     * @param session
     * @return
     * @throws ConnInvalidException
     */
    JMXConnector getCurrentJMXConnector(HttpSession session) throws ConnInvalidException;
}
