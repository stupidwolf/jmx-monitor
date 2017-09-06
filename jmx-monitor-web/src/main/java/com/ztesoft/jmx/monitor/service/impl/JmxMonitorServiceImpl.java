package com.ztesoft.jmx.monitor.service.impl;

import com.ztesoft.jmx.monitor.exception.connection.JmxConnectionInvalidException;
import com.ztesoft.jmx.monitor.model.JmxConnectionModel;
import com.ztesoft.jmx.monitor.service.JmxMonitorService;
import com.ztesoft.jmx.monitor.vo.ObjectNamesVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

//@Service
public class JmxMonitorServiceImpl implements JmxMonitorService {
    private final static Logger logger = LoggerFactory.getLogger(JmxMonitorServiceImpl.class);

    @Override
    public JMXConnector connect(JmxConnectionModel jmxConnectionModel) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, IntrospectionException {
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

    @Override
    public ObjectNamesVO getObjectNamesVO(MBeanServerConnection mBeanServerConnection, ObjectName objectName, QueryExp queryExp) throws JmxConnectionInvalidException {
        if (mBeanServerConnection == null) {
            throw new JmxConnectionInvalidException();
        }
        Set<ObjectName> set = null;
        Integer domainCount;
        try {
            set = mBeanServerConnection.queryNames(objectName, queryExp);
            domainCount = mBeanServerConnection.getMBeanCount();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("connect jmx server exception. detail msg: {}", (Object[]) e.getStackTrace());
            throw new JmxConnectionInvalidException();
        }
        if(logger.isInfoEnabled()) {
            logger.info("query objectNames: objectName: {}, queryExp: {}, domainCount: {}", objectName, queryExp, domainCount);
        }
        return new ObjectNamesVO(domainCount, set);
    }


    public static void main(String[] args) throws IOException, MalformedObjectNameException, IntrospectionException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        JmxMonitorService jmxMonitorService = new JmxMonitorServiceImpl();
        jmxMonitorService.connect(null);
    }
}
