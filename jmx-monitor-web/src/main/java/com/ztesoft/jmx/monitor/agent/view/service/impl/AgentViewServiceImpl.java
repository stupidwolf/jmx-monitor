package com.ztesoft.jmx.monitor.agent.view.service.impl;

import com.ztesoft.jmx.monitor.agent.view.dto.ObjectNamesDTO;
import com.ztesoft.jmx.monitor.agent.view.service.IAgentViewService;
import com.ztesoft.jmx.monitor.connection.exception.ConnInvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.QueryExp;
import java.io.IOException;
import java.util.Set;

@Service
public class AgentViewServiceImpl implements IAgentViewService {
    private Logger logger = LoggerFactory.getLogger(AgentViewServiceImpl.class);
    @Override
    public ObjectNamesDTO getObjectNamesDTO(MBeanServerConnection mBeanServerConnection, ObjectName objectName, QueryExp queryExp) throws ConnInvalidException {
        if (mBeanServerConnection == null) {
            logger.error("mBeanServerConnection can not be null.");
            throw new ConnInvalidException();
        }
        Set<ObjectName> set;
        Integer domainCount;
        try {
            set = mBeanServerConnection.queryNames(objectName, queryExp);
            domainCount = mBeanServerConnection.getMBeanCount();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("connect jmx server exception. detail msg: {}", e);
            throw new ConnInvalidException();
        }
        if(logger.isInfoEnabled()) {
            logger.info("query objectNames: objectName: {}, queryExp: {}, domainCount: {}", objectName, queryExp, domainCount);
        }
        return new ObjectNamesDTO(domainCount, set);
    }

}
