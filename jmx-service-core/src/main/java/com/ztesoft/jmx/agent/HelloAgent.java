package com.ztesoft.jmx.agent;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import com.ztesoft.jmx.mbean.Hello;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

public class HelloAgent {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        ObjectName helloName = new ObjectName("jmxBean:name=hello");

        server.registerMBean(new Hello(), helloName);

        HtmlAdaptorServer adaptor  = new HtmlAdaptorServer();
        //create adaptor name
        ObjectName adaptorName = new ObjectName("jmxAdaptor:name=adaptor,port=5050");
        //register adaptor and adaptor name
        server.registerMBean(adaptor, adaptorName);

        adaptor.setPort(9999);
        adaptor.start();

        System.out.println("....................server start....................");


        LocateRegistry.createRegistry(1099);
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
        System.out.println("....................begin rmi start.....");
        cs.start();
    }
}
