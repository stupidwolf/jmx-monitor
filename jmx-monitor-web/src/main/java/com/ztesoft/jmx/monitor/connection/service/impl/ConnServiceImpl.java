package com.ztesoft.jmx.monitor.connection.service.impl;

import com.ztesoft.jmx.monitor.connection.exception.ConnInvalidException;
import com.ztesoft.jmx.monitor.connection.model.ConnModel;
import com.ztesoft.jmx.monitor.connection.service.IConnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

@Service
public class ConnServiceImpl implements IConnService {
    private final static Logger logger = LoggerFactory.getLogger(ConnServiceImpl.class);

    @Override
    public JMXConnector connect(ConnModel connModel) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, IntrospectionException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");

        JMXConnector jmxConnector = JMXConnectorFactory.connect(url,null);

        MBeanServerConnection mBeanServerConnection = jmxConnector.getMBeanServerConnection();
//        jmxConnector.get

        String[] domains = mBeanServerConnection.getDomains();

//        mBeanServerConnection.
        System.out.println("==============domain==================");
        Set<ObjectName> set = mBeanServerConnection.queryNames(null, null);

//                System.out.println(set);

        for (ObjectName objectName :
                set) {
            System.out.println(objectName.getDomain());
//                    System.out.println(objectName.getCanonicalName());

            System.out.println(objectName.getKeyPropertyListString());
        }

        System.out.println("==============attribute=================");

        ObjectName objectName = new ObjectName("jmxBean:name=hello");
        //get objectName info
        MBeanInfo mBeanInfo = mBeanServerConnection.getMBeanInfo(objectName);
        System.out.println("Hello Class:" + mBeanInfo.getClassName());

        MBeanAttributeInfo[] attributeInfos = mBeanInfo.getAttributes();
        for (MBeanAttributeInfo attribute :
                attributeInfos) {
            System.out.println(attribute.getName() + " : " + attribute.getType());
            System.out.println(mBeanServerConnection.getAttribute(objectName, attribute.getName()));
        }

        System.out.println("==================operationInfo=================");
        MBeanOperationInfo[] operationInfos = mBeanInfo.getOperations();
        for (MBeanOperationInfo operationInfo :
                operationInfos) {
            System.out.println(operationInfo.getName() + " : " + operationInfo.getReturnType());
            System.out.println(operationInfo.getDescription());
        }

        System.out.println(jmxConnector.getConnectionId());
//        mBeanServerConnection
        return jmxConnector;
    }

    //TODO 应该从当前session中获取
    @Override
    public JMXConnector getCurrentJMXConnector(HttpSession session) throws ConnInvalidException {
        JMXServiceURL url = null;
        JMXConnector jmxConnector = null;
        try {
            url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
            jmxConnector = JMXConnectorFactory.connect(url,null);

        } catch (MalformedURLException e) {
            logger.error("connect jmx server exception. detail msg: {}", e);
            throw new ConnInvalidException("无法解析jmx连接使用的的url");
        } catch (IOException e) {
            logger.error("connect jmx server exception. detail msg: {}", e);
            throw new ConnInvalidException("由于io原因,无法获取jmx连接");
        }

        if (jmxConnector == null) {
            throw new ConnInvalidException("无法获取jmx连接");
        }

        return jmxConnector;
    }


    public static void main(String[] args) throws IOException, MalformedObjectNameException, IntrospectionException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {

    }
}
